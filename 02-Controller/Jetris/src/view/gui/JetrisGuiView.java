package view.gui;

import java.awt.*;

import javax.swing.*;

import model.gameLogic.JetrisGame;
import view.JetrisView;
import model.block.Block;

public class JetrisGuiView extends JPanel implements JetrisView {
    private JetrisGame jetrisGame;

    private JLabel lGameOver;

    int xOffset = 5;
    int yOffset = 5;
    int width = 250;
    int height = width;
    int blockSize = width;

    public JetrisGuiView(JetrisGame jetrisGame) {
        this.jetrisGame = jetrisGame;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        setLayout(new BorderLayout());

        lGameOver = new JLabel("... Game Over - Press Start to Play ...", SwingConstants.CENTER);
        //lGameOver.setForeground(Color.WHITE);
        add(lGameOver, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //System.out.println("Painting from Thread: " + Thread.currentThread().getName());

        super.paintComponent(g);

        if (jetrisGame.isRunning()) {
            initGraphicConstraints();

            g.setColor(Color.darkGray);
            g.fillRect(xOffset, yOffset, width, height);

			/*g.setColor(Color.red);
			g.fillRect(xOffset, yOffset, blockSize, blockSize);*/

            if (jetrisGame.isRunning()) {
                Block[] tetroBlocks = jetrisGame.getCurrTetroBlocks();

                for (Block b : tetroBlocks) {
                    //paintBlock(b, g);
                    paintBlockAtPositionWithColor(b.getX(), b.getY(), b.getColor(), g);
                }

				/*for (Block[] bLine : jetrisGame.getLandedBlocks()) {
                    for (Block b : bLine) {
						if (b != null) {
							paintBlock(b, g);
						}
					}
				}*/

				/*for (Color[] bLine : jetrisGame.getLandedBlocks()) {
                    for (Color b : bLine) {
						if (b != null) {
							paintBlock(b, g);
						}
					}
				}*/

                Color[][] colors = jetrisGame.getLandedBlocks();
                for (int x = 0; x < colors.length; x++) {
                    Color[] cCol = colors[x];

                    for (int y = 0; y < cCol.length; y++) {
                        if (cCol[y] != null) {
                            paintBlockAtPositionWithColor(x, y, cCol[y], g);
                        }
                    }
                }
            }
        }
    }

    ;

    private void initGraphicConstraints() {
        double whRatio = (double) jetrisGame.getWidth() / jetrisGame.getHeight();
        //System.out.println("Ratio = " + whRatio);
        //System.out.println("height = " + this.getHeight() + ", width = " + this.getWidth() + ", width * ratio = " + (this.getWidth() * whRatio));

        if (this.getHeight() <= this.getWidth() / whRatio) {
            //height is relevant measure
            //System.out.println("Height is restricting");

            yOffset = this.getHeight() / 20;
            int targetHeight = this.getHeight() - 2 * yOffset;

            blockSize = targetHeight / jetrisGame.getHeight();

            height = blockSize * jetrisGame.getHeight();

            width = (int) (height * whRatio);
            xOffset = (this.getWidth() - width) / 2;

        } else {
            //width is relevant measure
            //System.out.println("Width is restricting");

            xOffset = this.getWidth() / 20;
            int targetWidth = this.getWidth() - 2 * xOffset;

            blockSize = targetWidth / jetrisGame.getWidth();

            width = blockSize * jetrisGame.getWidth();

            height = (int) (width / whRatio);
            yOffset = (this.getHeight() - height) / 2;
        }
    }

    private void paintBlockAtPositionWithColor(int x, int y, Color c, Graphics g) {
        if (x >= 0 && x < jetrisGame.getWidth() && y >= 0 && y < jetrisGame.getHeight()) {
            g.setColor(c);
            g.fillRect(xOffset + blockSize * x, yOffset + blockSize * y, blockSize, blockSize);
        }
    }

    @Override
    public void modelChanged() {
        //System.out.println("Calling repaint from Thread: " + Thread.currentThread().getName());

        //update Game-Over-Label
        Runnable r = new Runnable() {
            @Override
            public void run() {
                lGameOver.setVisible(!jetrisGame.isRunning());
            }
        };

        EventQueue.invokeLater(r);

        //call repaint to update block-area
        repaint();
    }

}
