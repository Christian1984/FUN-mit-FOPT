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
                blocks[0].setPos(x, y - 1);
                blocks[1].setPos(x, y);
                blocks[2].setPos(x, y + 1);
                blocks[3].setPos(x, y + 2);
                break;

            default:
                blocks[0].setPos(x - 1, y);
                blocks[1].setPos(x, y);
                blocks[2].setPos(x + 1, y);
                blocks[3].setPos(x + 2, y);
                break;
        }
    }

    @Override
    public String toString() {
        String s = "";

        switch (currDir) {
            case NORTH:
            case SOUTH:
                s = "  X\n  O\n  X\n  X";
                break;

            default:
                s = "X O X X";
                break;
        }

        s += super.toString();

        return s;
    }

}
