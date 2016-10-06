/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.model;

import java.awt.Color;
import static main.java.SwingProject.CONTRIBUTORS;

/**
 *
 * @author Nahid
 */
public class HighScoreModel implements PanelModel {
    private String highScoreTitle;
    private String[] teamMembers;
    private Color backgroundColor;
    private String backButtonText;
    
    public HighScoreModel() {
        this.highScoreTitle = "PLACEHOLDER";
        this.teamMembers = new String[CONTRIBUTORS.length];
        this.backgroundColor = Color.BLACK;
        this.backButtonText = "Back";
    }
    
     public HighScoreModel(String title, String[] members, Color color) {
        this.highScoreTitle = title;
        this.teamMembers = members;
        this.backgroundColor = color;
        this.backButtonText = "Back";
    }
     
     public String getHighScoreTitle() {
        return this.highScoreTitle;
    }
    
    public void setHighScoreTitle(String highScoreTitle) {
        this.highScoreTitle = highScoreTitle;
    }
    
    public String[] getMembers() {
        return this.teamMembers;
    }
    
    public void setMembers(String[] members) {
        this.teamMembers = members;
    }
    
    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    
    public String getBackButtonText() {
        return this.backButtonText;
    }
}
