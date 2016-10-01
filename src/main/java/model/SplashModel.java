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
public class SplashModel implements PanelModel{
    private String splashTitle;
    private String teamName;
    private Color backgroundColor;
    private int splashTime;
    
    public SplashModel(){
        splashTitle = "PLACEHOLDER";
        teamName = "PLACEHOLDER";
        backgroundColor = Color.BLACK;
        splashTime = 3000;
    }
    
    public SplashModel(String title, String team, Color color, int time){
        splashTitle = title;
        teamName = team;
        backgroundColor = color;
        splashTime = time;
    }

    public String getSplashTitle() {
        return splashTitle;
    }

    public void setSplashTitle(String splashTitle) {
        this.splashTitle = splashTitle;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getSplashTime() {
        return splashTime;
    }

    public void setSplashTime(int splashTime) {
        this.splashTime = splashTime;
    }


}
