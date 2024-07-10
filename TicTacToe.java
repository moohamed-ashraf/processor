import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.sound.sampled.*;

public class TicTacToe {
    int boardWidth = 600;
    int boardHeight = 650;
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JButton[][] board = new JButton[3][3];
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;
    boolean gameOver = false;
    int turns = 0;
    int scoreX = 0;
    int scoreO = 0;
    JButton[] winningButtons = new JButton[3];

   public TicTacToe() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.DARK_GRAY);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD, 40));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe: X's turn");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);

        initializeBoard();
    }

    void initializeBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);
                tile.setBackground(Color.DARK_GRAY);
                tile.setForeground(Color.white);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);
                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (gameOver) return;
                        JButton tile = (JButton) e.getSource();
                        makeSound();
                        if (tile.getText().isEmpty()) {
                        makeSound();

                            tile.setText(currentPlayer);

                            turns++;
                            checkWinner();
                            togglePlayer();
                        }
                    }
                });
            }
        }
    }
    // Method to play sound
    public void makeSound() {
        try {
            // Adjust the file path to the location of your sound file
            File soundFile = new File("C:\\Users\\Jessica\\Desktop\\TicTacToe\\src\\mixkit-cool-interface-click-tone-2568.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
        // Method to play sound
        public void makeSound1() {
            try {
                // Adjust the file path to the location of your sound file
                File soundFile = new File("C:\\Users\\Jessica\\Desktop\\TicTacToe\\src\\mixkit-8-bit-lose-2031.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }
        // Method to play sound
        public void makeSound2() {
            try {
                // Adjust the file path to the location of your sound file
                File soundFile = new File("C:\\Users\\Jessica\\Desktop\\TicTacToe\\src\\mixkit-video-game-win-2016.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }


    void togglePlayer() {
        currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
        textLabel.setText("Tic-Tac-Toe: " + currentPlayer + "'s turn");
    }



    void checkWinner() {
        if (checkLines(playerX) || checkLines(playerO) || checkDiagonals(playerX) || checkDiagonals(playerO)) {
            gameOver = true;
            textLabel.setText(currentPlayer + " wins! Score - X: " + scoreX + ", O: " + scoreO);
            highlightWinner();
            askToPlayAgain();
        } else if (turns == 9) {
            gameOver = true;
            textLabel.setText("It's a tie! Score - X: " + scoreX + ", O: " + scoreO);
            setTieColor();
            askToPlayAgain();
        }
    }

    boolean checkLines(String player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getText().equals(player) && board[i][1].getText().equals(player) && board[i][2].getText().equals(player)) {
                if (player.equals(playerX)) scoreX++;
                else scoreO++;
                winningButtons[0] = board[i][0];
                winningButtons[1] = board[i][1];
                winningButtons[2] = board[i][2];
                return true;
            }
            if (board[0][i].getText().equals(player) && board[1][i].getText().equals(player) && board[2][i].getText().equals(player)) {
                if (player.equals(playerX)) scoreX++;
                else scoreO++;
                winningButtons[0] = board[0][i];
                winningButtons[1] = board[1][i];
                winningButtons[2] = board[2][i];
                return true;
            }
        }
        return false;
    }

    boolean checkDiagonals(String player) {
        if (board[0][0].getText().equals(player) && board[1][1].getText().equals(player) && board[2][2].getText().equals(player)) {
            if (player.equals(playerX)) scoreX++;
            else scoreO++;
            winningButtons[0] = board[0][0];
            winningButtons[1] = board[1][1];
            winningButtons[2] = board[2][2];
            return true;
        }
        if (board[0][2].getText().equals(player) && board[1][1].getText().equals(player) && board[2][0].getText().equals(player)) {
            if (player.equals(playerX)) scoreX++;
            else scoreO++;
            winningButtons[0] = board[0][2];
            winningButtons[1] = board[1][1];
            winningButtons[2] = board[2][0];
            return true;
        }
        return false;
    }

    void highlightWinner() {
        for (JButton button : winningButtons) {
            button.setBackground(Color.GREEN);
            makeSound2();
        }
    }

    void setTieColor() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c].setBackground(Color.ORANGE);
                makeSound1();
            }
        }
    }

    void askToPlayAgain() {
        int option = JOptionPane.showConfirmDialog(frame, "Play again?", "Game Over", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            resetBoard();
        } else {
            frame.dispose();
        }
    }

    void resetBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c].setText("");
                board[r][c].setBackground(Color.DARK_GRAY);
            }
        }
        turns = 0;
        gameOver = false;
        currentPlayer = playerX;
        textLabel.setText("Tic-Tac-Toe: X's turn. Score - X: " + scoreX + ", O: " + scoreO);
    }

    public static void mainxo() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe();
            }
        });
    }
}
