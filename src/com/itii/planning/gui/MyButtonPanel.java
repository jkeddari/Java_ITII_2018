package com.itii.planning.gui;

import com.itii.planning.gui.task.TaskDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MyButtonPanel extends JPanel implements InterfaceButton {

    public MyButtonPanel() {

        GridLayout ButtonGrid = new GridLayout(6, 1);
        setLayout(ButtonGrid);
        JButton b_creer = new JButton("Créer");
        JButton b_dupliquer = new JButton("Dupliquer");
        JButton b_editer = new JButton("Editer");
        JButton b_marquer = new JButton("Marquer");

        Date d=new Date();
        String s_date="Date du jour : "+(d.getYear()+1900)+"/"+(d.getMonth()+1)+"/"+(d.getDate());
        JLabel lab_date= new JLabel(s_date);


        add(b_creer);
        add(b_dupliquer);
        add(b_editer);
        add(b_marquer);
        add(b_supprimer);
        add(lab_date);

        b_creer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new TaskDialog();
            }
        });

    }


}
