package com.itii.planning.gui.task;

import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;


public class TaskDialog extends JDialog {

    public TaskDialog() {

        setTitle("Nouvelle évenement");
        setSize(240,160);
        setVisible(true);


        JPanel PaneTaskDialog = new JPanel();
        GridLayout grid = new GridLayout();
        PaneTaskDialog.setLayout(new GridLayout(3,1));

        JTextField JT_event_name = new JTextField();
        PaneTaskDialog.add(new JLabel("Nom de la tâche : "));
        PaneTaskDialog.add(JT_event_name,BorderLayout.EAST);

        JDatePicker date= new JDatePicker();
        PaneTaskDialog.add(date);

        JTextField JT_event_comment = new JTextField(20);
        PaneTaskDialog.add(new JLabel("Commentaire : "));
        PaneTaskDialog.add(JT_event_comment,BorderLayout.EAST);

        setContentPane(PaneTaskDialog);
        this.validate();
        this.repaint();

    }
}