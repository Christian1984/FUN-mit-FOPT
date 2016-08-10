import multiplayer.ConnectionDetails;
import multiplayer.JetrisGameMultiplayerImpl;
import multiplayer.client.view.JetrisWindowMultiplayer;
import multiplayer.server.MultiplayerService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by chris on 07.04.16.
 */
public class LaunchMultiplayerGuiClient {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Wrong number of arguments. Required: ");
            System.out.println("\t- Server-Address (IP)");
            System.out.println("\t- Player's name");

            System.exit(-1);
        }

        String serverAdress = args[0];
        String name = args[1];

        System.out.println("Joining game. Connecting...");

        MultiplayerService service = getService(serverAdress);

        if (service == null) {
            System.out.println("Could not connect to service. Quitting...");
            System.exit(-2);
        }

        JetrisGameMultiplayerImpl jetrisGame = new JetrisGameMultiplayerImpl();
        jetrisGame.join(service, name);

        new JetrisWindowMultiplayer(jetrisGame);
    }

    public static MultiplayerService getService(String serverAddress) {
        try {
            MultiplayerService service = (MultiplayerService) Naming.lookup("rmi://" + serverAddress
                    + ":" + ConnectionDetails.SERVERPORT
                    + "/" + ConnectionDetails.RMIOBJECTNAME);

            return service;
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return null;
    }
}
