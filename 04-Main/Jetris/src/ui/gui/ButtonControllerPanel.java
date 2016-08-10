package ui.gui;

import model.gameLogic.JetrisGame;
import controller.MoveController;
import controller.RotationController;
import controller.StartController;
import controller.TickController;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

import model.tetrominos.base.TetrominoDirection;
import view.JetrisView;

public class ButtonControllerPanel extends JPanel implements JetrisView {
    private JetrisGame jetrisGame;

    private JButton bMovLeft;
    private JButton bMovRight;
    private JButton bRotClockwise;
    private JButton bRotCountclockwise;
    private JButton bTick;
    private JButton bStart;

    public ButtonControllerPanel(JetrisGame jetrisGame) {
        this.jetrisGame = jetrisGame;

        //TODO: set base layout

        //TODO: create and add main panel
        //TODO: create and add move panel
        //TODO: create and add rot panel
        //TODO: create and add buttons

        //TODO: add listeners to buttons

        //TODO: register view with game
    }

    @Override
    public void modelChanged() {
        //TODO: enable and disable buttons
    }
}
