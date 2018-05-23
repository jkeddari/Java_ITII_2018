package com.itii.planning.gui.alterTaskDialog;

import com.itii.planning.gui.newTaskDialog.TaskDialogInputPanel;

import javax.swing.*;

public class alterTaskDialogMainPanel extends JPanel {
    public alterTaskDialogMainPanel(JDialog ataskdialog, int id){
        add(new alterTaskDialogInputPanel(ataskdialog,id)); //Ajout InputPanel
    }

}
