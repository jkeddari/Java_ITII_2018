package com.itii.planning.gui.task;

import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;

public class TaskDialogInputPanel extends JPanel{

    public TaskDialogInputPanel(){

        setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();

        //Nom de tache
        grid.gridx=0;
        grid.gridy=0;
        grid.weightx=0.1;
        grid.weighty=1;
        add(new JLabel("Nom de la tâche : "),grid);

        grid.gridx=1;
        grid.weightx=1;
        grid.fill=GridBagConstraints.HORIZONTAL;

        JTextField JT_event_name = new JTextField();
        add(JT_event_name,grid);



        //Date
        grid.gridx=0;
        grid.gridy=1;
        grid.weightx=0.2;
        grid.weighty=1;
        grid.fill=GridBagConstraints.NONE;
        add(new JLabel("Date : "),grid);

        grid.gridx=1;
        grid.gridy=1;
        grid.fill=GridBagConstraints.HORIZONTAL;
        JDatePicker date= new JDatePicker();
        add(date,grid);

        //Heure
        grid.gridx=0;
        grid.gridy=2;
        grid.weightx=1;
        grid.weighty=1;
        grid.fill=GridBagConstraints.HORIZONTAL;
        add(new TaskDialogTimePanel(),grid);

        //Commentaire
        grid.gridx=0;
        grid.gridy=3;
        grid.insets = new Insets(0,0,0,5);
        grid.weightx=0.1;
        grid.weighty=5;
        grid.fill=GridBagConstraints.NONE;
        add(new JLabel("Commentaire : "),grid);

        grid.gridx=1;
        grid.fill=GridBagConstraints.HORIZONTAL;

        JTextArea JT_event_comment = new JTextArea(3,1);
        add(JT_event_comment,grid);

    }

}
