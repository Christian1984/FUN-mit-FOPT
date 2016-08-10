import multiplayer.ConnectionDetails;
import multiplayer.server.MultiplayerService;
import multiplayer.server.MultiplayerServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by chris on 07.04.16.
 */
public class LaunchMultiplayerServer {
    public static void main(String args[]) {
        try {
            //create rmi registry
            Registry r = LocateRegistry.createRegistry(ConnectionDetails.SERVERPORT);

            //create game service and bind
            MultiplayerService service = new MultiplayerServiceImpl();
            r.rebind(ConnectionDetails.RMIOBJECTNAME, service);

            //status
            System.out.println("Server started!");
        } catch (RemoteException e) {
            System.out.println("Server could not be started! Reason:");
            e.printStackTrace();
        }
    }
}
