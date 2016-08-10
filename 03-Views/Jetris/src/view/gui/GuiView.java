package view.gui;

import java.awt.*;

import javax.swing.*;

import model.gameLogic.JetrisGame;
import view.JetrisView;
import model.block.Block;

public class GuiView extends JPanel implements JetrisView {
    private JetrisGame jetrisGame;

    private JLabel lGameOver;

    int xOffset = 5;
    int yOffset = 5;
    int width;
    int height;
    int blockSize;

    public GuiView(JetrisGame jetrisGame) {
        this.jetrisGame = jetrisGame;

        //TODO: create border
        //TODO: set layout
        //TODO: init gameover-label
    }

    @Override
    protected void paintComponent(Graphics g) {
        //TODO: IMPORTANT: call method of super class

        if (jetrisGame.isRunning()) {
            //TODO: (re-)init canvas size
            //TODO: fill background
            //TODO: paint game canvas

            synchronized (jetrisGame) {
                //TODO: retrieve and iterate through current tero's blocks
                //TODO: retrieve and iterate through landed blocks
            }
        }
    }

    private void initGraphicConstraints() {
        double whRatio = (double) jetrisGame.getWidth() / jetrisGame.getHeight();

         if (this.getHeight() <= this.getWidth() / whRatio) {
            //height is relevant size
            //TODO
         }
         else {
            //width is relevant size
            //TODO
        }
    }

    private void paintBlockAtPositionWithColor(int x, int y, Color c, Graphics g) {
        //TODO
    }

    @Override
    public void modelChanged() {
        //TODO: update Game-Over-Label
        Runnable r = new Runnable() {
            @Override
            public void run() {
                //TODO
            }
        };

        EventQueue.invokeLater(r);

        //TODO: repaint canvas
        repaint();
    }

}
