package com.itii.planning.gui.newTaskDialog;

import javax.swing.*;


public class TaskDialog extends JDialog {


    public TaskDialog() {

        setTitle("Nouvelle évenement");
        setSize(380,220);
        setVisible(true);


        setContentPane(new TaskDialogMainPanel(this));
        this.validate();
        this.repaint();
    }

}