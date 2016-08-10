package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.tetrominos.base.TetrominoDirection;
import model.gameLogic.JetrisGame;
import model.gameLogic.logicControllers.JetrisEventDispatcher;

public class MoveController implements ActionListener {
    private JetrisGame gc;
    private TetrominoDirection dir;

    public MoveController(JetrisGame gc, TetrominoDirection dir) {
        this.gc = gc;
        this.dir = dir;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JetrisEventDispatcher.move(gc, dir);
    }

}
