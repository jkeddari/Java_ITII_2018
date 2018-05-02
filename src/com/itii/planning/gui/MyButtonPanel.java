package com.itii.planning.gui;

import com.itii.planning.gui.task.TaskDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MyButtonPanel extends JPanel {

    private JPanel ButtonZone;

    public MyButtonPanel() {
        ButtonZone = new JPanel();
        GridLayout ButtonGrid = new GridLayout(6, 1);
        ButtonZone.setLayout(ButtonGrid);
        JButton b_creer = new JButton("Créer");
        JButton b_dupliquer = new JButton("Dupliquer");
        JButton b_editer = new JButton("Editer");
        JButton b_marquer = new JButton("Marquer");
        JButton b_supprimer = new JButton("Supprimer");
        Date d=new Date();
        String s_date="Date du jour : "+(d.getYear()+1900)+"/"+(d.getMonth()+1)+"/"+(d.getDate());
        JLabel lab_date= new JLabel(s_date);


        ButtonZone.add(b_creer);
        ButtonZone.add(b_dupliquer);
        ButtonZone.add(b_editer);
        ButtonZone.add(b_marquer);
        ButtonZone.add(b_supprimer);
        ButtonZone.add(lab_date);

        b_creer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskDialog t=new TaskDialog();
            }
        });

    }

    public JPanel getMyButton(){
        return ButtonZone;
    }
}
