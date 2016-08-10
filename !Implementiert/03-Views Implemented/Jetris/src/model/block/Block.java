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

        if (color != null) {
            this.color = color;
        }
        else {
            this.color = Color.RED;
        }
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
        x += deltaX;
        y += deltaY;
    }

    public void setPos(int newX, int newY) {
        x = newX;
        y = newY;
    }

    public void setColor(Color newColor) {
        if (newColor != null) {
            color = newColor;
        }
    }

    public boolean inCanvas(int width, int height) {
        return x >= 0 && y >= 0 && x < width && y < height;
    }

    //dump
    @Override
    public String toString() {
        return "X = " + x + "; Y = " + y;
    }
}
