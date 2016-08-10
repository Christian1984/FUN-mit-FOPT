package multiplayer;

import multiplayer.JetrisGameMultiplayer;
import multiplayer.PlayerDump;

/**
 * Created by chris on 08.04.16.
 */
public class Player extends PlayerDump {
    private JetrisGameMultiplayer game;

    public Player(String name, JetrisGameMultiplayer game) {
        //TODO
    }

    public JetrisGameMultiplayer getGame() {
        return game;
    }

    public boolean ownsGame(JetrisGameMultiplayer game) {
        //TODO
    }
}
