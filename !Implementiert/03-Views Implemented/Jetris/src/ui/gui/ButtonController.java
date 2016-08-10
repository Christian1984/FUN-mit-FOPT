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

public class ButtonController extends JPanel implements JetrisView {
    private JetrisGame jetrisGame;

    private JButton bMovLeft;
    private JButton bMovRight;
    private JButton bRotClockwise;
    private JButton bRotCountclockwise;
    private JButton bTick;
    private JButton bStart;

    public ButtonController(JetrisGame jetrisGame) {
        this.jetrisGame = jetrisGame;

        //setLayout(new GridLayout(0, 1, 10, 10));
        setLayout(new BorderLayout());

        bMovLeft = new JButton("Left");
        bMovRight = new JButton("Right");
        bRotClockwise = new JButton("Clockwise");
        bRotCountclockwise = new JButton("Counter-Clockwise");
        bTick = new JButton("Tick!");
        bStart = new JButton("Start!");

        JPanel p = new JPanel(new GridLayout(0, 1, 5, 5));
        JPanel movePanel = new JPanel(new GridLayout(0, 2));
        JPanel rotPanel = new JPanel(new GridLayout(0, 2));

        movePanel.add(bMovLeft);
        movePanel.add(bMovRight);
        rotPanel.add(bRotCountclockwise);
        rotPanel.add(bRotClockwise);

        p.add(rotPanel);
        p.add(movePanel);
        p.add(bTick);

		/*p.add(new JLabel("Move"));
        p.add(bMovLeft);
		p.add(bMovRight);
		
		p.add(new JLabel());
		p.add(new JLabel("Rotate"));
		p.add(bRotClockwise);
		p.add(bRotCountclockwise);*/

        p.add(new JLabel());
        p.add(new JLabel("Gamemechanics"));
        //p.add(bTick);
        p.add(bStart);

        add(p, BorderLayout.SOUTH);

        //TODO: Add Listeners
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
