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
 * @author Marc
 */
public class CreditsModel implements PanelModel {
    private String creditsTitle;
    private String[] teamMembers;
    private Color backgroundColor;
    
    public CreditsModel() {
        this.creditsTitle = "PLACEHOLDER";
        this.teamMembers = new String[CONTRIBUTORS.length];
        this.backgroundColor = Color.BLACK;
    }
    
    public CreditsModel(String title, String[] members, Color color) {
        this.creditsTitle = title;
        this.teamMembers = members;
        this.backgroundColor = color;
    }
    
    public String getCreditsTitle() {
        return this.creditsTitle;
    }
    
    public void setCreditsTitle(String creditsTitle) {
        this.creditsTitle = creditsTitle;
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
}
