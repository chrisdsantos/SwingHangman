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
    private Scanner scan;
    private Color backgroundColor;
    private LocalDateTime dateTime;
    private int gameScore;
    private int guesses;
    private String randomWord;
    private ArrayList<String> dictionary;
       
    public GameModel(){
        backgroundColor = Color.BLACK;
    }
    
    public GameModel(String fileName){
        //backgroundColor = color;
        dictionary = new ArrayList<String>();
        this.readDictionary(fileName);
        this.selectRandomWord();
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
    public void setScore(int score) {
        this.gameScore = score;
    }
    
    //method: getScore
    //purpose: returns current score value
    public int getScore() {
        return gameScore;
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
    public void selectRandomWord() {
        Random rand = new Random();
        randomWord = this.dictionary.get(rand.nextInt(this.dictionary.size()));
    }
    
    //method: updateImage
    //purpose: updates image whenever there is a wrong guess
    public void updateImage(){
        int imageNumber = getGuessRemain();
        for(int i=1; i<8; i++){
            if(imageNumber == i){
                ImageIcon image = new ImageIcon(getClass().getResource(i+".jpg"));
                //panel.graphicsPanel.setIcon(image);
            }
        }
    }
    
    //method: getGuessRemain
    //purpose: returns number of guesses allowed
    public int getGuessRemain(){
        return guesses;
    }

    //method: setGuessRemain
    //purpose: allows to set number of guesses remaining
    public void setGuessRemain(int gr){
        guesses = gr;
    }
}
