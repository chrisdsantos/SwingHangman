/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.model;

import java.awt.Color;
import java.time.LocalDateTime;

/**
 *
 * @author Chris
 */
public class GameModel implements PanelModel{
    private Color backgroundColor;
    private int incorrectCount;
    private LocalDateTime dateTime;
    private int gameScore;
    private int[] lettersUsed;
    
    
    public GameModel(){
        backgroundColor = Color.BLACK;
    }
    
//    public GameModel(String title, String team, Color color, int time){
//        backgroundColor = color;
//        splashTime = time;
//    }

    //setDateTime
    //purpose: sets game date/time to system date/time
    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }
    
    //getDateTime
    //purpose: returns current displayed date/time
    public String getDateTime() {
        return dateTime.toString();
    }

    //setScore
    //purpose: sets score value to points
    public void setScore(int score) {
        this.gameScore = score;
    }
    
    //getScore
    //purpose: returns current score value
    public int getScore() {
        return gameScore;
    }

//    public int[] setLettersUsed(){
//        
//    }
    
    public int[] getLettersUsed(){
        return lettersUsed;
    }
}
