
package main.java.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.SwingProject;
import main.java.model.HighScoreModel;
import main.java.view.HighScorePanel;

//Class: HighScoreController
/*Porpuse: delcareing panel, model, controller as privata and set up all geter, 
 *seter methods to having access to variables and Modyfing variables like
 *title of page, Members of group,the color of back ground page and back buton
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
    
    //Method: setup
    //Purpose: Modifing variables title name, members name, background color and back button
    private void setup() {
        panel.setTitle(model.getHighScoreTitle());
        panel.setMembers(model.getMembers());
        panel.setBackgroundColor(model.getBackgroundColor());
        panel.getBackButton().setText(model.getBackButtonText());
        
        panel.getBackButton().addActionListener(new ActionListener(){
            
         public void actionPerformed(ActionEvent e){
               rootController.changeVisibleCard(SwingProject.FUNCTION_KEY);
         }   
        });
    }
    
    //Method: getPanel
    //Purpose: Having access to panel variable
    public HighScorePanel getPanel() {
        return this.panel;
    }
    
    //Method: setPanel
    //Purpose: Modyfing the panel of HighScore
    public void setPanel(HighScorePanel panel) {
        this.panel = panel;
    }
    
    //Method: getModel
    //Purpose: Having access to model variable
    public HighScoreModel getModel() {
        return this.model;
    }
    
    //Method: setModel
    //Purpose: Modyfing the Model variable
    public void setModel(HighScoreModel model) {
        this.model = model;
    }

}
