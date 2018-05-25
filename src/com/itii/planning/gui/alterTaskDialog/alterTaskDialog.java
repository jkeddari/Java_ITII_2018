package com.itii.planning.gui.alterTaskDialog;


import javax.swing.*;

public class alterTaskDialog extends JDialog {

    public alterTaskDialog(int id, int status){

        setTitle("Modification Evenement");
        setSize(380,220);
        setVisible(true);


        setContentPane(new alterTaskDialogMainPanel(this, id, status));
        this.validate();
        this.repaint();
    }
}
