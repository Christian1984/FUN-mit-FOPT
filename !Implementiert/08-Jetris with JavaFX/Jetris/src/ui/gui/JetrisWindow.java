package ui.gui;

import controller.KeyboardController;
import model.gameLogic.JetrisGame;
import view.gui.GuiView;
import view.gui.StatsView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class JetrisWindow extends JFrame {

    protected JPanel infoPanel;
    protected JetrisGame jetrisGame;

    public JetrisWindow(JetrisGame jetrisGame) {
        this.jetrisGame = jetrisGame;

        this.setSize(800, 600);

        setLayout(new BorderLayout(10, 10));

        GuiView guiView = new GuiView(jetrisGame);
        add(guiView, BorderLayout.CENTER);
        jetrisGame.addJetrisView(guiView);

        infoPanel = new JPanel(new BorderLayout(0, 10));
        add(infoPanel, BorderLayout.EAST);

        StatsView statsView = new StatsView(jetrisGame);
        infoPanel.add(statsView, BorderLayout.NORTH);
        jetrisGame.addJetrisView(statsView);

        ButtonControllerPanel bcPanel = new ButtonControllerPanel(jetrisGame);
        infoPanel.add(bcPanel, BorderLayout.SOUTH);
        jetrisGame.addJetrisView(bcPanel);

        //shutdown program on window close
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {
                jetrisGame.shutdown();
                System.exit(0);
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        KeyboardFocusManager m = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        m.addKeyEventDispatcher(new KeyboardController(jetrisGame));

        setVisible(true);
    }
}
