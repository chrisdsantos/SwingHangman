/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;

import java.awt.Color;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import main.java.controller.*;
import main.java.model.*;
import main.java.view.*;

/**
 *
 * @author Omar
 */
public class SwingProject {
    public static final String PROJECT_NAME = "CS 245 - Swing Project v1";
    public static final String CONTRIBUTORS[] = {
        "Omar Rodriguez, #",
        "Nahid Enayatzadeh , #",
        "Marc Deaso, #",
        "Christopher Santos, #"};
    
    public static final String SPLASH_KEY = "splashscreen";
    public static final String FUNCTION_KEY = "functionscreen";
    public static final String HIGH_SCORE_KEY = "highscorescreen";
    public static final String CREDITS_KEY = "creditsscreen";
    public static final String GAME_KEY = "gamescreen";
    public static final String GAME_OVER_KEY = "gameoverscreen";

    private MainFrameController mainFrameController;
    
    private SplashController splashController;
    private FunctionController functionController;
    private CreditsController creditsController;
    private GameOverController gameoverController;
    
    private SwingProject(){
    }
    
    private void setup(){
        mainFrameController = new MainFrameController(
                new MainFrameModel(PROJECT_NAME,600,400,null,EXIT_ON_CLOSE), 
                new MainFrame()
        );
        
        splashController = new SplashController(
                new SplashPanel(),
                new SplashModel(PROJECT_NAME,"REDS",Color.BLACK,3000),
                mainFrameController
        );
        
        functionController = new FunctionController(
                new FunctionPanel(),
                new FunctionModel(Color.BLACK,"Play","Highscores","Credits"),
                mainFrameController
        );
        
        creditsController = new CreditsController(
                new CreditsPanel(),
                new CreditsModel("Credits", CONTRIBUTORS, Color.BLACK),
                mainFrameController
        );
        
        gameoverController = new GameOverController(
                new GameOverPanel(),
                new GameOverModel(),
                mainFrameController
        );
                
        mainFrameController.addPanel(splashController.getPanel(),SPLASH_KEY);
        mainFrameController.addPanel(functionController.getPanel(),FUNCTION_KEY);
        mainFrameController.addPanel(creditsController.getPanel(),CREDITS_KEY);
        mainFrameController.addPanel(gameoverController.getPanel(),GAME_OVER_KEY);
    }
    
    private void setupAndStart(){
        javax.swing.SwingUtilities.invokeLater(() -> {
            setup();
//            mainFrameController.changeVisibleCard(GAME_OVER_KEY);
            mainFrameController.changeVisibleCard(SPLASH_KEY);
            mainFrameController.getFrame().setVisible(true);
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingProject game = new SwingProject();
        game.setupAndStart();
    }
    
}
