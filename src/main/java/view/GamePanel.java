/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JTextField;

/**
 *
 * @author Chris
 */
public class GamePanel extends JPanel{
    private JButton skipButton;
    private JLabel gameNameLabel;
    private JLabel dateTimeLabel;
    private JLabel points;
    private JPanel keyboard;
    private HangmanPanel hmPanel;
    JPanel blanksHolder;
//    private 
    private JButton[] keyboardButtonArray;
    private ArrayList<LetterBlankPanel> blanksArrayList;
    
        
    public GamePanel() {
        blanksHolder = new JPanel();
        blanksArrayList = new ArrayList<>();
        keyboardButtonArray = new JButton[26];
        gameNameLabel = new JLabel("Placeholder");
        gameNameLabel.setForeground(new Color(30,144,255));
        gameNameLabel.setFont(new Font("Impact", Font.PLAIN,24));
        dateTimeLabel =  new JLabel("Placeholder");
        points  = new JLabel("Placeholder");
        skipButton = new JButton("SKIP");
        hmPanel = new HangmanPanel();
        initComponents();
    }
                        
    //initComponents
    //purpose: set up game button and graphics display arrangement
    private void initComponents() {
        
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        //top field
        JPanel topContainer = new JPanel();
        topContainer.setLayout(new BoxLayout(topContainer, BoxLayout.X_AXIS));
        topContainer.add(gameNameLabel);
        topContainer.add(new JPanel());
        topContainer.add(dateTimeLabel);
        this.add(topContainer, BorderLayout.PAGE_START);
        
        //center field
        this.add(hmPanel, BorderLayout.CENTER);
        
        //left field
        this.add(points,BorderLayout.LINE_START);
        
        //right field
        JPanel rightContainer = new JPanel();
        rightContainer.setLayout(new BoxLayout(rightContainer,BoxLayout.Y_AXIS));
        rightContainer.add(skipButton);
        this.add(rightContainer, BorderLayout.LINE_END);
        
        //bottom field
        JPanel bottomContainer = new JPanel();
        bottomContainer.setLayout(new GridLayout(2,1));
        
        blanksHolder.setLayout(new GridLayout(1,8));
        bottomContainer.add(blanksHolder);
        
        JPanel keyboard = new JPanel();
        keyboard.setLayout(new GridLayout(3,1));
        for(int i=65; i<91; i++){
            keyboardButtonArray[i-65] = new JButton(Character.toString((char) i));
            keyboard.add(keyboardButtonArray[i-65]);
        }
        bottomContainer.add(keyboard);
        
        this.add(bottomContainer, BorderLayout.PAGE_END);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
//        g.drawOval(300, 300, 50, 50);
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

    public JButton[] getKeyboardButtonArray() {
        return keyboardButtonArray;
    }

    public JLabel getPoints() {
        return points;
    }

    public void setPoints(JLabel points) {
        this.points = points;
    }

    public JLabel getGameNameLabel() {
        return gameNameLabel;
    }

    public void setGameNameLabel(JLabel gameNameLabel) {
        this.gameNameLabel = gameNameLabel;
    }

    public ArrayList<LetterBlankPanel> getBlanksArrayList() {
        return blanksArrayList;
    }

    public void addBlanks(int numberOfBlanks){
        blanksHolder.removeAll();
        blanksArrayList.removeAll(blanksArrayList);
        for(int i = 0; i<numberOfBlanks; i++){
            LetterBlankPanel blank = new LetterBlankPanel();
//            blank.setPreferredSize(new Dimension(50, 20));
            blanksHolder.add(blank);
            blanksArrayList.add(blank);
        }
    }

    public HangmanPanel getHmPanel() {
        return hmPanel;
    }
    
}