package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.gameLogic.JetrisGame;
import model.gameLogic.logicControllers.JetrisEventDispatcher;

public class RotationController implements ActionListener {
    private JetrisGame jetrisGame;
    private boolean clockwise;

    public RotationController(JetrisGame jetrisGame, boolean clockwise) {
        this.jetrisGame = jetrisGame;
        this.clockwise = clockwise;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JetrisEventDispatcher.rotate(jetrisGame, clockwise);
    }

}
