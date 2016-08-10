import model.gameLogic.JetrisGame;
import ui.gui.JetrisWindow;


public class LaunchJetris {
    public static void main(String[] args) {
        JetrisGame jetrisGame = new JetrisGame();
        new JetrisWindow(jetrisGame);
    }
}
