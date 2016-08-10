package model.tetrominos.base;

import java.awt.Color;
import java.util.Random;

import model.tetrominos.*;
import model.block.Block;

public abstract class Tetromino {
    protected Block[] blocks;

    protected int x;
    protected int y;
    protected TetrominoDirection currDir = TetrominoDirection.NORTH;
    protected TetrominoDirection prevDir = currDir;

    //constructor
    protected Tetromino(int x, int y) {
        this.x = x;
        this.y = y;

        blocks = new Block[4];
        for (int i = 0; i < blocks.length; i++) {
            blocks[i] = new Block();
        }

        updateBlocks();
    }

    //getters
    public Block[] getBlocks() {
        return blocks;
    }

    //setters
    public void setColor(Color color) {
        for (Block b : blocks) {
            b.setColor(color);
        }
    }

    //methods
    public final void rotate(boolean clockwise) {
        int curr = currDir.ordinal();
        int next = clockwise ? (curr + 1) : (curr - 1);

        if (next < 0) {
            next = 3;
        }
        else if (next > 3){
            next = 0;
        }

        prevDir = currDir;
        currDir = TetrominoDirection.values()[next];

        updateBlocks();
    }

    public final void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;

        updateBlocks();
    }

    public final void undoRotation() {
        currDir = prevDir;
        updateBlocks();
    }

    //abstract methods
    protected abstract void updateBlocks();

    //factory
    public final static Tetromino makeRandomTetro(int x, int y) {
        TetrominoType[] types = TetrominoType.values();

        Random r = new Random();
        int pick = r.nextInt(types.length);
        TetrominoType tPick = types[pick];

        Tetromino tetro = null;

        switch (tPick) {
            case I:
                tetro = new TetroI(x, y);
                break;
            case J:
                tetro = new TetroJ(x, y);
                break;
            case L:
                tetro = new TetroL(x, y);
                break;
            case O:
                tetro = new TetroO(x, y);
                break;
            case S:
                tetro = new TetroS(x, y);
                break;
            case T:
                tetro = new TetroT(x, y);
                break;
            case Z:
                tetro = new TetroZ(x, y);
                break;
            default:
                tetro = new TetroL(x, y);
                break;
        }

        System.out.println("Tetromino created:\n" + tetro.toString());

        return tetro;
    }

    public final static Tetromino makeRandomTetro() {
        return makeRandomTetro(0, 0);
    }

    //dump
    @Override
    public String toString() {
        String s = "";

        s += "\nDirection " + currDir + "\n";
        s += blocks[0].toString() + " | "
                + blocks[1].toString() + " | "
                + blocks[2].toString() + " | "
                + blocks[3].toString();
        s += "\n--------------------------";

        return s;
    }
}
