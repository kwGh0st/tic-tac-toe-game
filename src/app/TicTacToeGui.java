package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;

public class TicTacToeGui implements ActionListener {
    private final JButton[] GAME_BUTTONS = new JButton[9];
    private final JLabel GAME_LABEL;
    private final StringBuilder PLAYER_ONE_POSITIONS = new StringBuilder();
    private final StringBuilder PLAYER_TWO_POSITIONS = new StringBuilder();
    private final HashSet<String> WIN_COMBINATIONS = new HashSet<>();
    private boolean playerOneTurn;
    private boolean isWinner = false;
    private boolean isGameStarted = false;

    protected TicTacToeGui() {
        JFrame frame = new JFrame("TicTacToe");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreFrame(frame);
        setWinningCombinations(WIN_COMBINATIONS);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));

        Font font = new Font("Ink Free", Font.BOLD, 50);
        for (int i = 0; i < GAME_BUTTONS.length; i++) {
            GAME_BUTTONS[i] = new JButton();
            GAME_BUTTONS[i].setFocusable(false);
            GAME_BUTTONS[i].addActionListener(this);
            GAME_BUTTONS[i].setFont(font);
            buttonPanel.add(GAME_BUTTONS[i]);
        }

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        GAME_LABEL = new JLabel();
        GAME_LABEL.setFocusable(false);
        GAME_LABEL.setHorizontalAlignment(JLabel.CENTER);
        GAME_LABEL.setText("Tic-Tac-Toe");
        GAME_LABEL.setOpaque(true);
        GAME_LABEL.setFont(font);

        titlePanel.add(GAME_LABEL, BorderLayout.NORTH);

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.setVisible(true);
        startGame(GAME_BUTTONS, GAME_LABEL);
    }

    private void centreFrame(JFrame frame) {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;

        frame.setSize(width / 4, height / 2);

        int widthFrame = frame.getSize().width;
        int heightFrame = frame.getSize().height;

        frame.setLocation(widthFrame, heightFrame / 2);
    }

    private void setWinningCombinations(HashSet<String> combinations) {
        combinations.add("012");
        combinations.add("345");
        combinations.add("678");
        combinations.add("036");
        combinations.add("147");
        combinations.add("258");
        combinations.add("048");
        combinations.add("246");
    }
    private void startGame(JButton[] gameButtons, JLabel gameLabel) {
        setFirstTurn(gameButtons, gameLabel);
    }

    private void setFirstTurn(JButton[] gameButtons, JLabel gameLabel) {
        isGameStarted = false;
        disableAll(gameButtons);

        int gamble = new Random().nextInt(10);
        playerOneTurn = gamble < 5;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            System.out.println("Sleeping interrupted!");
        }

        setPlayer(gameLabel);
        isGameStarted = true;
        enableAll(gameButtons);
        play(gameButtons, gameLabel);
    }

    private void setPlayer(JLabel textField) {
        if (playerOneTurn) textField.setText("X turn");
        else textField.setText("O turn");
    }

    private void play(JButton[] gameButtons, JLabel gameLabel) {
        while (isGameStarted) {
            setPlayer(gameLabel);
            if (PLAYER_ONE_POSITIONS.length() >= 3 || PLAYER_TWO_POSITIONS.length() >= 3) {
                checkPositions();
            }
            areEmptyPositionsRemaining(gameButtons, gameLabel);
        }
        disableAll(gameButtons);
    }

    private void checkPositions() {
        char[] p1 = PLAYER_ONE_POSITIONS.toString().toCharArray();
        char[] p2 = PLAYER_TWO_POSITIONS.toString().toCharArray();

        StringBuilder p1Builder = new StringBuilder();
        StringBuilder p2Builder = new StringBuilder();

        for (String each : WIN_COMBINATIONS) {
            int count = 0;
            for (char c : p1) {
                if (each.contains(String.valueOf(c))) {
                    count++;
                    p1Builder.append(c);
                }
            }

            if (count == 3) {
                playerOneWin(
                        Integer.parseInt(p1Builder.substring(0, 1)),
                        Integer.parseInt(p1Builder.substring(1, 2)),
                        Integer.parseInt(p1Builder.substring(2)),
                        GAME_BUTTONS,
                        GAME_LABEL);
                return;
            }

            p1Builder = new StringBuilder();
            count = 0;

            for (char c : p2) {
                if (each.contains(String.valueOf(c))) {
                    count++;
                    p2Builder.append(c);
                }
            }

            if (count == 3) {
                playerTwoWin(
                        Integer.parseInt(p2Builder.substring(0, 1)),
                        Integer.parseInt(p2Builder.substring(1, 2)),
                        Integer.parseInt(p2Builder.substring(2)),
                        GAME_BUTTONS,
                        GAME_LABEL);
                return;
            }

            p2Builder = new StringBuilder();
        }
    }

    private void areEmptyPositionsRemaining(JButton[] gameField, JLabel gameLabel) {
        for (JButton button : gameField) {
            if (button.isEnabled()) return;
        }

        if (!isWinner) {
            gameLabel.setText("Draw!");
            isGameStarted = false;
        }
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



    private void playerOneWin(int a, int b, int c, JButton[] gameButtons, JLabel gameLabel) {
        for (int i = 0; i < gameButtons.length; i++) {
            if (i == a || i == b || i == c) {
                gameButtons[i].setBackground(Color.GREEN);
                gameLabel.setText("X wins!!!");
                isGameStarted = false;
                isWinner = true;
            }
        }
    }

    private void playerTwoWin(int a, int b, int c, JButton[] gameButtons, JLabel gameLabel) {
        for (int i = 0; i < gameButtons.length; i++) {
            if (i == a || i == b || i == c) {
                gameButtons[i].setBackground(Color.RED);
                gameLabel.setText("O wins!!!");
                isGameStarted = false;
                isWinner = true;
            }
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < GAME_BUTTONS.length; i++ ) {
            if (e.getSource() == GAME_BUTTONS[i]) {
                if (playerOneTurn) {
                    GAME_BUTTONS[i].setText("X");
                    PLAYER_ONE_POSITIONS.append(i);
                    playerOneTurn = false;
                } else {
                    GAME_BUTTONS[i].setText("O");
                    PLAYER_TWO_POSITIONS.append(i);
                    playerOneTurn = true;
                }
                GAME_BUTTONS[i].setEnabled(false);
            }
        }
    }
}
