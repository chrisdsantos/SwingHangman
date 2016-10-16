/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controller;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;
import main.java.SwingProject;
import main.java.view.CircleGamePanel;
import main.java.view.ColorButton;

/**
 *
 * @author Omar
 */
public class CircleGameController {
    private final int MAX_CIRCLE_DIAMETER = 50;
    
    private CircleGamePanel panel;
    private MainFrameController rootController;
    
    public CircleGameController(CircleGamePanel panel, MainFrameController rootController){
        this.panel = (CircleGamePanel) panel;
        this.rootController = rootController;
        setup();
    }
    
    private void setup(){
        panel.setLayout(null); // absolute positioning for this window
        panel.setRandomGoal(); //This should set a random font color and random color text for the label. It should also update a currentColorGoal variable
        panel.setCurrentRound(1); // Make sure set to round 1 for a new game
        
        ColorButton[] colorButtons = panel.getColorButtons();
        for(ColorButton jb : colorButtons){
            jb.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if(panel.getCurrentGoal.equals(jb.getColor())){
                        panel.increaseScore(100);
                    }
                    if(panel.getCurrentRound() >= 5){
                        rootController.changeVisibleCard(SwingProject.GAME_OVER_KEY);
                    } else {
                        panel.incrementRound();
                    }
                }
                
            });
        }
        
        Point lastLegalCoordinate = new Point(panel.getWidth() - MAX_CIRCLE_DIAMETER,panel.getHeight() - MAX_CIRCLE_DIAMETER);
        placeButtons(circleButtons,lastLegalCoordinate);
        
    }
    
    private void placeButtons(JButton[] buttons,Point bound){
        Random random = new Random();
        for(JButton jb:buttons){
                    jb.setVisible(false);
        }
        for(int i = 0;i<buttons.length;i++){
            boolean placed = false;
            int tries = 0;
            while(!placed && tries < 100){
                Point candidateLocation = new Point(random.nextInt(bound.x),random.nextInt(bound.y));
                if(testClearance(candidateLocation)){
                    buttons[i].setBounds(candidateLocation.x, candidateLocation.y, MAX_CIRCLE_DIAMETER, MAX_CIRCLE_DIAMETER);
                    buttons[i].setVisible(true);
                    placed = true;
                } else {
                    tries++;
                }
            }
            if(tries > 9){
                for(JButton jb:buttons){
                    jb.setVisible(false);
                }
                i = 0;
            }
        }
    }
    
    private boolean testClearance(Point p){
        Component c = panel.findComponentAt(p);
        boolean clearTopLeft = (c != null) && (c == panel);
        c = panel.findComponentAt(p.x + MAX_CIRCLE_DIAMETER,p.y);
        boolean clearTopRight = (c != null) && (c == panel);
        c = panel.findComponentAt(p.x,p.y + MAX_CIRCLE_DIAMETER);
        boolean clearBottomLeft = (c != null) && (c == panel);
        c = panel.findComponentAt(p.x + MAX_CIRCLE_DIAMETER,p.y + MAX_CIRCLE_DIAMETER);
        boolean clearBottomRight = (c != null) && (c == panel);
        
        return clearTopLeft && clearTopRight && clearBottomLeft && clearBottomRight;
    }

    public JPanel getPanel() {
        return this.panel;
    }
    
}
