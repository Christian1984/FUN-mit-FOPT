package model.tetrominos;

import java.awt.Color;

import model.tetrominos.base.Tetromino;


public class TetroT extends Tetromino {

	/* NORTH	SOUTH	EAST	WEST
     *  1		  3		    	  4
	 *  2 4		4 2		3 2 1	1 2 3
	 *  3		  1		  4		
	 */

    public TetroT(int x, int y) {
        super(x, y);
        setColor(Color.WHITE);
    }

    @Override
    protected void updateBlocks() {
        switch (currDir) {
            case NORTH:
                //TODO
                break;

            case SOUTH:
                //TODO
                break;

            case WEST:
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
                //TODO
                break;

            case SOUTH:
                //TODO
                break;

            case WEST:
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
