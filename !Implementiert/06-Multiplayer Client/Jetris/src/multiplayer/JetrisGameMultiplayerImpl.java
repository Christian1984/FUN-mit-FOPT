package multiplayer;

import model.gameLogic.JetrisGame;
import multiplayer.client.view.MultiplayerStatsView;
import multiplayer.client.RMIDispatcherClient;
import multiplayer.server.MultiplayerService;

import java.awt.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by chris on 07.04.16.
 */
public class JetrisGameMultiplayerImpl extends JetrisGame implements JetrisGameMultiplayer {
    private MultiplayerService service;
    private JetrisGameMultiplayer gameStub;

    private LinkedList<MultiplayerStatsView> multiplayerStatsViews;

    //constructor
    public JetrisGameMultiplayerImpl() {
        multiplayerStatsViews = new LinkedList<MultiplayerStatsView>();

        try {
            gameStub = (JetrisGameMultiplayer) UnicastRemoteObject.exportObject(this, 0);
            System.out.println("INFO: Object successfully exported!");
        }
        catch (RemoteException e) {
            System.out.println("WARNING: Cannot export object!");
            e.printStackTrace();
        }
    }

    //disconnect on shutdown
    @Override
    public void shutdown() {
        super.shutdown();
        leave();
    }

    //manage connection to server
    public boolean join(MultiplayerService service, String playerName) {
        if (service == null) {
            System.out.println("WARNING: Cannot join. No service available!");
            return false;
        }

        if (gameStub == null) {
            System.out.println("WARNING: Cannot join. Object not exported!");
            return false;
        }

        try {
            boolean success = service.join(gameStub, playerName);

            if (success) {
                System.out.println("INFO: Game joined!");
                this.service = service;

                //send initial stats
                RMIDispatcherClient.sendUpdate(service, gameStub, getScore(), getLevel(), 0);

                return true;
            }
            else {
                System.out.println("WARNING: Could not join game!");
                return false;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return true;
    }

    public void leave() {
        try {
            service.leave(gameStub);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    //notify service when a line was cleared
    @Override
    protected int clearFullRows() {
        int clearedRows = super.clearFullRows();
        RMIDispatcherClient.sendUpdate(service, gameStub, getScore(), getLevel(), clearedRows);

        return clearedRows;
    }

    //update stats received from server
    @Override
    public synchronized void updateMultiplayerStats(ArrayList<PlayerDump> playerStats) throws RemoteException {
        fireMultiplayerStatsChanged(playerStats);
    }

    //add rows
    @Override
    public synchronized void addRows(int rows) throws RemoteException {
        shiftUp(rows);
        fillRows(rows);

        System.out.println("INFO: Added " + rows + " rows!");
    }

    private void shiftUp(int rowsToMove) {
        //shift tetromino
        moveTetro(0, -rowsToMove);

        //shift landed blocks
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (row < height - rowsToMove) {
                    canvas[col][row] = canvas[col][row + rowsToMove];
                }
                else {
                    canvas[col][row] = null;
                }
            }
        }
    }

    private void fillRows(int rows) {
        int gap = new Random().nextInt(getWidth());

        Color color = Color.lightGray;

        for (int row = height - 1; row > height - (rows + 1); row--) {
            for (int col = 0; col < width; col++) {
                if (col != gap) {
                    canvas[col][row] = color;
                }
            }
        }
    }

    //local mvc
    public synchronized void addMultiplayerStatsView(MultiplayerStatsView view) {
        multiplayerStatsViews.add(view);
    }

    public synchronized void removeMultiplayerStatsView(MultiplayerStatsView view) {
        multiplayerStatsViews.remove(view);
    }

    private void fireMultiplayerStatsChanged(ArrayList<PlayerDump> playerStats) {
        for (MultiplayerStatsView v : multiplayerStatsViews) {
            v.statsChanged(playerStats);
        }
    }
}
