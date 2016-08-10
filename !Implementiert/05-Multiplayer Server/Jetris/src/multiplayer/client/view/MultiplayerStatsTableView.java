package multiplayer.client.view;

import multiplayer.PlayerDump;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by chris on 10.04.16.
 */
public class MultiplayerStatsTableView extends JPanel implements MultiplayerStatsView {
    private JPanel dataPanel;

    public MultiplayerStatsTableView() {
        //TODO
    }

    @Override
    public synchronized void statsChanged(ArrayList<PlayerDump> playersDump) {
        //TODO
    }
}
