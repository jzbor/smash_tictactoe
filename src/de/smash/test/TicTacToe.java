package de.smash.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {

    private JButton[][] buttons;
    private int step;
    private static final String EMPTY = "";
    private static final String X = "X";
    private static final String O = "O";

    public TicTacToe(){
        buttons = new JButton[3][3];
        step = 0;
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton(EMPTY);
                buttons[i][j].addActionListener(this);
                getContentPane().add(buttons[i][j]);
            }
        }
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setBackground(Color.pink);
                buttons[i][j].setFont(new Font ("Comic Sans MS", Font.BOLD,20));

            }
        }
        getContentPane().setLayout(new GridLayout(3, 3));

        setSize( 400, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private boolean win(){
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText())
                    && buttons[i][0].getText().equals(buttons[i][2].getText())
                    && !(buttons[i][0].getText().equals(EMPTY)
                        || buttons[i][1].getText().equals(EMPTY)
                        || buttons[i][2].getText().equals(EMPTY)))
                return true;
        }

        for (int i = 0; i < buttons.length; i++) {
            if (buttons[0][i].getText().equals(buttons[1][i].getText())
                    && buttons[0][i].getText().equals(buttons[2][i].getText())
                    && !(buttons[0][i].getText().equals(EMPTY)
                        || buttons[1][i].getText().equals(EMPTY)
                        || buttons[2][i].getText().equals(EMPTY)))
                return true;
        }



        return ((buttons[1][1].getText().equals(buttons[0][0].getText())
                        && buttons[1][1].getText().equals(buttons[2][2].getText())
                    || (buttons[1][1].getText().equals(buttons[0][2].getText())
                        && buttons[1][1].getText().equals(buttons[2][0].getText())))
                    && !buttons[1][1].getText().equals(EMPTY));
    }

    private boolean draw(){
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (buttons[i][j].getText().equals(EMPTY))
                    return false;
            }
        }
        return true;
    }

    private void reset(){
        step = 0;
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setText(EMPTY);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton src = (JButton)actionEvent.getSource();

        if (src.getText().equals(EMPTY)){
            if (step%2 == 0){
                src.setText(X);
            } else {
                src.setText(O);
            }
            step++;
        } else {
            JOptionPane.showMessageDialog(this, "Das geht nich, Opfer!!!!");
        }

        if (win()){
            if (step%2 == 1){
                JOptionPane.showMessageDialog(this, "Spieler \""+X+"\" hat gewonnen");
            } else {
                JOptionPane.showMessageDialog(this, "Spieler \""+O+"\" hat gewonnen");
            }
            reset();
        }

        if (draw()){
            JOptionPane.showMessageDialog(this, "Unentschieden!");
            reset();
        }


    }
}
