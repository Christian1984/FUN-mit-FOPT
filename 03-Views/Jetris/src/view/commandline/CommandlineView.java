package view.commandline;

import model.gameLogic.JetrisGame;
import view.JetrisView;

public class CommandlineView implements JetrisView {
    private JetrisGame jetrisGame;
    private String clearScreen;

    public CommandlineView(JetrisGame jetrisGame) {
        //TODO: store reference
        //TODO: build clearScreen-String
        //TODO: (optional) register view
    }

    @Override
    public void modelChanged() {
        //TODO: update view
    }

}
