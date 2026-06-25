import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {
    private Player currentPlayer;
    private PlayerService playerService;
    private GameLogic gameLogic;
    private JButton[] buttons;

    public GameFrame(Player player) {
        this.currentPlayer = player;
        this.playerService = new PlayerService();
        this.gameLogic = new GameLogic();
        this.buttons = new JButton[9];

        setTitle("Tic-Tac-Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));
        setLocationRelativeTo(null);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 60));
            buttons[i].setFocusPainted(false);
            
            final int index = i;
            buttons[i].addActionListener(e -> handlePlayerMove(index));
            add(buttons[i]);
        }
    }

    private void handlePlayerMove(int index) {
        // TODO: Make player move using gameLogic.makeMove(index, 'X')
        if (!gameLogic.makeMove(index, 'X')) return;
        // TODO: Update button text to X
        buttons[index].setText("X");
        
        // TODO: Check whether player wins
        if (gameLogic.checkWinner('X')) {
            finishGame("WIN");
            return;
        }

        // TODO: Check draw
        if (gameLogic.isDraw()) {
            finishGame("DRAW");
            return;
        }

        // TODO: Generate computer move
        int compIndex = gameLogic.computerMove();
        if (compIndex != -1) {
            gameLogic.makeMove(compIndex, 'O');
        // TODO: Update computer button text to O
            buttons[compIndex].setText("O");
        // TODO: Check whether computer wins
            if (gameLogic.checkWinner('O')) {
                finishGame("LOSE");
                return;
            }
        }
    }

    private void finishGame(String result) {
        playerService.updateStatistics(currentPlayer, result);

        // TODO: Update database statistics after game ends
        if (result == "WIN") {
            currentPlayer.setWins(currentPlayer.getWins() + 1);
            currentPlayer.setScore(currentPlayer.getScore() + 10);
        } else if (result == "LOSE") {
            currentPlayer.setLosses(currentPlayer.getLosses() + 1);
        } else if (result == "DRAW") {
            currentPlayer.setDraws(currentPlayer.getDraws() + 1);
            currentPlayer.setScore(currentPlayer.getScore() + 3);
        }

        JOptionPane.showMessageDialog(this, "Game result: " + result);
        MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
        menuFrame.setVisible(true);
        this.dispose();
    }
}