package de.smash.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame implements ActionListener {
    private JFrame frame;
    private JButton knopf;
    public Frame () {
        frame = new JFrame("S.M.A.S.H.");
        knopf=new JButton ("Wer das liest ist dumm");
        knopf.addActionListener(this);
        frame.add(knopf);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
