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
    private int keychar;
    private String key;
    JButton[] keyboardButton;
    
    public GamePanel() {
        initComponents();
    }
    
    public void actionPerformed(ActionEvent e){
        if ("A".equals(e.getActionCommand())){
            keyboardButton[0].setEnabled(false);
            key = keyboardButton[0].getText();
        }
        if ("B".equals(e.getActionCommand())){
            keyboardButton[1].setEnabled(false);
        }
        if ("C".equals(e.getActionCommand())){
            keyboardButton[2].setEnabled(false);
        }
        if ("D".equals(e.getActionCommand())){
            keyboardButton[3].setEnabled(false);
        }
        if ("E".equals(e.getActionCommand())){
            keyboardButton[4].setEnabled(false);
        }
        if ("F".equals(e.getActionCommand())){
            keyboardButton[5].setEnabled(false);
        }
        if ("G".equals(e.getActionCommand())){
            keyboardButton[6].setEnabled(false);
        }
        if ("H".equals(e.getActionCommand())){
            keyboardButton[7].setEnabled(false);
        }
        if ("I".equals(e.getActionCommand())){
            keyboardButton[8].setEnabled(false);
        }
        if ("J".equals(e.getActionCommand())){
            keyboardButton[9].setEnabled(false);
        }
        if ("K".equals(e.getActionCommand())){
            keyboardButton[10].setEnabled(false);
        }
        if ("L".equals(e.getActionCommand())){
            keyboardButton[11].setEnabled(false);
        }
        if ("M".equals(e.getActionCommand())){
            keyboardButton[12].setEnabled(false);
        }
        if ("N".equals(e.getActionCommand())){
            keyboardButton[13].setEnabled(false);
        }
        if ("O".equals(e.getActionCommand())){
            keyboardButton[14].setEnabled(false);
        }
        if ("P".equals(e.getActionCommand())){
            keyboardButton[15].setEnabled(false);
        }
        if ("Q".equals(e.getActionCommand())){
            keyboardButton[16].setEnabled(false);
        }
        if ("R".equals(e.getActionCommand())){
            keyboardButton[17].setEnabled(false);
        }
        if ("S".equals(e.getActionCommand())){
            keyboardButton[18].setEnabled(false);
        }
        if ("T".equals(e.getActionCommand())){
            keyboardButton[19].setEnabled(false);
        }
        if ("U".equals(e.getActionCommand())){
            keyboardButton[20].setEnabled(false);
        }
        if ("V".equals(e.getActionCommand())){
            keyboardButton[21].setEnabled(false);
        }
        if ("W".equals(e.getActionCommand())){
            keyboardButton[22].setEnabled(false);
        }
        if ("X".equals(e.getActionCommand())){
            keyboardButton[23].setEnabled(false);
        }
        if ("Y".equals(e.getActionCommand())){
            keyboardButton[24].setEnabled(false);
        }
        if ("Z".equals(e.getActionCommand())){
            keyboardButton[25].setEnabled(false);
        }
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
        JButton skip = new JButton("skip");
        
        right.add(dateTimeLabel);
        right.add(new JLabel());
        right.add(skip);
        this.add(right, BorderLayout.EAST);
        
        //bottom field
        JPanel keyboard = new JPanel();
        keyboard.setLayout(new GridLayout(3,1));
        keyboardButton = new JButton[26];
        for(keychar=65; keychar<91; keychar++){
            keyboardButton[keychar-65] = new JButton(Character.toString((char) keychar));
            keyboardButton[keychar-65].addActionListener(this);
            keyboardButton[keychar-65].setActionCommand(Character.toString((char) keychar));
            keyboard.add(keyboardButton[keychar-65]);
        }
        this.add(keyboard, BorderLayout.PAGE_END);
    }
    
    public void paintComponent(Graphics g){
        //super.paintComponent(g)
        //g.drawOval(300, 300, 50, 50);
    }
    
    public Dimension getPreferredSize(){
        return new Dimension(100,100);
    }
    
    public void setDateTime(String dateTime){
        dateTimeLabel.setText(dateTime);
    }
}

