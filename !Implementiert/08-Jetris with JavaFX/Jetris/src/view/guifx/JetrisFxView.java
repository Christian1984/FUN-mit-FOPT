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
        blockSize = (int) canvas.getHeight() / jetrisGame.getHeight();
        xOffset = ((int) canvas.getWidth() - jetrisGame.getWidth() * blockSize) / 2;
    }

    @Override
    public void modelChanged() {
        System.out.println("Thread calling modelChanged() -> " + Thread.currentThread());

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread painting to Canvas -> " + Thread.currentThread());

                GraphicsContext gc = canvas.getGraphicsContext2D();
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                gc.setFill(Color.LIGHTGRAY);
                gc.fillRect(xOffset, yOffset, blockSize * jetrisGame.getWidth(), blockSize * jetrisGame.getHeight());
                gc.strokeRect(xOffset, yOffset, blockSize * jetrisGame.getWidth(), blockSize * jetrisGame.getHeight());

                //curr tetromino
                Block[] currTetroBlocks = jetrisGame.getCurrTetroBlocks();

                if (currTetroBlocks != null) {
                    for (Block b : currTetroBlocks) {
                        Color fxColor = fxColorFromSwingColor(b.getColor());
                        gc.setFill(fxColor);

                        gc.fillRect(xOffset + b.getX() * blockSize, yOffset + b.getY() * blockSize,
                                blockSize, blockSize);
                        gc.strokeRect(xOffset + b.getX() * blockSize, yOffset + b.getY() * blockSize,
                                blockSize, blockSize);
                    }
                }

                //landed blocks
                for (int row = 0; row < jetrisGame.getHeight(); row++) {
                    for (int col = 0; col < jetrisGame.getWidth(); col++) {
                        if (jetrisGame.getLandedBlocks()[col][row] != null) {
                            Color fxColor = fxColorFromSwingColor(jetrisGame.getLandedBlocks()[col][row]);
                            gc.setFill(fxColor);

                            gc.fillRect(xOffset + col * blockSize, yOffset + row * blockSize,
                                    blockSize, blockSize);
                            gc.strokeRect(xOffset + col * blockSize, yOffset + row * blockSize,
                                    blockSize, blockSize);
                        }
                    }
                }
            }
        };

        Platform.runLater(r);
    }

    private Color fxColorFromSwingColor(java.awt.Color swingColor) {
        return new Color(swingColor.getRed() / (double) 255, swingColor.getGreen() / (double) 255, swingColor.getBlue() / (double) 255, 1);
    }
}
