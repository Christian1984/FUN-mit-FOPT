package model.tetrominos;

import java.awt.Color;

import model.tetrominos.base.Tetromino;


public class TetroO extends Tetromino {

	/* NORTH / SOUTH / EAST / WEST
     *  4 3
	 *  2 1	
	 */

    public TetroO(int x, int y) {
        super(x, y);
        setColor(Color.GREEN);
    }

    @Override
    protected void updateBlocks() {
        //TODO
    }

    @Override
    public String toString() {
        String s = "";
        //TODO

        s += super.toString();

        return s;
    }

}
