package multiplayer.client.view;

import multiplayer.PlayerDump;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by chris on 10.04.16.
 */
public class MultiplayerStatsTableView extends JPanel implements MultiplayerStatsView {
    private JPanel dataPanel;

    public MultiplayerStatsTableView() {
        setLayout(new BorderLayout());

        dataPanel = new JPanel(new GridLayout(0, 3, 2, 2));
        add(dataPanel, BorderLayout.NORTH);
    }

    @Override
    public synchronized void statsChanged(ArrayList<PlayerDump> playersDump) {
        for (PlayerDump dump : playersDump) {
            System.out.println(dump.toString());
        }

        Runnable r = new Runnable() {
            @Override
            public void run() {
                //delete old labels
                dataPanel.removeAll();

                //add headers
                dataPanel.add(new JLabel("Name"));
                dataPanel.add(new JLabel("Score"));
                dataPanel.add(new JLabel("Level"));

                //add data
                for (PlayerDump dump : playersDump) {
                    dataPanel.add(new JLabel(dump.getName()));
                    dataPanel.add(new JLabel("" + dump.getScore()));
                    dataPanel.add(new JLabel("" + dump.getLevel()));
                }

                revalidate();
                repaint();
            }
        };

        EventQueue.invokeLater(r);
    }
}
