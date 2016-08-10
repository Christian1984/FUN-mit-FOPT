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
        //TODO

        //add player
        //TODO

        //update all clients with new stats
        //TODO

        //report success
        return true;
    }

    @Override
    public synchronized boolean leave(JetrisGameMultiplayer game) throws RemoteException {
        Player pRemove = null;

        //find player to remove
        //TODO

        //remove player if found
        if (pRemove != null) {
            //TODO
        }

        //report that player could not be removed
        System.out.println("WARNING: Player trying to leave is unknown!");
        return false;
    }

    @Override
    public synchronized void update(JetrisGameMultiplayer game, int newScore, int newLevel, int linesCleared) throws RemoteException {
        //update stats
        //TODO

        //build dump
        //TODO

        //update clients
        for (Player p : players) {
            //TODO
        }
    }

    //private methods
    private ArrayList<PlayerDump> buildPlayerDumpList() {
        //TODO
        return null;
    }

    private void updateOwnerOfGame(JetrisGameMultiplayer game, int newScore, int newLevel) {
        //TODO
    }
}
