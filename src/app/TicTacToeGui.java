package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGui implements ActionListener {
    private final JFrame frame;
    private final JButton[] buttons = new JButton[9];
    private final JLabel textField;
    private final Font font = new Font("Ink Free", Font.BOLD, 50);

    public TicTacToeGui() {
        frame = new JFrame("TicTacToe");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreFrame(frame);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setFont(font);
            buttonPanel.add(buttons[i]);
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



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
