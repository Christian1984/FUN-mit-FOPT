package controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import model.gameLogic.JetrisGame;
import model.gameLogic.logicControllers.JetrisEventDispatcher;
import model.tetrominos.base.TetrominoDirection;

/**
 * Created by chris on 08.08.16.
 */
public class JetrisFxController {
    private JetrisGame jetrisGame;

    @FXML
    private Canvas canvas;

    @FXML
    private Label scoreLabel;

    @FXML
    private Label levelLabel;

    @FXML
    private Label linesClearedLabel;

    //setter
    public void setJetrisGame(JetrisGame jetrisGame) {
        this.jetrisGame = jetrisGame;
    }

    //getter
    public Canvas getCanvas() {
        return canvas;
    }

    public Label getScoreLabel() {
        return scoreLabel;
    }

    public Label getLevelLabel() {
        return levelLabel;
    }

    public Label getLinesClearedLabel() {
        return linesClearedLabel;
    }

    //ActionEvents
    @FXML
    public void start() {
        JetrisEventDispatcher.start(jetrisGame);
    }

    @FXML
    public void moveLeft() {
        JetrisEventDispatcher.move(jetrisGame, TetrominoDirection.WEST);
    }

    @FXML
    public void moveRight() {
        JetrisEventDispatcher.move(jetrisGame, TetrominoDirection.EAST);
    }

    @FXML
    public void tick() {
        JetrisEventDispatcher.tick(jetrisGame);
    }

    @FXML
    public void rotateClockwise() {
        JetrisEventDispatcher.rotate(jetrisGame, true);
    }

    @FXML
    public void rotateCounterclockwise() {
        JetrisEventDispatcher.rotate(jetrisGame, false);
    }
}
