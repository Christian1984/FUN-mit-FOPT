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
        //init height and width
        this.width = width;
        this.height = height;

        //init view-list
        views = new LinkedList<JetrisView>();

        canvas = new Color[width][height];
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

    //synchronized
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
        currTetro = Tetromino.makeRandomTetro(width / 2, 0);
        fireModelChanged();
    }

    protected void moveTetro(int deltaX, int deltaY) {
        if (currTetro != null) {
            boolean canMove = false;

            if (deltaX != 0 && canTetroShift(deltaX)) {
                canMove = true;
            }

            if (deltaY != 0) {
                if (canTetroSink(deltaY)) {
                    canMove = true;
                }
                else {
                    lockTetro();

                    if (gameStarted) {
                        clearFullRows();
                        spawn();
                    }
                }
            }

            if (canMove) {
                currTetro.move(deltaX, deltaY);
            }

            fireModelChanged();
        }
    }

    private boolean isTetroColliding() {
        for (Block b : currTetro.getBlocks()) {
            if (b.getX() < 0 || b.getX() >= width || b.getY() >= height) {
                return true;
            }

            if (b.inCanvas(width, height)) {
                if (canvas[b.getX()][b.getY()] != null) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean canTetroShift(int deltaX) {
        for (Block b : currTetro.getBlocks()) {
            if (b.getX() + deltaX < 0 || b.getX() + deltaX >= width) {
                return false;
            }

            if (b.getY() > 0) {
                if (canvas[b.getX() + deltaX][b.getY()] != null) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean canTetroSink(int deltaY) {
        for (Block b : currTetro.getBlocks()) {
            if (b.getY() + deltaY >= height) {
                return false;
            }

            if (canvas[b.getX()][b.getY() + deltaY] != null) {
                return false;
            }
        }

        return true;
    }

    private void lockTetro() {
        for (Block b : currTetro.getBlocks()) {
            if (b.getY() < 0) {
                gameOver();
                return;
            }

            canvas[b.getX()][b.getY()] = b.getColor();
        }

        score += SCORETETROLANDED;
        System.out.println("Tetro locked!");
    }

    protected int clearFullRows() {
        int rowCount = 0;

        for (int row = height - 1; row >= 0; row--) {
            boolean canClear = true;

            for (int col = 0; col < width; col++) {
                if (canvas[col][row] == null) {
                    canClear = false;
                    break;
                }
            }

            if (canClear) {
                clearRow(row);
                rowCount++;
                row++;
            }
        }

        score += SCOREDELTAROW * rowCount * rowCount;

        return rowCount;
    }

    private void clearRow(int rowIndex) {
        //update stats
        linesCleared++;

        if(linesCleared % LINESTOLEVELUP == 0) {
            levelUp();
        }

        //clear row
        for (int row = rowIndex; row >= 0; row--) {
            boolean allCleared = true;

            for (int col = 0; col < width; col++) {
                if (row > 0) {
                    canvas[col][row] = canvas[col][row - 1];
                }
                else {
                    canvas[col][row] = null;
                }

                if (canvas[col][row] != null) {
                    allCleared = false;
                }
            }

            if (allCleared) {
                return;
            }
        }
    }

    private void gameOver() {
        gameStarted = false;
        currTetro = null;

        ticker.stopTicker();

        fireModelChanged();
    }

    private void levelUp() {
        level++;

        if (ticker != null) {
            ticker.levelUp();
        }
    }

    private void initTicker() {
        if (ticker != null) {
            ticker.stopTicker();
        }

        ticker = new AutomaticTickController(this, INITIALTICKDELAY, LEVELUPTIMESCALE);
    }

    //public methods
    public synchronized void start() {
        canvas = new Color[width][height];

        gameStarted = true;
        score = 0;
        linesCleared = 0;
        level = 1;

        spawn();

        initTicker();
    }

    public void shutdown() {
        if (ticker != null) {
            ticker.stopTicker();
        }
    }

    public synchronized void tick() {
        ticker.resetTimer();
        moveTetro(0, 1);
    }

    public synchronized void rotate(boolean clockwise) {
        if (currTetro != null) {
            currTetro.rotate(clockwise);

            if (isTetroColliding()) {
                currTetro.undoRotation();
            }
            else if (KNOWSSUPERSPIN) {
                ticker.resetTimer();
            }

            fireModelChanged();
        }
    }

    public synchronized void left() {
        moveTetro(-1, 0);
    }

    public synchronized void right() {
        moveTetro(1, 0);
    }

    @Override
    public synchronized String toString() {
        String s = "=================================\n";

        for (int row = 0; row < height; row++) {
            if (row < 10) {
                s += " ";
            }

            s += row + "|";

            for (int col = 0; col < width; col++) {
                if (canvas[col][row] != null) {
                    s += "X";
                }
                else {
                    boolean xDrawed = false;

                    //currTetro
                    if (currTetro != null) {
                        for (Block b: currTetro.getBlocks()) {
                            if (col == b.getX() && row == b.getY()) {
                                s += "X";
                                xDrawed = true;
                            }
                        }
                    }

                    if (!xDrawed) {
                        s += " ";
                    }
                }
            }

            s += "|\n";
        }

        s += "   ";

        for (int col = 0; col < width; col++) {
            s += col;
        }

        s += "\n=================================";
        s += "\nLines cleared: " + linesCleared;
        s += "\nScore: " + score;

        return s;
    }

    //mvc
    protected synchronized void fireModelChanged() {
        for (JetrisView v : views) {
            v.modelChanged();
        }
    }

    public synchronized void addJetrisView(JetrisView v) {
        views.add(v);
        v.modelChanged();
    }
}
