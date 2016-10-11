/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Omar
 */
public class SplashPanel extends JPanel {
    
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel teamLabel;

    public SplashPanel() {
        initComponents();
    }
                        
    private void initComponents() {
        setLayout(new BorderLayout());
        
        titleLabel = new JLabel("Placeholder");
        titleLabel.setFont(new java.awt.Font("Georgia", 0, 42));
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 0, 0, 0));
        this.add(titleLabel, BorderLayout.PAGE_START);
        
        teamLabel = new JLabel("Placeholder");
        teamLabel.setFont(new java.awt.Font("Georgia", 0, 36));
        teamLabel.setForeground(new java.awt.Color(255, 255, 255));
        teamLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teamLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 25, 0));
        this.add(teamLabel, BorderLayout.PAGE_END);
        
        setBackground(Color.BLACK);
    }             
    
    public void setTitle(String newTitle){
        titleLabel.setText(newTitle);
    }
    
    public void setTeam(String newTeam){
        teamLabel.setText("By: Team " + newTeam);
    }
    
    public void setBackgroundColor(Color newColor){
        setBackground(newColor);
    }                 
}
