package model.gameLogic;

import model.gameLogic.logicControllers.AutomaticTickController;
import model.tetrominos.base.Tetromino;
import model.block.Block;
import view.JetrisView;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class JetrisGame {
    protected final int width;
    protected final int height;

    private boolean gameStarted = false;

    private Tetromino currTetro = null;

    protected Color[][] canvas;

    private int level = 1;
    private int score = 0;
    private int linesCleared = 0;

    static final int SCOREDELTAROW = 100;
    static final int SCORETETROLANDED = 10;
    static final int LINESTOLEVELUP = 10;
    static final int INITIALTICKDELAY = 1000;
    static final double LEVELUPTIMESCALE = 0.75;
    static final boolean KNOWSSUPERSPIN = true;

    private LinkedList<JetrisView> views;

    private AutomaticTickController ticker;

    //constructors
    public JetrisGame(int width, int height) {
        this.width = width;
        this.height = height;

        //TODO
        views = new LinkedList<JetrisView>();
    }

    public JetrisGame() {
        this(10, 20);
    }

    //getters
    //not synchronized (fields declared final)
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public synchronized Block[] getCurrTetroBlocks() {
        return currTetro.getBlocks();
    }

    public synchronized Color[][] getLandedBlocks() {
        return canvas;
    }

    public synchronized boolean isRunning() {
        return gameStarted;
    }

    public synchronized int getLevel() {
        return level;
    }

    public synchronized int getScore() {
        return score;
    }

    public synchronized int getLinesCleared() {
        return linesCleared;
    }

    //private methods
    private void spawn() {
        //TODO: spawn
        //TODO: fire update
    }

    protected void moveTetro(int deltaX, int deltaY) {
        //TODO: move tetro
        //TODO: fire update
    }

    private boolean isTetroColliding() {
        //TODO

        return false;
    }

    private boolean canTetroShift(int deltaX) {
        //TODO

        return true;
    }

    private boolean canTetroSink(int deltaY) {
        //TODO

        return true;
    }

    private void lockTetro() {
        //TODO: check for gameOver
        //TODO: "lock" each block
        //TODO: update score
    }

    protected int clearFullRows() {
        //TODO: iterate through all lines and check if it can be cleared
        //TODO: update score
        //TODO: return number of cleared rows
        return 0;
    }

    private void clearRow(int rowIndex) {
        //TODO: update stats
        //TODO: level up (if required)
        //TODO: clear row and shift rows above
    }

    private synchronized void gameOver() {
        //TODO: stop game
        //TODO: clear current tetro
        //TODO: stop ticker
        //TODO: fire update
    }

    private void levelUp() {
        //TODO
    }

    private void initTicker() {
        //TODO: stop "old" ticker
        //TODO: init and start new ticker
    }

    //public methods
    public synchronized void start() {
        //TODO: clear canvas
        //TODO: init score etc.
        //TODO: start game
        //TODO: spawn first tetro
        //TODO: init ticker
    }

    public void shutdown() {
        //TODO
    }

    public synchronized void tick() {
        //TODO: reset ticker time (user may also cause a tick)
        //TODO: let tetro sink
    }

    public synchronized void rotate(boolean clockwise) {
        //TODO: rotate tetro
        //TODO: if rotation leads to collision, undo
        //TODO: establish superpin
        //TODO: fire update
    }

    public synchronized void left() {
        //TODO
    }

    public synchronized void right() {
        //TODO
    }

    @Override
    public synchronized String toString() {
        //TODO
        return "";
    }

    //mvc
    protected void fireModelChanged() {
        for (JetrisView v : views) {
            v.modelChanged();
        }
    }


    public void addJetrisView(JetrisView v) {
        views.add(v);
        v.modelChanged();
    }
}
