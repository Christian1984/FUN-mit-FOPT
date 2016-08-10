package controller;

import java.awt.event.KeyEvent;

import model.gameLogic.JetrisGame;
import model.tetrominos.base.TetrominoDirection;
import model.gameLogic.logicControllers.JetrisEventDispatcher;

public class JetrisKeyEventDispatcher implements java.awt.KeyEventDispatcher {
    JetrisGame gc;

    public JetrisKeyEventDispatcher(JetrisGame gc) {
        this.gc = gc;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            //System.out.println("Key-Code: " + e.getKeyCode());
            //System.out.println("left: " + KeyEvent.VK_LEFT + ", right: " + KeyEvent.VK_RIGHT
            //		+ ", comma: " + KeyEvent.VK_COMMA + ", period: " + KeyEvent.VK_PERIOD);

            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    JetrisEventDispatcher.move(gc, TetrominoDirection.EAST);
                    break;

                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    JetrisEventDispatcher.move(gc, TetrominoDirection.WEST);
                    break;

                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    JetrisEventDispatcher.tick(gc);
                    break;

                case KeyEvent.VK_PERIOD:
                    JetrisEventDispatcher.rotate(gc, true);
                    break;

                case KeyEvent.VK_COMMA:
                    JetrisEventDispatcher.rotate(gc, false);
                    break;

                default:
                    break;
            }

        }

        return false;
    }

	/*@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Key-Code: " + e.getKeyCode());
		System.out.println("left: " + KeyEvent.VK_LEFT + ", right: " + KeyEvent.VK_RIGHT 
				+ ", comma: " + KeyEvent.VK_COMMA + ", period: " + KeyEvent.VK_PERIOD);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}*/

}
