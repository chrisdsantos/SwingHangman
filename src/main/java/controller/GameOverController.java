/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.SwingProject;
import main.java.model.GameOverModel;
import main.java.view.GameOverPanel;

/**
 *
 * @author Marc
 */
public class GameOverController {
    private GameOverPanel panel;
    private GameOverModel model;
    private MainFrameController rootController;

    public GameOverController(GameOverPanel panel, GameOverModel model, MainFrameController rootController) {
        this.panel = panel;
        this.model = model;
        this.rootController = rootController;
        
        this.setup();
    }

    private void setup() {
        panel.getGameOverLabel().setText(model.GAME_OVER_TEXT);
        panel.getMenuButton().setText(model.getMenuButtonText());
        panel.getResetButton().setText(model.getNewGameButtonText());
        panel.getScoreLabel().setText("Final Score: " + String.valueOf(model.getScore()));
        
        panel.getMenuButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                rootController.changeVisibleCard(SwingProject.FUNCTION_KEY);
            }
        });
        
        panel.getResetButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                rootController.changeVisibleCard(SwingProject.GAME_KEY);
            }
        });
    }
    
    public GameOverPanel getPanel() {
        return this.panel;
    }
    
    public void setPanel(GameOverPanel panel) {
        this.panel = panel;
    }
    
    public GameOverModel getModel() {
        return this.model;
    }
    
    public void setModel(GameOverModel model) {
        this.model = model;
    }
}
