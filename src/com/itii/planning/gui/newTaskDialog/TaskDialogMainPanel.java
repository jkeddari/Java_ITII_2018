package com.itii.planning.gui.newTaskDialog;

import javax.swing.*;

public class TaskDialogMainPanel extends JPanel {

    public TaskDialogMainPanel(JDialog taskdialog){
        add(new TaskDialogInputPanel(taskdialog)); //Ajout InputPanel
    }
}
