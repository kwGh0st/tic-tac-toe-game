package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGui implements ActionListener {
    private final JFrame frame;

    public TicTacToeGui() {
        frame = new JFrame("TicTacToe");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
