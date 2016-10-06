/*************************************************************** 
*file: GameOverController.java 
* author: Jazmin Guerrero, Omar Rodriguez, Marc Deaso 
* class: CS 245 - Programming Graphical User Interfaces
* 
* 
*assignment: Swing Project 1 
* date last modified: 10/06/2016
* 
* purpose: this class is the model containing the business logic 
* for a game over screen
* 
****************************************************************/ 
package main.java.model;

public class GameOverModel implements PanelModel {
    private int score;
    public static final String GAME_OVER_TEXT = "Game Over!";
    private String newGameButtonText;
    private String menuButtonText;
    
    public GameOverModel() {
        this.score = -1;
        newGameButtonText = "New Game";
        menuButtonText = "Main Menu";
    }
    
    public int getScore(){
        return score;
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

    public String getNewGameButtonText() {
        return newGameButtonText;
    }

    public void setNewGameButtonText(String newGameButtonText) {
        this.newGameButtonText = newGameButtonText;
    }

    public String getMenuButtonText() {
        return menuButtonText;
    }

    public void setMenuButtonText(String menuButtonText) {
        this.menuButtonText = menuButtonText;
    }
    
}
