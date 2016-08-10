package view.guifx;

import javafx.application.Platform;
import javafx.scene.control.Label;
import model.gameLogic.JetrisGame;
import view.JetrisView;

/**
 * Created by chris on 09.08.16.
 */
public class JetrisFxStatsView implements JetrisView {
    private JetrisGame jetrisGame;

    private Label scoreLabel;
    private Label levelLabel;
    private Label linesClearedLabel;

    public JetrisFxStatsView(JetrisGame jetrisGame, Label scoreLabel, Label levelLabel, Label linesClearedLabel) {
        this.jetrisGame = jetrisGame;
        this.scoreLabel = scoreLabel;
        this.levelLabel = levelLabel;
        this.linesClearedLabel = linesClearedLabel;
    }

    @Override
    public void modelChanged() {
        //TODO
    }
}
