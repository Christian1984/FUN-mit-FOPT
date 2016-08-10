package multiplayer.client;

import multiplayer.JetrisGameMultiplayer;
import multiplayer.server.MultiplayerService;

import java.rmi.RemoteException;

/**
 * Created by chris on 06.04.16.
 */
public class RMIDispatcherClient {
    public static void sendUpdate(MultiplayerService service, JetrisGameMultiplayer gameStub, int score, int level, int clearedRows) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                if (service != null && gameStub != null) {

                    System.out.println("Sending update...");

                    try {
                        service.update(gameStub, score, level, clearedRows);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(r).start();
    }
}
