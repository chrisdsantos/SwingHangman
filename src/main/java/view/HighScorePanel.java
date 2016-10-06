/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static main.java.SwingProject.CONTRIBUTORS;

/**
 *
 * @author Nahid
 */
public class HighScorePanel extends JPanel{
    private javax.swing.JLabel highScoreLabel;
    private javax.swing.JLabel[] membersLabels = new JLabel[CONTRIBUTORS.length];
    private JButton backButton;
    
    public HighScorePanel() {
        initComponents();
    }
        public JButton getBackButton(){
        return this.backButton;
        }
       private void initComponents() {
        
        setLayout(new GridLayout(CONTRIBUTORS.length + 1, 1));
        
        highScoreLabel = new JLabel("Placeholder");
        highScoreLabel.setFont(new java.awt.Font("Arial Black", 0, 36));
        highScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        highScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScoreLabel.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        highScoreLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.add(highScoreLabel);
        
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
        this.highScoreLabel.setText(newTitle);
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
