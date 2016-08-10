package multiplayer.client.view;

import model.gameLogic.JetrisGame;
import multiplayer.JetrisGameMultiplayer;
import multiplayer.JetrisGameMultiplayerImpl;
import ui.gui.JetrisWindow;
import view.gui.GuiView;

import java.awt.*;

/**
 * Created by chris on 10.04.16.
 */
public class JetrisWindowMultiplayer extends JetrisWindow {
    public JetrisWindowMultiplayer(JetrisGameMultiplayerImpl jetrisGame) {
        super(jetrisGame);

        MultiplayerStatsTableView statsView = new MultiplayerStatsTableView();
        jetrisGame.addMultiplayerStatsView(statsView);

        infoPanel.add(statsView, BorderLayout.CENTER);
    }
}
