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

        //setLayout(new BorderLayout());
        setLayout(new GridLayout(0, 1, 10, 10));

        JPanel p = new JPanel(new GridLayout(0, 1, 5, 5));
        add(p);

        JPanel movePanel = new JPanel(new GridLayout(0, 2));
        p.add(movePanel);

        JPanel rotPanel = new JPanel(new GridLayout(0, 2));
        p.add(rotPanel);

        bMovLeft = new JButton("Left");
        bMovRight = new JButton("Right");
        bRotClockwise = new JButton("Clockwise");
        bRotCountclockwise = new JButton("Counter-Clockwise");
        bTick = new JButton("Down!");
        bStart = new JButton("Start!");

        movePanel.add(bMovLeft);
        movePanel.add(bMovRight);
        rotPanel.add(bRotCountclockwise);
        rotPanel.add(bRotClockwise);
        p.add(bTick);
        p.add(bStart);

        bMovLeft.addActionListener(new MoveController(jetrisGame, TetrominoDirection.WEST));
        bMovRight.addActionListener(new MoveController(jetrisGame, TetrominoDirection.EAST));
        bRotClockwise.addActionListener(new RotationController(jetrisGame, true));
        bRotCountclockwise.addActionListener(new RotationController(jetrisGame, false));
        bTick.addActionListener(new TickController(jetrisGame));
        bStart.addActionListener(new StartController(jetrisGame));
    }

    @Override
    public void modelChanged() {
        bStart.setEnabled(!jetrisGame.isRunning());

        bTick.setEnabled(jetrisGame.isRunning());
        bMovLeft.setEnabled(jetrisGame.isRunning());
        bMovRight.setEnabled(jetrisGame.isRunning());
        bRotClockwise.setEnabled(jetrisGame.isRunning());
        bRotCountclockwise.setEnabled(jetrisGame.isRunning());
    }
}
