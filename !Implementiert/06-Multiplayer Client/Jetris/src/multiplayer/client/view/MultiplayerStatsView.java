package multiplayer.client.view;

import multiplayer.PlayerDump;

import java.util.ArrayList;

/**
 * Created by chris on 08.04.16.
 */
public interface MultiplayerStatsView {
    void statsChanged(ArrayList<PlayerDump> playerDump);
}
