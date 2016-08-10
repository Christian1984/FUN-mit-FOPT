package multiplayer.server;

import multiplayer.JetrisGameMultiplayer;
import multiplayer.JetrisGameMultiplayerImpl;
import multiplayer.Player;
import multiplayer.PlayerDump;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by chris on 07.04.16.
 */
public class MultiplayerServiceImpl extends UnicastRemoteObject implements MultiplayerService {
    private ArrayList<Player> players;

    public MultiplayerServiceImpl() throws RemoteException {
        players = new ArrayList<Player>();
    }

    @Override
    public synchronized boolean join(JetrisGameMultiplayer game, String name) throws RemoteException {
        //make sure not to add the same player twice
        for (Player p : players) {
            if (p.ownsGame(game)) {
                System.out.println("WARNING: Player cannot join! Already in list!");
                return false;
            }
        }

        //add player
        players.add(new Player(name, game));
        System.out.println("INFO: Player joined");

        //update all clients with new stats
        ArrayList<PlayerDump> dump = buildPlayerDumpList();

        for (Player p : players) {
            RMIDispatcherServer.sendStats(p.getGame(), dump);
        }

        //report success
        return true;
    }

    @Override
    public synchronized boolean leave(JetrisGameMultiplayer game) throws RemoteException {
        Player pRemove = null;

        //find player to remove
        for (Player p : players) {
            if (p.ownsGame(game)) {
                pRemove = p;
                break;
            }
        }

        //remove player if found
        if (pRemove != null) {
            players.remove(pRemove);
            System.out.println("INFO: Player " + pRemove.getName() + " left!");

            return true;
        }

        //report that player could not be removed
        System.out.println("WARNING: Player trying to leave is unknown!");
        return false;
    }

    @Override
    public synchronized void update(JetrisGameMultiplayer game, int newScore, int newLevel, int linesCleared) throws RemoteException {
        //update stats
        updateOwnerOfGame(game, newScore, newLevel);

        //build dump
        ArrayList<PlayerDump> pDump = buildPlayerDumpList();

        //update clients
        for (Player p : players) {
            JetrisGameMultiplayer g = p.getGame();

            //send stats
            RMIDispatcherServer.sendStats(g, pDump);

            //send rows to all player except rows' sender
            if (linesCleared > 1 && !p.ownsGame(game)) {
                RMIDispatcherServer.sendRows(g, linesCleared - 1);
            }
        }
    }

    //private methods
    private ArrayList<PlayerDump> buildPlayerDumpList() {
        ArrayList dump = new ArrayList<PlayerDump>();

        for (Player p : players) {
            dump.add((PlayerDump) p);
        }

        return dump;
    }

    private void updateOwnerOfGame(JetrisGameMultiplayer game, int newScore, int newLevel) {
        for (Player p : players) {
            if (p.ownsGame(game)) {
                p.setScore(newScore);
                p.setLevel(newLevel);

                return;
            }
        }
    }
}
