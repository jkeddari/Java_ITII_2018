package com.itii.planning.gui.MainWindow;

import com.itii.planning.gui.InterfaceButton;
import com.itii.planning.gui.newTaskDialog.TaskDialog;
import com.itii.planning.gui.ActionClass;
import javax.swing.*;
import java.awt.*;

import java.util.Calendar;

class MyButtonPanel extends JPanel implements InterfaceButton {

    MyButtonPanel() {

        GridLayout ButtonGrid = new GridLayout(6, 1);
        setLayout(ButtonGrid);


        Calendar d = Calendar.getInstance();

        String s_date="Date du jour : "+(d.get(Calendar.YEAR)+"/"+(d.get(Calendar.MONTH)+1)+"/"+d.get(Calendar.DATE));
        JLabel lab_date = new JLabel(s_date);

        add(b_creer);
        add(b_dupliquer);
        add(b_editer);
        add(b_marquer);
        add(b_supprimer);
        add(lab_date);

        b_creer.addActionListener(e -> new TaskDialog());

        b_dupliquer.addActionListener(e -> ActionClass.dupliquer());

        b_supprimer.addActionListener(e -> ActionClass.supprimer());

        b_marquer.addActionListener(e -> ActionClass.marquer());

        b_editer.addActionListener(e -> ActionClass.editer());

    }

}
