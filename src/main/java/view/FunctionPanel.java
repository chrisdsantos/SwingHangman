/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingproject1.src.main.java.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Omar
 */
public class FunctionPanel extends JPanel{
        public FunctionPanel() {
        initComponents();
    }
                        
    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints = new GridBagConstraints();
        JButton button = new JButton("Long-Named Button 4");
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridwidth = 2;
        gridConstraints.gridheight = 2;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        this.add(button, gridConstraints);
        
        JButton other = new JButton("other");
        gridConstraints.gridwidth = 1;
        gridConstraints.gridheight = 1;
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 2;
        this.add(other, gridConstraints);
    }
}
