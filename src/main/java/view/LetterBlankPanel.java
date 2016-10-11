/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.view;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Omar
 */
public class LetterBlankPanel extends JPanel{
    private String letter;
    
    public LetterBlankPanel(){
        letter = "";
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        ((Graphics2D)g).setStroke(new BasicStroke(5));
        g.setFont(new Font("Arial",Font.BOLD, 16));
        
        int availableWidth = this.getWidth() - 10;
        int drawAtHeight = this.getHeight() / 2;
        int letterDrawX = this.getWidth() / 2;
        int letterDrawY = (this.getHeight() / 2) + -15;
        
        g.drawString(letter, letterDrawX, letterDrawY);
        g.drawLine(5,drawAtHeight,availableWidth,drawAtHeight);
        
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
     
}
