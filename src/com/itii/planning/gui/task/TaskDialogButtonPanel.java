package com.itii.planning.gui.task;

import com.itii.planning.gui.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskDialogButtonPanel extends JPanel {

    public TaskDialogButtonPanel(JDialog taskdialogue){
        GridLayout ButtonGrid = new GridLayout(2, 1);
        JButton b_valider = new JButton("Valider");
        JButton b_annuler = new JButton("Annuler");



        b_annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taskdialogue.dispose();
            }
        });


        add(b_valider);
        add(b_annuler);
    }

}
