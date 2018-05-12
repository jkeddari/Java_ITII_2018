package com.itii.planning.gui.task;

import javax.swing.*;


public class TaskDialog extends JDialog {

    public TaskDialog() {

        setTitle("Nouvelle évenement");
        setSize(500,280);
        setVisible(true);


        setContentPane(new TaskDialogMainPanel(this));
        this.validate();
        this.repaint();
    }

}