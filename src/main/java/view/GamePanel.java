/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JTextField;

/**
 *
 * @author Chris
 */
public class GamePanel extends JPanel{
    
    private javax.swing.JLabel dateTimeLabel;
    
    public GamePanel() {
        initComponents();
    }
                        
    //initComponents
    //purpose: set up game button and graphics display arrangement
    private void initComponents() {
        
        setLayout(new BorderLayout());
        
        //top field
        JPanel topContainer = new JPanel();
        dateTimeLabel = new JLabel("Placeholder");
        topContainer.add(dateTimeLabel);
        this.add(topContainer, BorderLayout.PAGE_START);
        
        //center field
        JPanel graphicsPanel = new JPanel();
        this.add(graphicsPanel, BorderLayout.CENTER);
        
        //right field
        JButton skip = new JButton("skip");
        this.add(skip, BorderLayout.LINE_END);
        
        //bottom field
        JPanel keyboard = new JPanel();
        keyboard.setLayout(new GridLayout(3,1));
        JButton[] keyboardButton = new JButton[26];
        for(int i=65; i<91; i++){
            keyboardButton[i-65] = new JButton(Character.toString((char) i));
            keyboard.add(keyboardButton[i-65]);
        }
        this.add(keyboard, BorderLayout.PAGE_END);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawOval(300, 300, 50, 50);
    }
    
    public Dimension getPreferredSize(){
        return new Dimension(100,100);
    }
    
    public void setDateTime(String dateTime){
        dateTimeLabel.setText(dateTime);
    }
}