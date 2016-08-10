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
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            switch (e.getKeyCode()) {
                //movement
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    JetrisEventDispatcher.move(jetrisGame, TetrominoDirection.EAST);
                    break;

                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    JetrisEventDispatcher.move(jetrisGame, TetrominoDirection.WEST);
                    break;

                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    JetrisEventDispatcher.tick(jetrisGame);
                    break;

                //rotation
                case KeyEvent.VK_PERIOD:
                    JetrisEventDispatcher.rotate(jetrisGame, true);
                    break;

                case KeyEvent.VK_COMMA:
                    JetrisEventDispatcher.rotate(jetrisGame, false);
                    break;

                //default
                default:
                    break;
            }

            return true;
        }

        return false;
    }
}
