package model.tetrominos;

import java.awt.Color;

import model.tetrominos.base.Tetromino;


public class TetroS extends Tetromino {

	/* NORTH / SOUTH	EAST / WEST
     *    3 4			4
	 *  1 2				3 2
	 *  				  1
	 */

    public TetroS(int x, int y) {
        super(x, y);
        setColor(Color.MAGENTA);
    }

    @Override
    protected void updateBlocks() {
        switch (currDir) {
            case NORTH:
            case SOUTH:
                //TODO
                break;

            default:
                //TODO
                break;
        }
    }

    @Override
    public String toString() {
        String s = "";

        switch (currDir) {
            case NORTH:
            case SOUTH:
                //TODO
                break;

            default:
                //TODO
                break;
        }

        s += super.toString();

        return s;
    }

}
