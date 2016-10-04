/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.model;

import java.awt.Color;

/**
 *
 * @author Omar
 */
public class FunctionModel {
    private Color backgroundColor;
    private String button1;
    private String button2;
    private String button3;
    
    public FunctionModel(Color bg,String btn1, String btn2, String btn3){
        backgroundColor = bg;
        button1 = btn1;
        button2 = btn2;
        button3 = btn3;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getButton1() {
        return button1;
    }

    public void setButton1(String button1) {
        this.button1 = button1;
    }

    public String getButton2() {
        return button2;
    }

    public void setButton2(String button2) {
        this.button2 = button2;
    }

    public String getButton3() {
        return button3;
    }

    public void setButton3(String button3) {
        this.button3 = button3;
    }
    
}
