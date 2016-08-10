package model.tetrominos;

import java.awt.Color;

import model.tetrominos.base.Tetromino;


public class TetroI extends Tetromino {

	/* NORTH / SOUTH	EAST / WEST
     *  X
	 *  O				X O X X
	 *  X
	 *  X
	 */

    public TetroI(int x, int y) {
        super(x, y);
        setColor(Color.BLUE);
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
