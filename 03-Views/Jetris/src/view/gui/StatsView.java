package view.gui;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.gameLogic.JetrisGame;
import view.JetrisView;

public class StatsView extends JPanel implements JetrisView {
    private JetrisGame jetrisGame;

    private JLabel lLevel;
    private JLabel lScore;
    private JLabel lLines;

    public StatsView(JetrisGame jetrisGame) {
        this.jetrisGame = jetrisGame;

        //TODO: set layout
        //TODO: init and add labels
    }

    @Override
    public void modelChanged() {
        //create runnable with stuff to update
        Runnable r = new Runnable() {
            @Override
            public void run() {
                //TODO: update labels
            }
        };

        //TODO: invoke via EventQueue
        EventQueue.invokeLater(r);
    }
}
