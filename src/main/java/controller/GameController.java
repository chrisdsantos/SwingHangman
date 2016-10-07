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
    
    /*public String getWord() {
        String word = model.getRandomWord();
        return word;
    }*/
    
}
