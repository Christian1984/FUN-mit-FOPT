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
    //private ButtonControllerPanel buttonContoller;

    protected JPanel infoPanel;
    protected JetrisGame game;

    public JetrisWindow(JetrisGame jetrisGame) {
        this.game = jetrisGame;

        //TODO: set size
        //TODO: create main layout
        //TODO: add GUI view
        //TODO: create eastern info and control panel
        //TODO: add controller panel
        //TODO: add stats view

        //TODO: Shutdown program on window close

        //TODO: add keyboard controller

        //TODO: set visible
    }
}
