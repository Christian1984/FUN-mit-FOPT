package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.gameLogic.JetrisGame;
import model.gameLogic.logicControllers.JetrisEventDispatcher;

public class StartController implements ActionListener {
    private JetrisGame jetrisGame;

    public StartController(JetrisGame gc) {
        this.jetrisGame = gc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JetrisEventDispatcher.start(jetrisGame);
    }

}
