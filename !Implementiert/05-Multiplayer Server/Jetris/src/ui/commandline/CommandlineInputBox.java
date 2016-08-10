package ui.commandline;

import model.gameLogic.JetrisGame;
import ui.gui.ButtonControllerPanel;
import view.JetrisView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by chris on 04.07.16.
 */
public class CommandlineInputBox extends JFrame {
    public CommandlineInputBox(JetrisGame jetrisGame) {
        ButtonControllerPanel bcPanel = new ButtonControllerPanel(jetrisGame);

        add(bcPanel);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(250, 250);
        setVisible(true);
    }
}
