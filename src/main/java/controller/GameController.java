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
        model.setDateTime();
        panel.setDateTime(model.getDateTime());
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
