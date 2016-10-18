/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.model;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Jazmin
 */
public abstract class BestScore implements Comparable <BestScore> 
{
    String name [];
    int score [];
    
    public BestScore()
    {
        File hsFile;
        BufferedReader inStream;
        String s = "";
        int nameS;
        int count = 0;
        
        name = new String[HighScoreModel.numScore];
        score = new int[HighScoreModel.numScore];
        
        // Make sure file exists
        hsFile = new File(HighScoreModel.highScoresFileName);
        if(!hsFile.exists())
        {
            // create file if doesn't exist
            try
            {
                hsFile.createNewFile();
            }
            catch(Exception e) {
                System.out.println("Error creating file " + HighScoreModel.highScoresFileName);
                System.out.println(e);
                return;
            }
            
            for (int i = 0; i < HighScoreModel.numScore; i++)
            {
                score[i] = 0;
                name[i] = "null";
            }
        }
        else // open file
        {
            try
            {
                inStream = new BufferedReader(new FileReader(HighScoreModel.highScoresFileName));
            }
            catch(Exception e)
            {
                System.out.println("Error reading file " + HighScoreModel.highScoresFileName);
                System.out.println(e);
                return;
            }
            
             // read high scores into names and scores arrays
            try
            {
                s = inStream.readLine();
            }catch(Exception e){}
            while ((s != null) && (count < HighScoreModel.numScore)){
                nameS = s.indexOf('\t');
                score[count] = Integer.valueOf(s.substring(0,nameS));
                name[count] = s.substring(nameS +1, s.length());
                try
                {
                    s= inStream.readLine();
                }
                catch(Exception e){}
                count++;
            }
            
            // close file
            try
            {
                inStream.close();
            }
            catch(Exception e)
            {
                System.out.println("Error closing file " + HighScoreModel.highScoresFileName);
                System.out.println(e);
            }
            
        }
        
    }
    
    // print scores
    public void showScores(String name, int score)
    {
        String highScores = " ";
        
        
    }
    
    // add score
    public void addScore(int firstscore)
    {

    }
    
    // sort scores
    public void sortScores(){
        String tempName;
        int tempScore;
        
        // Just need one round of bubble sort
        for (int i = score.length - 1; i > 0; i--){
            if (score[i] > score[i-1]){
                tempName = name[i];
                tempScore = score[i];
                name[i] = name[i-1];
                score[i] = score[i-1];
                name[i-1] = tempName;
                score[i-1] = tempScore;
            }            
        }
    }
    
    // write scores to file
    
    public void writeScores()
    {
        File hsFile;
        BufferedWriter outStream;
        
        // make sure file exists
        hsFile = new File(HighScoreModel.highScoresFileName);
        if (!hsFile.exists())
        {
            System.out.println(HighScoreModel.highScoresFileName + " does not exist.");
            return;
        }
        
        // open output file
        try
        {
            outStream = new BufferedWriter(new FileWriter(HighScoreModel.highScoresFileName));
        }
        catch(Exception e)
        {
            System.out.println("Error reading file " + HighScoreModel.highScoresFileName);
            System.out.println(e);
            return;
        }
        
        // write to output file
        try
        {
            for(int i = 0; i < HighScoreModel.numScore; i++)
            {
                outStream.write(score[i] + "\t" + name[i] + "\n");
            }
        }
        catch(Exception e){}
        
        // close file
        try
        {
            outStream.close();
        }
        catch(Exception e)
        {
            System.out.println("Error closing file " + HighScoreModel.highScoresFileName);
            System.out.println(e);
        }
    }
    
    
       
}
