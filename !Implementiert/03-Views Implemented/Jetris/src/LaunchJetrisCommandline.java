import model.gameLogic.JetrisGame;
import ui.commandline.CommandlineInputBox;
import view.commandline.CommandlineView;

/**
 * Created by chris on 04.07.16.
 */
public class LaunchJetrisCommandline {
    public static void main(String[] args) {
        JetrisGame jetrisGame = new JetrisGame();

        new CommandlineView(jetrisGame);
        new CommandlineInputBox(jetrisGame);
    }
}
