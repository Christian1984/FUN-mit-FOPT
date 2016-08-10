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
        //TODO
    }

    //getters
    public Block[] getBlocks() {
        return blocks;
    }

    //setters
    public void setColor(Color color) {
        //TODO
    }

    //methods
    public final void rotate(boolean clockwise) {
        //TODO
    }

    public final void move(int deltaX, int deltaY) {
        //TODO
    }

    public final void undoRotation() {
        //TODO
    }

    //abstract methods
    protected abstract void updateBlocks();

    //factory
    public final static Tetromino makeRandomTetro(int x, int y) {
        //TODO
        return null;
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
