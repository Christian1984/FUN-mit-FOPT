package multiplayer.server;

import multiplayer.JetrisGameMultiplayer;
import multiplayer.PlayerDump;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by chris on 06.04.16.
 */
public class RMIDispatcherServer {
    public static void sendRows(JetrisGameMultiplayer game, int rows) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    game.addRows(rows);
                }
                catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(r).start();
    }

    public static void sendStats(JetrisGameMultiplayer game, ArrayList<PlayerDump> playersDump) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    game.updateMultiplayerStats(playersDump);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(r).start();
    }
}
