package view.guifx;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.block.Block;
import model.gameLogic.JetrisGame;
import model.tetrominos.base.Tetromino;
import view.JetrisView;

/**
 * Created by chris on 08.08.16.
 */
public class JetrisFxView implements JetrisView {
    private JetrisGame jetrisGame;
    private Canvas canvas;

    private int blockSize;
    private int xOffset = 0;
    private int yOffset = 0;

    public JetrisFxView(JetrisGame jetrisGame, Canvas canvas) {
        this.jetrisGame = jetrisGame;
        this.canvas = canvas;

        initConstraints();
    }

    private void initConstraints() {
        //TODO
    }

    @Override
    public void modelChanged() {
        System.out.println("Thread calling modelChanged() -> " + Thread.currentThread());

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread painting to Canvas -> " + Thread.currentThread());

                //TODO
            }
        };

        Platform.runLater(r);
    }

    private Color fxColorFromSwingColor(java.awt.Color swingColor) {
        return new Color(swingColor.getRed() / (double) 255, swingColor.getGreen() / (double) 255, swingColor.getBlue() / (double) 255, 1);
    }
}
