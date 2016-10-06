/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import static main.java.SwingProject.CONTRIBUTORS;

/**
 *
 * @author Nahid
 */
public class HighScorePanel extends JPanel{
    private javax.swing.JLabel highScoreLabel;
    private javax.swing.JLabel[] membersLabels = new JLabel[CONTRIBUTORS.length];
    private JButton backButton;
    
    private static final Font BUTTON_FONT = new Font("Arial Black", Font.BOLD, 15);
    private static final Border BUTTON_BORDER = BorderFactory.
            createCompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5),
                    BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE,Color.GRAY));
    
    public HighScorePanel() {
        initComponents();
    }
        public JButton getBackButton(){
        return this.backButton;
        }
       private void initComponents() {
        this.setBackground(Color.BLACK);
           
        this.setLayout(new GridBagLayout());
        
        GridBagConstraints gc = new GridBagConstraints();
        
        highScoreLabel = new JLabel("Placeholder");
        highScoreLabel.setFont(new java.awt.Font("Arial Black", 0, 36));
        highScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        highScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScoreLabel.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        highScoreLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
        gc.fill = GridBagConstraints.BOTH;
        gc.gridx = 1;
        gc.gridy = 0;
        gc.gridwidth = 1;
        gc.gridheight = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        this.add(highScoreLabel, gc);
        
        for(int i = 0; i < CONTRIBUTORS.length; i++) {
            membersLabels[i] = new JLabel("Placeholder");
            membersLabels[i].setFont(new java.awt.Font("Arial", 0, 24));
            membersLabels[i].setForeground(new java.awt.Color(255, 255, 255));
            membersLabels[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
           // membersLabels[i].setVerticalAlignment(javax.swing.SwingConstants.CENTER);
           // membersLabels[i].setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
            
           gc.fill = GridBagConstraints.BOTH;
            gc.gridx = 1;
            gc.gridy = i + 1;
            gc.gridwidth = 1;
            gc.gridheight = 1;
            gc.weightx = .5;
            //gc.weighty = ;
           this.add(membersLabels[i], gc);
        }
        backButton = new JButton("Placeholder");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setMaximumSize(new Dimension(100, 100));
        backButton.setFont(BUTTON_FONT);
        backButton.setBorder(BUTTON_BORDER);
        
        gc.fill = GridBagConstraints.BOTH;
        gc.gridx = 0;
        gc.gridy = CONTRIBUTORS.length;
        gc.gridwidth = 1;
        gc.gridheight = 1;
        gc.weightx = .15;
        //gc.weighty = ;
        this.add(backButton, gc);
        
        JPanel placeHolder = new JPanel();
        placeHolder.setBackground(this.getBackground());
        gc.fill = GridBagConstraints.BOTH;
        gc.gridx = 2;
        gc.gridy = 1;
        gc.gridwidth = 1;
        gc.gridheight = CONTRIBUTORS.length + 1;
        gc.weightx = .35;
        //gc.weighty = ;
        this.add(placeHolder, gc);
        
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
