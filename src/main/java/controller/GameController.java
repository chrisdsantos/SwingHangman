/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import main.java.SwingProject;
import static main.java.SwingProject.DICTIONARY;
import main.java.model.GameModel;
import main.java.view.GamePanel;


/**
 *
 * @author Chris
 */
public class GameController implements ActionListener{
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
        model.resetScore();
        model.resetGuessRemain();
        model.setRandomWord();
        addKeyboardAction();
        //model.getImage();
        panel.setWordPanel(model.getRandomWord());
                
        //while(model.getGuessRemain()>0){
            panel.addAncestorListener(new AncestorListener(){
                @Override
                public void ancestorAdded(AncestorEvent event) {
                    Timer clock = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            model.setDateTime();
                            panel.setDateTimeLabel(model.getDateTime());
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
        //}
    }
    
    //actionPerformed
    //purpose: functions for each key
    public void actionPerformed(ActionEvent e){
        String key;
        
        //keyboard functions
        for(int i=0;i<26;i++){
            int asciiKey = i+65;
            if (Character.toString((char)asciiKey).equals(e.getActionCommand())){
                panel.getKeyboardButton(i).setEnabled(false);
                key = panel.getKeyboardButton(i).getText();
                model.setGuessRemain(model.getGuessRemain()-1);
                if(model.getGuessRemain()<=0){
                    rootController.changeVisibleCard(SwingProject.CREDITS_KEY);
                }
            }
        }
        if("skip".equals(e.getActionCommand())){
            rootController.changeVisibleCard(SwingProject.CREDITS_KEY);
        }
        
    }
    
    
    public void addKeyboardAction(){
        for(int i=0;i<26;i++){
            panel.getKeyboardButton(i).addActionListener(this);
        }
        //panel.getSkipButton().addActionListener(this);
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
}