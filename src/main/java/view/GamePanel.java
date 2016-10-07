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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
//import javax.swing.JTextField;

/**
 *
 * @author Chris
 */
public class GamePanel extends JPanel{
    private JButton skipButton;
    
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
        this.add(topContainer, BorderLayout.PAGE_START);
        
        //center field
        JPanel graphicsPanel = new JPanel();
        /*graphicsPanel.setBorder(BorderFactory.
            createCompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5),
                    BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE,Color.GRAY)));*/
        this.add(graphicsPanel, BorderLayout.CENTER);
        
        //right field
        JPanel right = new JPanel(new GridLayout(7,1));
        dateTimeLabel = new JLabel("Placeholder");
        skipButton = new JButton("skip");
        
        right.add(dateTimeLabel);
        right.add(new JLabel());
        right.add(skipButton);
        this.add(right, BorderLayout.EAST);
        
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

    public JButton getSkipButton() {
        return skipButton;
    }

    public void setSkipButton(JButton skipButton) {
        this.skipButton = skipButton;
    }
    
}