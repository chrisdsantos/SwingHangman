/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.model;

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
    private int incorrectCount;
    private int correctCount;
    private LocalDateTime dateTime;
    private int gameScore;
    private int[] lettersUsed;
//    private int guesses;
    private ArrayList<String> dictionary;
    private Scanner scan;
    private String randomWord;
    private char[] randomWordCharArray;
       
    public GameModel(){
    }
    
    public GameModel(String fileName){
        //backgroundColor = color;
        dictionary = new ArrayList<String>();
        this.readDictionary(fileName);
        randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        incorrectCount = 0;
        correctCount = 0;
        gameScore = 100;
    }
    
    public void reset(){
        randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        incorrectCount = 0;
        correctCount = 0;
        gameScore = 100;
    }

    //setDateTime
    //purpose: sets game date/time to system date/time
    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }
    
    public ArrayList<Integer> makeGuess(String guess){
        char guessChar = guess.charAt(0);
        ArrayList<Integer> positions = new ArrayList<>();
        for(int i = 0; i < randomWordCharArray.length; i++){
            if(randomWordCharArray[i] == guessChar){
                positions.add(i);
            }
        }
        if(positions.size() == 0){
            incorrectCount++;
            gameScore -= 10;
        } else {
            correctCount += positions.size();
        }
        return positions;
        
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
    
    //name: readDictionary()
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
            this.dictionary.add(this.scan.nextLine().toUpperCase());
        }
        scan.close();
    }
    
    //name: selectRandomWord()
    //purpose: selects random word from dictionary
    private String selectRandomWord() {
        Random rand = new Random();
        return this.dictionary.get(rand.nextInt(this.dictionary.size()));
    }
    
    
    
//    //method: updateImage
//    //purpose: updates image whenever there is a wrong guess
//    public void updateImage(){
//        int imageNumber = 6 - getGuessesRemaining();
//        for(int i=1; i<8; i++){
//            if(imageNumber == i){
//                ImageIcon image = new ImageIcon(getClass().getResource("hangman_gfx/"+i+".jpg"));
////                panel.graphicsPanel.setIcon(image);
//            }
//        }
//    }
//    
//    //method: getGuessesRemaining()
//    //purpose: returns number of guesses remaining
//    public int getGuessesRemaining(){
//        return guesses;
//    }

    public int getIncorrectCount() {
        return incorrectCount;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }
    
    public int getWordLength(){
        return randomWord.length();
    }
    
}
