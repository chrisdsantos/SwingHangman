/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.model;

/**
 *
 * @author Marc
 */
public class GameOverModel implements PanelModel {
    private int score;
    private String newGameButtonText;
    private String menuButtonText;
    
    public GameOverModel() {
        this.score = -1;
        newGameButtonText = "New Game";
        menuButtonText = "Main Menu";
    }
    
    public void setScore(int gameScore) {
        this.score = gameScore;
    }
    
    public String getNewGameText() {
        return this.newGameButtonText;
    }
    
    public String getMenuText() {
        return this.menuButtonText;
    }
}
