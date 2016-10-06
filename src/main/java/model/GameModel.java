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
<<<<<<< HEAD
import javax.swing.ImageIcon;
=======
>>>>>>> 7e2ae539887ac3545af95eaf21bfc1b49f89d10e

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
<<<<<<< HEAD
    private int guesses;
=======
>>>>>>> 7e2ae539887ac3545af95eaf21bfc1b49f89d10e
    private ArrayList<String> dictionary;
    private Scanner scan;
    private String randomWord;
       
    public GameModel(){
        backgroundColor = Color.BLACK;
<<<<<<< HEAD
        
=======
>>>>>>> 7e2ae539887ac3545af95eaf21bfc1b49f89d10e
    }
    
    public GameModel(String fileName){
        //backgroundColor = color;
        dictionary = new ArrayList<String>();
        this.readDictionary(fileName);
        this.selectRandomWord();
    }

    //setDateTime
    //purpose: sets game date/time to system date/time
    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }
    
    //getDateTime
    //purpose: returns current displayed date/time
    public String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM-dd-uuuu hh:mm:ss a");
        return dtf.format(dateTime);
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
    
    public String getRandomWord() {
        return randomWord;
    }
    
<<<<<<< HEAD
    //name: readDictionary()
    //purpose: reads a given file that contains words for game (dictionary)
=======
>>>>>>> 7e2ae539887ac3545af95eaf21bfc1b49f89d10e
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
    
<<<<<<< HEAD
    //name: selectRandomWord()
    //purpose: selects random word from dictionary
=======
>>>>>>> 7e2ae539887ac3545af95eaf21bfc1b49f89d10e
    private void selectRandomWord() {
        Random rand = new Random();
        randomWord = this.dictionary.get(rand.nextInt(this.dictionary.size()));
    }
<<<<<<< HEAD
    
    //method: updateImage
    //purpose: updates image whenever there is a wrong guess
    public void updateImage(){
        int imageNumber = 6 - getGuessesRemaining();
        for(int i=1; i<8; i++){
            if(imageNumber == i){
                ImageIcon image = new ImageIcon(getClass().getResource("hangman_gfx/"+i+".jpg"));
                panel.graphicsPanel.setIcon(image);
            }
        }
    }
    
    //method: getGuessesRemaining()
    //purpose: returns number of guesses remaining
    public int getGuessesRemaining(){
        return guesses;
    }
}
=======
}
>>>>>>> 7e2ae539887ac3545af95eaf21bfc1b49f89d10e
