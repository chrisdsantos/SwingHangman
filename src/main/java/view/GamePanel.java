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
import java.awt.event.*;
//import javax.swing.JTextField;

/**
 *
 * @author Chris
 */
public class GamePanel extends JPanel implements ActionListener{
    
    private javax.swing.JLabel dateTimeLabel;
    private int i;
    private String key;
    JButton[] keyboardButton;
    
    public GamePanel() {
        initComponents();
    }
    
    //initComponents
    //purpose: set up game button and graphics display arrangement
    private void initComponents() {
        String key;
        int ascKey;
        JLabel[] guessWord;
        
        setLayout(new BorderLayout());
        JPanel topContainer = new JPanel();
        JPanel graphicsPanel = new JPanel();
        JPanel right = new JPanel(new GridLayout(7,1));
        JPanel keyboard = new JPanel();
        JPanel wordPanel = new JPanel();
        JButton skip = new JButton("skip");
        dateTimeLabel = new JLabel("Placeholder");
        keyboard.setLayout(new GridLayout(3,1));
        keyboardButton = new JButton[26];
        for(i=0;i<26;i++){
            ascKey = i+65;
            key = Character.toString((char)ascKey);
            keyboardButton[i] = new JButton(key);
            keyboardButton[i].addActionListener(this);
            keyboardButton[i].setActionCommand(key);
            keyboard.add(keyboardButton[i]);
        }
        
        right.add(dateTimeLabel);
        right.add(new JLabel());
        right.add(skip);
        graphicsPanel.add(skip);
        
        guessWord = new JLabel[10];
        for(int i=0;i<randomWord.length;i++){
            guessWord[i].setText("_");
            wordPanel.add(guessWord[i]);
        }
        
        this.add(right, BorderLayout.EAST);
        this.add(topContainer, BorderLayout.PAGE_START);
        this.add(graphicsPanel, BorderLayout.CENTER);
        this.add(keyboard, BorderLayout.PAGE_END);
    }
    
    //actionPerformed
    //purpose: functions for each key
    public void actionPerformed(ActionEvent e){
        //keyboard functions
        for(int i=0;i<26;i++){
            if (Character.toString((char)i).equals(e.getActionCommand())){
                keyboardButton[i+65].setEnabled(false);
                key = keyboardButton[i+65].getText();
            }
            model.setGuessRemain(model.getGuessRemain()-1);
            if(model.getGuessRemain()==0){
                //game over
            }
        }
        //skip button
    }
    
    public void paintComponent(Graphics g){
        //super.paintComponent(g);
        //g.drawOval(300, 300, 50, 50);
    }
    
    public Dimension getPreferredSize(){
        return new Dimension(100,100);
    }
    
    public void setDateTime(String dateTime){
        dateTimeLabel.setText(dateTime);
    }
}