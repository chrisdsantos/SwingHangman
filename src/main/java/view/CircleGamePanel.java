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
    private final ColorButton[] buttons = {
        getRedButton(), 
        getGreenButton(), 
        getBlueButton(), 
        getYellowButton(), 
        getPurpleButton()
    };
    private final String[] COLOR_NAMES = {
        "RED", 
        "GREEN", 
        "BLUE", 
        "YELLOW", 
        "PURPLE"
    };
    public Object getCurrentGoal;//??
    
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

    //name: increaseScore
    //purpose: adds value s to current score  
    public void increaseScore(int s){
        circleGameScore+=s;
    }

    //name: setRandomGoal
    //purpose: sets the color goal randomly    
    public void setRandomGoal(){
        Random rand = new Random();
        int randomColorName = rand.nextInt(5);
        //randomize text
        String buttonColorName = COLOR_NAMES[randomColorName];
        //randomize text color
        int randomColor = rand.nextInt(5);
        //update color goal
        currentGoal = COLOR_NAMES[randomColorName];
    }

    //name: getCurrentGoal
    //purpose: retrieves current color needed to score    
    public String getCurrentGoal(){
        return currentGoal;
    }

    //name: getColorButtons
    //purpose: retrieves all buttons packaged into array 
    public ColorButton[] getColorButtons(){
        return buttons;
    }

    //name: getRedButton
    //purpose: retrieves red button data
    public ColorButton getRedButton(){
        ColorButton b = new ColorButton();
        b.setColor(COLOR_NAMES[0]);
        return b;
    }

    //name: getGreenButton
    //purpose: retrieves green button data
    public ColorButton getGreenButton(){
        ColorButton b = new ColorButton();
        b.setColor(COLOR_NAMES[1]);
        return b;  
    }
    
    //name: getBlueButton
    //purpose: retrieves blue button data
    public ColorButton getBlueButton(){
        ColorButton b = new ColorButton();
        b.setColor(COLOR_NAMES[2]);
        return b;
    }

    //name: getYellowButton
    //purpose: retrieves yellow button data
    public ColorButton getYellowButton(){
        ColorButton b = new ColorButton();
        b.setColor(COLOR_NAMES[3]);
        return b; 
    }

    //name: getPurpleButton
    //purpose: retrieves purple button data
    public ColorButton getPurpleButton(){
        ColorButton b = new ColorButton();
        b.setColor(COLOR_NAMES[4]);
        return b;
    }
}
