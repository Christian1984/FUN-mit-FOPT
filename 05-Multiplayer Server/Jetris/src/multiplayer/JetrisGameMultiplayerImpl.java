package multiplayer;

import model.gameLogic.JetrisGame;
import multiplayer.client.view.MultiplayerStatsView;
import multiplayer.client.RMIDispatcherClient;
import multiplayer.server.MultiplayerService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by chris on 07.04.16.
 */
public class JetrisGameMultiplayerImpl extends JetrisGame implements JetrisGameMultiplayer {
    private MultiplayerService service;
    private JetrisGameMultiplayer gameStub;

    private LinkedList<MultiplayerStatsView> multiplayerStatsViews;

    //constructor
    public JetrisGameMultiplayerImpl() {
        //TODO
    }

    //disconnect on shutdown
    @Override
    public void shutdown() {
        //TODO
    }

    //manage connection to server
    public boolean join(MultiplayerService service, String playerName) {
        //TODO
        return true;
    }

    public void leave() {
        //TODO
    }

    //notify service when a line was cleared
    @Override
    protected int clearFullRows() {
        //TODO
        return 0;
    }

    //update stats received from server
    @Override
    public synchronized void updateMultiplayerStats(ArrayList<PlayerDump> playerStats) throws RemoteException {
        //TODO
    }

    //add rows
    @Override
    public synchronized void addRows(int rows) throws RemoteException {
        //TODO
    }

    protected void shiftUp(int rowsToMove) {
        //TODO
    }

    //local mvc
    public synchronized void addMultiplayerStatsView(MultiplayerStatsView view) {
        //TODO
    }

    public synchronized void removeMultiplayerStatsView(MultiplayerStatsView view) {
        //TODO
    }

    private void fireMultiplayerStatsChanged(ArrayList<PlayerDump> playerStats) {
        //TODO
    }
}
