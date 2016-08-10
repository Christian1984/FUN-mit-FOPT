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
        blocks[0].setPos(x + 1, y);
        blocks[1].setPos(x, y);
        blocks[2].setPos(x + 1, y - 1);
        blocks[3].setPos(x, y - 1);
    }

    @Override
    public String toString() {
        String s = "X X\n" +
                "O X";

        s += super.toString();

        return s;
    }

}
