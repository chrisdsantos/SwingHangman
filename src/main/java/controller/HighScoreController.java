/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controller;

import main.java.SwingProject;
import main.java.model.HighScoreModel;
import main.java.view.HighScorePanel;
/**
 *
 * @author Nahid
 */
public class HighScoreController {
    private HighScorePanel panel;
    private HighScoreModel model;
    private MainFrameController rootController;
    
    public HighScoreController(HighScorePanel panel, HighScoreModel model, MainFrameController rootController) {
        this.panel = panel;
        this.model = model;
        this.rootController = rootController;
        
        this.setup();
    }
    
    private void setup() {
        panel.setTitle(model.getHighScoreTitle());
        panel.setMembers(model.getMembers());
        panel.setBackgroundColor(model.getBackgroundColor());
        
        panel.getBackButton().addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
               rootController.changeVisibleCard(SwingProject.FUNCTION_KEY);
         }   
        });
    }
    
    public HighScorePanel getPanel() {
        return this.panel;
    }
    
    public void setPanel(HighScorePanel panel) {
        this.panel = panel;
    }
    
    public HighScoreModel getModel() {
        return this.model;
    }
    
    public void setModel(HighScoreModel model) {
        this.model = model;
    }

}
