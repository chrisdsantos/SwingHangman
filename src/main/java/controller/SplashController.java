/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingproject1.src.main.java.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import swingproject1.src.main.java.SwingProject;
import swingproject1.src.main.java.model.SplashModel;
import swingproject1.src.main.java.view.SplashPanel;

/**
 *
 * @author Omar
 */
public class SplashController{
    private SplashPanel panel;
    private SplashModel model;
    private MainFrameController rootController;
    
    public SplashController(SplashPanel panel, SplashModel model,MainFrameController rootController){
        this.panel = (SplashPanel) panel;
        this.model = (SplashModel) model;
        this.rootController = rootController;
        setup();
    }
    private void setup(){
        panel.setTitle(model.getSplashTitle());
        panel.setTeam(model.getTeamName());
        panel.setBackgroundColor(model.getBackgroundColor());
        
        panel.addAncestorListener(new AncestorListener(){
            @Override
            public void ancestorAdded(AncestorEvent event) {
                Timer timer = new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        rootController.changeVisibleCard(SwingProject.FUNCTION_KEY);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
            }
            
        });
    }

    public SplashPanel getPanel() {
        return panel;
    }

    public void setPanel(SplashPanel panel) {
        this.panel = panel;
    }

    public SplashModel getModel() {
        return model;
    }

    public void setModel(SplashModel model) {
        this.model = model;
    }
    
    
    
}
