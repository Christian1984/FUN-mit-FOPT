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
                blocks[0].setPos(x - 1, y);
                blocks[1].setPos(x, y);
                blocks[2].setPos(x, y - 1);
                blocks[3].setPos(x + 1, y - 1);
                break;

            default:
                blocks[0].setPos(x, y + 1);
                blocks[1].setPos(x, y);
                blocks[2].setPos(x - 1, y);
                blocks[3].setPos(x - 1, y - 1);
                break;
        }
    }

    @Override
    public String toString() {
        String s = "";

        switch (currDir) {
            case NORTH:
            case SOUTH:
                s = "  X X\n"
                        + "X O";
                break;

            default:
                s = "X\n"
                        + "X O\n"
                        + "  X";
                break;
        }

        s += super.toString();

        return s;
    }

}
