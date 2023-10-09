/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barcodeprototype;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.AncestorListener;

/**
 *
 * @author dmitr
 */
public class AddItew {

    public String newItem = "";

    public AddItew() {

    }

    public String open(String barcode) {
        JFrame frame = new JFrame("Add new Item");
        JLabel label = new JLabel(barcode);
        JTextArea text = new JTextArea();
        JButton button = new JButton("Save");

        label.setText(barcode);
        label.setSize(200, 100);
        label.setBounds(10, 10, 200, 100);

        text.setSize(200, 100);
        text.setLocation(100, 200);

        button.setSize(200, 200);
        button.setLocation(150, 400);
       // button.addActionListener(new CustomActionListener());

        frame.setSize(500, 500);
        JPanel panel = new JPanel();

        panel.add(label);
        panel.add(text);
        panel.add(button);
        frame.add(panel);

        frame.setVisible(true);
        
        button.addAncestorListener((AncestorListener) this);
        
        return null;
    }

    
    public void actionPerformed(ActionEvent e) {
        System.out.println("Saving");
    }
}
