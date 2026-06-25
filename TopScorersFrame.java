import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TopScorersFrame extends JFrame {
    private JTable table;
    private PlayerService playerService;

    public TopScorersFrame() {
        setTitle("Top 5 Scorers");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        playerService = new PlayerService();
        String[] columns = {"Username", "Wins", "Losses", "Draws", "Score"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        // TODO: Get Top 5 players from playerService
        ArrayList<Player> topPlayers = playerService.getTopFives();
        // TODO: Add each player data into the table model
        for (Player p : topPlayers) {
            Object[] rowData = {
                p.getUsername(), p.getWins(), p.getLosses(), p.getDraws(), p.getScore()
            };
            model.addRow(rowData);
        }

        table = new JTable(model);
        table.setEnabled(false);
        add(new JScrollPane(table));
    }
}