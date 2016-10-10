/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.view;

import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.RenderingHints;

/**
 *
 * @author Chris
 */
public class GamePanel extends JPanel{
    
    private JButton skip;
    private JButton[] keyboardButton;
    private JLabel dateTimeLabel;
    private JPanel wordPanel;
    private JLabel[] guessWord;
    
    public GamePanel() {
        initComponents();
    }
    
    //initComponents
    //purpose: set up game button and graphics display arrangement
    private void initComponents() {
        int asciiKey;
        String keyValue;
        
        setLayout(new BorderLayout());
        JPanel imagePanel = new JPanel();
        JButton graphicBtn = new JButton();
        //ImageIcon graphics = new ImageIcon(getClass().getResource("7.jpg"));

        JPanel wordPanel = new JPanel();
        JPanel keyboard = new JPanel();
        keyboard.setLayout(new GridLayout(3,1));
        keyboardButton = new JButton[26];
        for(int i=0;i<26;i++){
            asciiKey = i+65;
            keyValue = Character.toString((char)asciiKey);
            keyboardButton[i] = new JButton(keyValue);
            keyboardButton[i].setActionCommand(keyValue);
            keyboard.add(keyboardButton[i]);
        }
        
        JPanel graphicsPanel = new JPanel(new FlowLayout());
        graphicsPanel.add(imagePanel);
        graphicsPanel.add(wordPanel);

        JPanel right = new JPanel(new GridLayout(7,1));
        dateTimeLabel = new JLabel("Placeholder");
        skip = new JButton("skip");
        skip.setActionCommand("skip");
        right.add(dateTimeLabel);
        right.add(new JLabel());
        right.add(skip);
        
        this.add(right, BorderLayout.EAST);
        this.add(graphicsPanel, BorderLayout.CENTER);
        this.add(wordPanel, BorderLayout.CENTER);
        this.add(keyboard, BorderLayout.PAGE_END);
    }
    
    public JButton getKeyboardButton(int b){
        return keyboardButton[b];
    }
    
    public JButton getSkipButton(){
        return skip;
    }
    
    public void setWordPanel(String word){
//        guessWord = new JLabel[word.length()];
//        for(int i=0;i<word.length();i++){
//            guessWord[i].setText("_");
//            wordPanel.add(guessWord);
//        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Font font = new Font("Arial", Font.BOLD, 72);
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(font);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawString("Hello", 0, 0);
    }
    
//    public Dimension getPreferredSize(){
//        return new Dimension(100,100);
//    }
    
    public void setDateTimeLabel(String dateTime){
        dateTimeLabel.setText(dateTime);
    }
}