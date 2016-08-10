package model.tetrominos;

import java.awt.Color;

import model.tetrominos.base.Tetromino;


public class TetroZ extends Tetromino {

	/* NORTH / SOUTH	EAST / WEST
     *  4 3				    4
	 *    2 1			  2 3
	 *  				  1
	 */

    public TetroZ(int x, int y) {
        super(x, y);
        setColor(Color.ORANGE);
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
