package view.gui;

import java.awt.*;

import javax.swing.*;

import model.gameLogic.JetrisGame;
import view.JetrisView;
import model.block.Block;

public class GuiView extends JPanel implements JetrisView {
    private JetrisGame jetrisGame;

    private JLabel lGameOver;

    int xOffset;
    int yOffset;
    int width;
    int height;
    int blockSize;

    final static int OFFSET_FACTOR = 20;

    public GuiView(JetrisGame jetrisGame) {
        this.jetrisGame = jetrisGame;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        setLayout(new BorderLayout());

        lGameOver = new JLabel("... Game Over - Press Start to Play ...", SwingConstants.CENTER);
        add(lGameOver, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (jetrisGame.isRunning()) {
            initGraphicConstraints();

            g.setColor(Color.darkGray);
            g.fillRect(xOffset, yOffset, width, height);

            synchronized (jetrisGame) {
                //retrieve and iterate through current tero's blocks
                Block[] tetroBlocks = jetrisGame.getCurrTetroBlocks();

                for (Block b : tetroBlocks) {
                    paintBlockAtPositionWithColor(b.getX(), b.getY(), b.getColor(), g);
                }

                //retrieve and iterate through landed blocks
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

    private void initGraphicConstraints() {
        double whRatio = (double) jetrisGame.getWidth() / jetrisGame.getHeight();

         if (this.getHeight() <= this.getWidth() / whRatio) {
             //height is relevant size
             yOffset = this.getHeight() / OFFSET_FACTOR;
             int targetHeight = this.getHeight() - 2 * yOffset;

             blockSize = targetHeight / jetrisGame.getHeight();

             height = blockSize * jetrisGame.getHeight();
             width = (int) (height * whRatio);

             xOffset = (this.getWidth() - width) / 2;
         }
         else {
            //width is relevant size
            xOffset = this.getWidth() / OFFSET_FACTOR;
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
        //update Game-Over-Label
        Runnable r = new Runnable() {
            @Override
            public void run() {
                lGameOver.setVisible(!jetrisGame.isRunning());
            }
        };

        EventQueue.invokeLater(r);

        //repaint canvas
        repaint();
    }

}
