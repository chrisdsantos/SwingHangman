/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.view;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Omar
 */
public class HangmanPanel extends JPanel{
    int incorrectCount;
    
    public HangmanPanel(){
        incorrectCount = 0;
    }

    public int getIncorrectGuesses() {
        return incorrectCount;
    }

    public void setIncorrectGuesses(int incorrectGuesses) {
        this.incorrectCount = incorrectGuesses;
    }
    
    
    public void paint(Graphics g){
        if(incorrectCount > 0){
            g.drawOval(40,40,60,60); // Head
        }
        if(incorrectCount > 1){
            g.drawLine(70,100,70,175); // Torse
        }
        if(incorrectCount > 2){
            g.drawLine(70,125,35,100); // Left Arm
        }
        if(incorrectCount > 3){
            g.drawLine(70,125,105,100); // Right Arm
        }
        if(incorrectCount > 4){
            g.drawLine(70,125,105,100); // Right Arm
        }
        if(incorrectCount > 5){
            g.drawLine(70,175,35,200); // Left Leg
        }
        if(incorrectCount > 5){
            g.drawLine(70,175,105,200); // Left Leg
        }
        
    }
}
