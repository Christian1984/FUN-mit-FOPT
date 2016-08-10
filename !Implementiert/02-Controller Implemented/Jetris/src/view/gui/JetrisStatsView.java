package view.gui;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.gameLogic.JetrisGame;
import view.JetrisView;

public class JetrisStatsView extends JPanel implements JetrisView {
    private JetrisGame jetrisGame;

    private JLabel lLevel;
    private JLabel lScore;
    private JLabel lLines;

    public JetrisStatsView(JetrisGame jetrisGame) {
        this.jetrisGame = jetrisGame;

        setLayout(new GridLayout(0, 1, 5, 5));

        lLevel = new JLabel();
        lScore = new JLabel();
        lLines = new JLabel();

        //JPanel p = new JPanel(new )
        add(lLevel);
        add(lScore);
        add(lLines);
    }

    @Override
    public void modelChanged() {
        //create runnable with stuff to update
        Runnable r = new Runnable() {
            @Override
            public void run() {
                //System.out.println("Updating gui from Thread: " + Thread.currentThread().getName());

                lLevel.setText("Level: " + jetrisGame.getLevel());
                lScore.setText("Score: " + jetrisGame.getScore());
                lLines.setText("Rows: " + jetrisGame.getLinesCleared());
            }
        };

        //invoke in EventQueue
        EventQueue.invokeLater(r);

    }
}
