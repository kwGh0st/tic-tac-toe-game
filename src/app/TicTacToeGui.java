package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGui implements ActionListener {
    private final JFrame frame;
    private final JButton[] buttons = new JButton[9];

    public TicTacToeGui() {
        frame = new JFrame("TicTacToe");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
