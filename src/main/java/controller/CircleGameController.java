/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controller;

import main.java.view.CircleGamePanel;

/**
 *
 * @author Omar
 */
public class CircleGameController {
    private CircleGamePanel panel;
    private MainFrameController rootController;
    
    public CircleGameController(CircleGamePanel panel, MainFrameController rootController){
        this.panel = (CircleGamePanel) panel;
        this.rootController = rootController;
        setup();
    }
    
    private void setup(){
        
    }
    
}
