package com.itii.planning.gui.task;

import javax.swing.*;
import java.awt.*;


public class TaskDialog extends JDialog {

    public TaskDialog() {

        setTitle("Nouvelle évenement");
        setSize(420,180);
        setVisible(true);


        setContentPane(new TaskDialogMainPanel(this));
        this.validate();
        this.repaint();
    }

}