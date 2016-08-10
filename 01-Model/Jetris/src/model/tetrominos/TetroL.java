package model.tetrominos;

import java.awt.Color;

import model.tetrominos.base.Tetromino;


public class TetroL extends Tetromino {

	/* NORTH	SOUTH	EAST	WEST
     *  1		4 3		    		4
	 *  2		  2		3 2 1	1 2 3
	 *  3 4		  1		4		
	 */

    public TetroL(int x, int y) {
        super(x, y);
        setColor(Color.YELLOW);
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
