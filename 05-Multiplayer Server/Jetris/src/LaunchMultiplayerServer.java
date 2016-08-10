import java.rmi.RemoteException;

/**
 * Created by chris on 07.04.16.
 */
public class LaunchMultiplayerServer {
    public static void main(String args[]) {
        try {
            //create rmi registry
            //TODO

            //create game service and bind
            //TODO

            //status
            System.out.println("Server started!");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
