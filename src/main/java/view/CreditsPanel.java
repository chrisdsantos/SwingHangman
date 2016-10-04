/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static main.java.SwingProject.CONTRIBUTORS;

/**
 *
 * @author Marc
 */
public class CreditsPanel extends JPanel {
    private javax.swing.JLabel creditsLabel;
    private javax.swing.JLabel[] membersLabels = new JLabel[CONTRIBUTORS.length];
    
      public CreditsPanel() {
        initComponents();
    }
      
       private void initComponents() {
        
        setLayout(new GridLayout(CONTRIBUTORS.length + 1, 1));
        
        creditsLabel = new JLabel("Placeholder");
        creditsLabel.setFont(new java.awt.Font("Arial Black", 0, 36));
        creditsLabel.setForeground(new java.awt.Color(255, 255, 255));
        creditsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        creditsLabel.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        creditsLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.add(creditsLabel);
        
        for(int i = 0; i < CONTRIBUTORS.length; i++) {
            membersLabels[i] = new JLabel("Placeholder");
            membersLabels[i].setFont(new java.awt.Font("Arial", 0, 24));
            membersLabels[i].setForeground(new java.awt.Color(255, 255, 255));
            membersLabels[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            membersLabels[i].setVerticalAlignment(javax.swing.SwingConstants.CENTER);
            membersLabels[i].setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
            this.add(membersLabels[i]);
        }
        
        setBackground(Color.BLACK);
    }
       
    public void setTitle(String newTitle){
        this.creditsLabel.setText(newTitle);
    }
    
    public void setMembers(String[] newMembers){
        for(int i = 0; i < CONTRIBUTORS.length; i++){
                this.membersLabels[i].setText(newMembers[i]);
        }
    }
    
    public void setBackgroundColor(Color newColor){
        this.setBackground(newColor);
    }
}
