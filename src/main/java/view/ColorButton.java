/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.view;

import javax.swing.JButton;

/**
 *
 * @author omar
 */
public class ColorButton extends JButton{
    private String color;
    
    public ColorButton(){
        color = "NOT SET";
    }
    
    public String getColor(){
        return color;
    }
    
    public void setColor(String c){
        color = c;
    }
}