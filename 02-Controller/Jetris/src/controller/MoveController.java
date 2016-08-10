package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.gameLogic.logicControllers.JetrisEventDispatcher;
import model.tetrominos.base.TetrominoDirection;
import model.gameLogic.JetrisGame;

public class MoveController implements ActionListener {
    private JetrisGame jetrisGame;
    private TetrominoDirection dir;

    public MoveController(JetrisGame jetrisGame, TetrominoDirection dir) {
        this.jetrisGame = jetrisGame;
        this.dir = dir;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO
    }

}
