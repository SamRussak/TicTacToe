import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame{

    JFrame _frame = new JFrame("Tic-Tac-Toe");
    JButton[] _buttons = new JButton[10];
    Boolean turn = true;

    public TicTacToe()
    {
        _frame.setSize(400, 400);
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel _ttt = new JPanel();
        JPanel _newPanel = new JPanel();
        _ttt.setLayout(new GridLayout(3, 3));
        _newPanel.setLayout(new FlowLayout());
        _frame.add(_ttt, BorderLayout.NORTH);
        _frame.add(_newPanel, BorderLayout.SOUTH);

        for (int j=0; j<9; j++) {
            // Make a new button in the array location with text "_"
            _buttons[j] = new JButton("_");
            // Associate a new ButtonListener to the button (see below)
            ActionListener buttonListener = new ButtonListener();
            _buttons[j].addActionListener(buttonListener);
            // Set the font on the button
            _buttons[j].setFont(new Font("Courier", Font.PLAIN, 48));
            // Add this button to the _ttt panel
            _ttt.add(_buttons[j]);
        }
        _buttons[9] = new JButton("New Game");
        ActionListener buttonListener = new newStart();
        _buttons[9].addActionListener(buttonListener);
        // Set the font on the button
        _buttons[9].setFont(new Font("Courier", Font.PLAIN, 48));
        _newPanel.add(_buttons[9]);

        _frame.setVisible(true);
        pack();
    }
    class newStart implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            for (int j=0; j<9; j++) {
                // Make a new button in the array location with text "_"
                _buttons[j].setText("_");
            }
        }

    }
    class ButtonListener implements ActionListener {

        // Every time we click the button, it will perform
        // the following action.

        public void actionPerformed(ActionEvent e) {

            JButton source = (JButton) e.getSource();
            String currentText = source.getText();
            if (currentText.equals("_") && turn) {
                source.setText("X");
                turn = false;
            }
            else if(currentText.equals("_") && !turn)
            {
                source.setText("O");
                turn = true;
            }
        }

    }
    public static void main (String[] args)
    {
        new TicTacToe();

    }
}
