package multiplayer.server;

import multiplayer.JetrisGameMultiplayer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by chris on 07.04.16.
 */
public interface MultiplayerService extends Remote {
    boolean join(JetrisGameMultiplayer game, String name) throws RemoteException;
    boolean leave(JetrisGameMultiplayer game) throws RemoteException;
    void update(JetrisGameMultiplayer game, int newScore, int newLevel, int linesCleared) throws RemoteException;
}
