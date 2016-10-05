/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.SwingProject;
import main.java.model.CreditsModel;
import main.java.view.CreditsPanel;

/**
 *
 * @author Marc
 */
public class CreditsController {
    private CreditsPanel panel;
    private CreditsModel model;
    private MainFrameController rootController;

    public CreditsController(CreditsPanel panel, CreditsModel model, MainFrameController rootController) {
        this.panel = panel;
        this.model = model;
        this.rootController = rootController;
        
        this.setup();
    }

    private void setup() {
        panel.setTitle(model.getCreditsTitle());
        panel.setMembers(model.getMembers());
        panel.setBackgroundColor(model.getBackgroundColor());
        panel.getBackButton().setText(model.getBackButtonText());
        
        panel.getBackButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                rootController.changeVisibleCard(SwingProject.FUNCTION_KEY);
            }
        });
    }
    
    public CreditsPanel getPanel() {
        return this.panel;
    }
    
    public void setPanel(CreditsPanel panel) {
        this.panel = panel;
    }
    
    public CreditsModel getModel() {
        return this.model;
    }
    
    public void setModel(CreditsModel model) {
        this.model = model;
    }
}
