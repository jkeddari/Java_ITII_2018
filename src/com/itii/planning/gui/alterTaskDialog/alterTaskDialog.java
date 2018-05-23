package com.itii.planning.gui.alterTaskDialog;
import com.itii.planning.gui.newTaskDialog.TaskDialogMainPanel;

import javax.swing.*;

public class alterTaskDialog extends JDialog {

    public alterTaskDialog(int id){

        setTitle("Modification Evenement");
        setSize(380,220);
        setVisible(true);


        setContentPane(new alterTaskDialogMainPanel(this, id));
        this.validate();
        this.repaint();
    }
}
