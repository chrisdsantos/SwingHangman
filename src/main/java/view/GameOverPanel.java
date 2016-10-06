/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 *
 * @author Marc
 */
public class GameOverPanel extends JPanel {
    private JLabel gameOverLabel;
    private JLabel scoreLabel;
    private JButton button1;
    private JButton button2;
    
    private static final Font BUTTON_FONT = new Font("Arial Black", Font.BOLD, 15);
    private static final Border BUTTON_BORDER = BorderFactory.
            createCompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5),
                    BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE,Color.GRAY));
    
    public GameOverPanel() {
        this.initComponents();
    }
    
    public JButton getResetButton() {
        return this.button1;
    }
    
    public JButton getMenuButton() {
        return this.button2;
    }

    private void initComponents() {
        this.setLayout(new GridLayout(5, 1));
        
        this.gameOverLabel.setText("Game Over");
        gameOverLabel.setFont(new java.awt.Font("Arial Black", 0, 36));
        gameOverLabel.setForeground(new java.awt.Color(255, 255, 255));
        gameOverLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameOverLabel.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        gameOverLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.add(gameOverLabel);
        
        this.scoreLabel.setText("Score Placeholder");
        scoreLabel.setFont(new java.awt.Font("Arial", 0, 24));
        scoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        this.add(this.scoreLabel);
        
        button1 = new JButton("Placeholder");
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setMaximumSize(new Dimension(100, 100));
        button1.setFont(BUTTON_FONT);
        button1.setBorder(BUTTON_BORDER);
        this.add(button1);
        
        button2 = new JButton("Placeholder");
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.setMaximumSize(new Dimension(100, 100));
        button2.setFont(BUTTON_FONT);
        button2.setBorder(BUTTON_BORDER);
        this.add(button2);
    }
}
