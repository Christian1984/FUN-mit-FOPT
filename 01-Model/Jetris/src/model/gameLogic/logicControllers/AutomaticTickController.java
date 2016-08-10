package model.gameLogic.logicControllers;

import model.gameLogic.JetrisGame;

public class AutomaticTickController extends Thread {
    private JetrisGame jetrisGame;
    private long delay;
    private boolean isRunning;
    private double levelUpTimeScale;

    public AutomaticTickController(JetrisGame jetrisGame, int initialDelay, double levelUpTimeScale) {
        this.jetrisGame = jetrisGame;
        this.delay = initialDelay;
        this.isRunning = true;
        this.levelUpTimeScale = levelUpTimeScale;

        this.start();
    }

    @Override
    public void run() {
        //TODO: implement loop with delay that calls tick() on model (through dispatcher)
    }

    public synchronized void stopTicker() {
        //TODO: stop ticker
        //TODO: interrupt
    }

    public synchronized void resetTimer() {
        interrupt();
    }

    public synchronized void levelUp() {
        //TODO: update delay
        //TODO interrupt
    }
}
