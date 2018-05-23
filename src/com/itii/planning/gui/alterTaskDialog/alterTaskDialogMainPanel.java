package com.itii.planning.gui.alterTaskDialog;

import com.itii.planning.gui.newTaskDialog.TaskDialogInputPanel;

import javax.swing.*;

public class alterTaskDialogMainPanel extends JPanel {
    public alterTaskDialogMainPanel(JDialog ataskdialog, int id, int status){
        add(new alterTaskDialogInputPanel(ataskdialog,id,status)); //Ajout InputPanel
    }

}
