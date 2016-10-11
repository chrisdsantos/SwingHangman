/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import main.java.SwingProject;
import main.java.model.GameModel;
import main.java.view.GamePanel;


/**
 *
 * @author Chris
 */
public class GameController{
    private GamePanel panel;
    private GameModel model;
    private MainFrameController rootController;
    
    public GameController(GamePanel panel, GameModel model, MainFrameController rootController){
        this.panel = (GamePanel) panel;
        this.model = (GameModel) model;
        this.rootController = rootController;
        setup();
    }
    
    private void setup(){
        panel.getPoints().setText("Points: "+ Integer.toString(model.getGameScore()));
        panel.getGameNameLabel().setText("Hangman");
        panel.addBlanks(model.getWordLength());
        
        
        for(JButton jb : panel.getKeyboardButtonArray()){
            jb.addActionListener((ActionEvent e) -> {
                jb.setEnabled(false);
                ArrayList<Integer> positions = model.makeGuess(jb.getText());
                for(int pos : positions){
                    panel.getBlanksArrayList().get(pos).setLetter(jb.getText());
                    panel.getBlanksArrayList().get(pos).repaint();
                }
                if(positions.isEmpty()){
                    panel.getHmPanel().incrementIncorrectGuesses();
                    panel.getHmPanel().repaint();
                }
                
                panel.getBlanksArrayList().get(1);
                panel.getPoints().setText("Points: "+ Integer.toString(model.getGameScore()));
                int incorrectCount = model.getIncorrectCount();
                System.out.println("ic: " + incorrectCount);
                int correctCount = model.getCorrectCount();
                System.out.println("cc: " + correctCount);
                System.out.println("wl: " + model.getWordLength());
                if(incorrectCount > 5 || correctCount == model.getWordLength()){
                    panel.getSkipButton().setEnabled(false);
                    for(JButton button : panel.getKeyboardButtonArray()){
                        button.setEnabled(false);
                    }
                    Timer timer = new Timer(1500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            rootController.changeVisibleCard(SwingProject.GAME_OVER_KEY);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
//                    rootController.changeVisibleCard(SwingProject.GAME_OVER_KEY);
                }
            });
        }

        model.setScore(100);
                
        panel.addAncestorListener(new AncestorListener(){
            @Override
            public void ancestorAdded(AncestorEvent event) {
                Timer clock = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.setDateTime();
                        panel.setDateTime(model.getDateTime());
                    }
                });
                clock.setInitialDelay(0);
                clock.setRepeats(true);
                clock.start();
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
            }
            
        });
        
        panel.getSkipButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                model.setScore(0);
                rootController.changeVisibleCard(SwingProject.GAME_OVER_KEY);
            }
            
        });
    }

    public GamePanel getPanel() {
        return panel;
    }

    public void setPanel(GamePanel panel) {
        this.panel = panel;
    }

    public GameModel getModel() {
        return model;
    }

    public void setModel(GameModel model) {
        this.model = model;
    }
    
    public void resetGame(){
        model.reset();
        panel.getPoints().setText("Points: "+ Integer.toString(model.getGameScore()));
        panel.addBlanks(model.getWordLength());
        panel.getHmPanel().setIncorrectGuesses(0);
        for(JButton jb : panel.getKeyboardButtonArray()){
            jb.setEnabled(true);
        }
        panel.getSkipButton().setEnabled(true);
    }
    
    /*public String getWord() {
        String word = model.getRandomWord();
        return word;
    }*/
    
}
