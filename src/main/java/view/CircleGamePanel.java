/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Chris, Omar
 */
public class CircleGamePanel extends JPanel{
    private LocalDateTime dateTime;
    private int circleGameScore;
    private int currentRound;
    private String currentGoal;
    private final String[] COLOR_NAMES = {"RED", "GREEN", "BLUE", "YELLOW", "PURPLE"};
    
    public CircleGamePanel(){
        circleGameScore = 0;
        currentRound = 0;
    }
    
    //name: getDateTime
    //purpose: returns current displayed date/time
    public String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM-dd-uuuu hh:mm:ss a");
        return dtf.format(dateTime);
    }
    
    //name: reset
    //purpose: reinitializes game's default data
    public void reset(){
        circleGameScore = 0;
        currentRound = 0;
    }
    
    //name: getCurrentRound
    //purpose: retrieves current round data   
    public int getCurrentRound(){
        return currentRound;
    }

    //name: incrementRound
    //purpose: increments current round data by 1 
    public void incrementRound(){
        setCurrentRound(getCurrentRound()+1);
    }
 
    //name: setCurrentRound
    //purpose: sets current round to given integer
    public void setCurrentRound(int round){
        currentRound = round;
    }
    
    public void increaseScore(int s){
        circleGameScore+=s;
    }
    
    public void setRandomGoal(){
        Random rand = new Random();
        int n = rand.nextInt(5);
        //randomize text
        String buttonColorName = COLOR_NAMES[n];
        //randomize color
        
        //update color goal
        currentGoal = COLOR_NAMES[n];
    }
    
    public String getCurrentGoal(){
        return currentGoal;
    }
    
    public ColorButton[] getColorButtons(){
        ColorButton[] b = {getRedButton(), getGreenButton(), getBlueButton(), getYellowButton(), getPurpleButton()};
        return b;
    }
    
    public ColorButton getRedButton(){
        ColorButton b = new ColorButton();
        String colorName = COLOR_NAMES[0];
        return b;
    }
    
    public ColorButton getGreenButton(){
        ColorButton b = new ColorButton();
        String colorName = COLOR_NAMES[1];
        return b;  
    }
    
    public ColorButton getBlueButton(){
        ColorButton b = new ColorButton();
        String colorName = COLOR_NAMES[2];
        return b;  
    }
        
    public ColorButton getYellowButton(){
        ColorButton b = new ColorButton();
        String colorName = COLOR_NAMES[3];
        return b; 
    }
    
    public ColorButton getPurpleButton(){
        ColorButton b = new ColorButton();
        String colorName = COLOR_NAMES[4];
        return b;
    }
}
