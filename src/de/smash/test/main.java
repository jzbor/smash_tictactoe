package de.smash.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main implements ActionListener {
    private JFrame frame;
    private JButton button;
    public main (){
        frame=new JFrame ("TiciTakiToe");
        frame.setSize(400,400);
        frame.setLayout(new GridLayout() );
        button=new JButton("Neues Spiel");
        button.addActionListener(this);
        button.setBackground(Color.red);
        button.setFont(new Font("ComicSansMS", Font.BOLD, 40));
        frame.getContentPane().add(button);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new main();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new TicTacToe();
        frame.dispose();
            }
}
