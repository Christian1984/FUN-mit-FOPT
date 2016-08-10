package ui.commandline;

import model.gameLogic.JetrisGame;
import ui.gui.ButtonController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by chris on 04.07.16.
 */
public class CommandlineInputBox extends JFrame {
    public CommandlineInputBox(JetrisGame jetrisGame) throws HeadlessException {
        ButtonController buttonController = new ButtonController(jetrisGame);

        add(buttonController);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(250, 250);
        setVisible(true);
    }
}
