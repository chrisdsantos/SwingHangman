/*************************************************************** 
*file: GameOverController.java 
* author: Jazmin Guerrero, Omar Rodriguez, Marc Deaso 
* class: CS 245 - Programming Graphical User Interfaces
* 
* 
*assignment: Swing Project 1 
* date last modified: 10/06/2016
* 
* purpose: This class is the controller between the gameover view
* and gameover model
* 
****************************************************************/ 
package main.java.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.SwingProject;
import main.java.model.GameOverModel;
import main.java.view.GameOverPanel;

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

    // method: setup
    // purpose: Connects information stored in model to the view
    // ie sets label names, button names.
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
