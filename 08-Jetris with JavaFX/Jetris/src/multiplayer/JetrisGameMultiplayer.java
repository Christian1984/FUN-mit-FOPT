package multiplayer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by chris on 07.04.16.
 */
public interface JetrisGameMultiplayer extends Remote {
    void updateMultiplayerStats(ArrayList<PlayerDump> playerStats) throws RemoteException;
    void addRows(int count) throws RemoteException;
}
