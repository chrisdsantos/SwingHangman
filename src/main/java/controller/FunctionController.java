/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import main.java.SwingProject;
import main.java.model.FunctionModel;
import main.java.view.FunctionPanel;


/**
 *
 * @author Omar
 */
public class FunctionController {
    private FunctionPanel panel;
    private FunctionModel model;
    private MainFrameController rootController;
    
    public FunctionController(FunctionPanel panel, FunctionModel model,MainFrameController rootController){
        this.model = (FunctionModel) model;
        this.panel = (FunctionPanel) panel;
        this.rootController = rootController;
        setup();
    }
    
    private void setup(){
        panel.setBackground(model.getBackgroundColor());
        panel.getPlayButton().setText(model.getButton1());
        panel.getHighScoresButton().setText(model.getButton2());
        panel.getCreditsButton().setText(model.getButton3());
        
        panel.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                int currentSize = panel.getHeight() * panel.getWidth();
                if(currentSize<360000){
                    panel.changeImageSize(3);
                } else if(currentSize<1160000){
                    panel.changeImageSize(2);
                } else {
                    panel.changeImageSize(1);
                }
            }

            @Override
            public void componentMoved(ComponentEvent e) {
            }

            @Override
            public void componentShown(ComponentEvent e) {
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }
        });
        panel.getPlayButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                rootController.changeVisibleCard(SwingProject.GAME_KEY);
            }
        });
        panel.getHighScoresButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                rootController.changeVisibleCard(SwingProject.HIGH_SCORE_KEY);
            }
        });
        panel.getCreditsButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                rootController.changeVisibleCard(SwingProject.CREDITS_KEY);
            }
        });
    }
    
    public FunctionPanel getPanel(){
        return panel;
    }
    
}
