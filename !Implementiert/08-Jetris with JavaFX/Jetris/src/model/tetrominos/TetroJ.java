package model.tetrominos;

import java.awt.Color;

import model.tetrominos.base.Tetromino;


public class TetroJ extends Tetromino {

	/* NORTH	SOUTH	EAST	WEST
     *    1		3 4		4
	 *    2		2		3 2 1	1 2 3
	 *  4 3		1				    4
	 */

    public TetroJ(int x, int y) {
        super(x, y);
        setColor(Color.RED);
    }

    @Override
    protected void updateBlocks() {
        switch (currDir) {
            case NORTH:
                blocks[0].setPos(x, y - 1);
                blocks[1].setPos(x, y);
                blocks[2].setPos(x, y + 1);
                blocks[3].setPos(x - 1, y + 1);
                break;

            case SOUTH:
                blocks[0].setPos(x, y + 1);
                blocks[1].setPos(x, y);
                blocks[2].setPos(x, y - 1);
                blocks[3].setPos(x + 1, y - 1);
                break;

            case WEST:
                blocks[0].setPos(x - 1, y);
                blocks[1].setPos(x, y);
                blocks[2].setPos(x + 1, y);
                blocks[3].setPos(x + 1, y + 1);
                break;

            default:
                blocks[0].setPos(x + 1, y);
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
                s = "  X\n" +
                        "  O\n" +
                        "  X X";
                break;

            case SOUTH:
                s = "X X\n" +
                        "  O\n" +
                        "  X";
                break;

            case EAST:
                s = "X\n" +
                        "X O X";
                break;

            default:
                s = "\n" +
                        "X O X\n" +
                        "    X";
                break;
        }

        s += super.toString();

        return s;
    }

}
