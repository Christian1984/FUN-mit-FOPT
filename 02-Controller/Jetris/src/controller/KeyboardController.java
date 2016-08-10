package controller;

import java.awt.event.KeyEvent;

import model.gameLogic.JetrisGame;
import model.tetrominos.base.TetrominoDirection;
import model.gameLogic.logicControllers.JetrisEventDispatcher;

public class KeyboardController implements java.awt.KeyEventDispatcher {
    JetrisGame jetrisGame;

    public KeyboardController(JetrisGame jetrisGame) {
        this.jetrisGame = jetrisGame;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        //TODO

        return false;
    }
}
