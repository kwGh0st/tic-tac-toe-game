package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class TicTacToeGui implements ActionListener {
    private final JFrame frame;
    private final JButton[] gameButtons = new JButton[9];
    private final JLabel textField;
    private boolean playerOneTurn;
    private boolean isWinner = false;
    private boolean isGameStarted = false;
    private final StringBuilder playerOnePositions = new StringBuilder();
    private final StringBuilder playerTwoPositions = new StringBuilder();
    private final HashSet<String> winCombination = new HashSet<>();

    protected TicTacToeGui() {
        frame = new JFrame("TicTacToe");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreFrame(frame);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));

        Font font = new Font("Ink Free", Font.BOLD, 50);
        for (int i = 0; i < gameButtons.length; i++) {
            gameButtons[i] = new JButton();
            gameButtons[i].setFocusable(false);
            gameButtons[i].addActionListener(this);
            gameButtons[i].setFont(font);
            buttonPanel.add(gameButtons[i]);
        }

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        textField = new JLabel();
        textField.setFocusable(false);
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);
        textField.setFont(font);

        titlePanel.add(textField, BorderLayout.NORTH);

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void centreFrame(JFrame frame) {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;

        frame.setSize(width / 4, height / 2);

        int widthFrame = frame.getSize().width;
        int heightFrame = frame.getSize().height;

        frame.setLocation(widthFrame, heightFrame / 2);
    }

    private void startGame() {

    }

    private void firstTurn() {

    }

    private void play() {

    }

    private void setPlayer(JLabel textField) {

    }

    private void checkPositions(StringBuilder playerPositions) {

    }

    private void areEmptyPositionsRemaining(JButton[] game) {

    }

    private void disableAll(JButton[] buttons) {
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }

    private void enableAll(JButton[] buttons) {
        for (JButton button : buttons) {
            button.setEnabled(true);
        }
    }



    private void playerOneWin(int a, int b, int c) {
        for (int i = 0; i < gameButtons.length; i++) {
            if (i == a || i == b || i == c) {
                gameButtons[i].setBackground(Color.GREEN);
                textField.setText("X wins!!!");
                isWinner = true;
            }
        }
    }

    private void playerTwoWin(int a, int b, int c) {
        for (int i = 0; i < gameButtons.length; i++) {
            if (i == a || i == b || i == c) {
                gameButtons[i].setBackground(Color.GREEN);
                textField.setText("O wins!!!");
                isWinner = true;
            }
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < gameButtons.length; i++ ) {
            if (e.getSource() == gameButtons[i]) {
                if (playerOneTurn) {
                    gameButtons[i].setText("X");
                    playerOneTurn = false;
                } else {
                    gameButtons[i].setText("O");
                    playerOneTurn = true;
                }
                gameButtons[i].setEnabled(false);
            }
        }
    }
}
