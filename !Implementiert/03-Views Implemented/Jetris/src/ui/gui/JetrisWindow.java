package ui.gui;

import controller.KeyboardController;
import model.gameLogic.JetrisGame;
import view.gui.GuiView;
import view.gui.StatsView;

import java.awt.BorderLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JetrisWindow extends JFrame {
    //private JetrisGame gameCanvas;
    //private GuiView guiView;
    //private ButtonController buttonContoller;

    protected JPanel infoPanel;
    protected JetrisGame game;

    public JetrisWindow(JetrisGame jetrisGame) {
        this.game = jetrisGame;

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.setSize(800, 600);

        this.setLayout(new BorderLayout(10, 10));

        GuiView mainGameView = new GuiView(jetrisGame);
        this.add(mainGameView, BorderLayout.CENTER);
        jetrisGame.addJetrisView(mainGameView);

        infoPanel = new JPanel(new BorderLayout(0, 10));
        this.add(infoPanel, BorderLayout.EAST);

        ButtonController buttonController = new ButtonController(jetrisGame);
        infoPanel.add(buttonController, BorderLayout.SOUTH);
        jetrisGame.addJetrisView(buttonController);

        StatsView statsView = new StatsView(jetrisGame);
        infoPanel.add(statsView, BorderLayout.NORTH);
        jetrisGame.addJetrisView(statsView);

        this.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void windowClosed(WindowEvent e) {
                // TODO Auto-generated method stub
                game.shutdown();
                System.exit(0);
            }

            @Override
            public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }
        });

        //this.addKeyListener(new KeyboardController(jetrisGame));
        KeyboardFocusManager m = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        m.addKeyEventDispatcher(new KeyboardController(jetrisGame));

        this.setVisible(true);
    }
}
