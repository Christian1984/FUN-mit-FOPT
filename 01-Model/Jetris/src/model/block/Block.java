package model.block;

import java.awt.Color;

public class Block {
    private int x;
    private int y;
    private Color color;

    //constructors
    public Block(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Block(int x, int y) {
        this(x, y, Color.RED);
    }

    public Block(Color color) {
        this(0, 0);
    }

    public Block() {
        this(Color.RED);
    }

    //getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    //public methods
    public void move(int deltaX, int deltaY) {
        //TODO
    }

    public void setPos(int newX, int newY) {
        //TODO
    }

    public void setColor(Color newColor) {
        //TODO
    }

    public boolean inCanvas(int width, int height) {
        //TODO
        return false;
    }

    //dump
    @Override
    public String toString() {
        return "X = " + x + "; Y = " + y;
    }
}
