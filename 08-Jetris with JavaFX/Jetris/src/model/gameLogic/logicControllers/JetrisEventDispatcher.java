package model.gameLogic.logicControllers;

import model.tetrominos.base.TetrominoDirection;
import model.gameLogic.JetrisGame;

public class JetrisEventDispatcher {
    public static void start(JetrisGame jetrisGame) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                jetrisGame.start();
            }
        };

        new Thread(r).start();
    }

    public static void tick(JetrisGame jetrisGame) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                jetrisGame.tick();
            }
        };

        new Thread(r).start();
    }

    public static void move(JetrisGame jetrisGame, TetrominoDirection dir) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                switch (dir) {
                    case EAST:
                        jetrisGame.right();
                        break;

                    case WEST:
                        jetrisGame.left();
                        break;

                    default:
                        break;
                }
            }
        };

        new Thread(r).start();
    }

    public static void rotate(JetrisGame jetrisGame, boolean clockwise) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                jetrisGame.rotate(clockwise);
            }
        };

        new Thread(r).start();
    }

}
