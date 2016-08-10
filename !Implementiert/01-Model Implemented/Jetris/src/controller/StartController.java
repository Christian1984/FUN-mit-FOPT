package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.gameLogic.JetrisGame;
import model.gameLogic.logicControllers.JetrisEventDispatcher;

public class StartController implements ActionListener {
    private JetrisGame gc;

    public StartController(JetrisGame gc) {
        this.gc = gc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JetrisEventDispatcher.start(gc);
    }

}
