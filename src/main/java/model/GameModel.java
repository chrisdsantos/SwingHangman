/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.model;

import java.awt.Color;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;

/**
 *
 * @author Chris
 */
public class GameModel implements PanelModel{

    private static final int INIT_SCORE = 100;
    private static final int INIT_GUESSES = 6;
    private int score;
    private int guesses;
    private ArrayList<String> dictionary;
    private Color backgroundColor;
    private LocalDateTime dateTime;
    private Scanner scan;
    private String randomWord;
    
    public GameModel(){
        backgroundColor = Color.BLACK;
        randomWord = "Placeholder";
    }
    
    public GameModel(String fileName){
        //backgroundColor = color;
        dictionary = new ArrayList<String>();
        this.readDictionary(fileName);
    }

    //method: setDateTime
    //purpose: sets game date/time to system date/time
    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }
    
    //method: getDateTime
    //purpose: returns current displayed date/time
    public String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM-dd-uuuu hh:mm:ss a");
        return dtf.format(dateTime);
    }

    //method: setScore
    //purpose: sets score value to points
    public void resetScore() {
        this.score = INIT_SCORE;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    //method: getScore
    //purpose: returns current score value
    public int getScore() {
        return score;
    }
    
    //method: setGuessRemain
    //purpose: allows to set number of guesses remaining
    public void resetGuessRemain(){
        guesses = INIT_GUESSES;
    }
    
    public void setGuessRemain(int g){
        guesses = g;
    }
    
    //method: getGuessRemain
    //purpose: returns number of guesses allowed
    public int getGuessRemain(){
        return guesses;
    }
    
    //method: readDictionary
    //purpose: reads a given file that contains words for game (dictionary)
    private void readDictionary(String dict) {
        try{
            this.scan = new Scanner(new File(dict));
        } catch(Exception e) {
            System.out.println("The file " + dict + " deos not exist.\n"
                    + "No dictionary file was loaded.");
            return;
        }
        while(scan.hasNextLine()) {
            this.dictionary.add(this.scan.nextLine());
        }
        scan.close();
    }
    
    //method: selectRandomWord
    //purpose: selects random word from dictionary
    public void setRandomWord() {
        Random rand = new Random();
        randomWord = this.dictionary.get(rand.nextInt(this.dictionary.size()));
    }
    
    public String getRandomWord(){
        return randomWord;
    }
}