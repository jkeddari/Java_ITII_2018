package com.itii.planning.gui.MainWindow;

import com.itii.planning.gui.InterfaceButton;
import com.itii.planning.gui.InterfaceTable;
import com.itii.planning.objTask.ActionClass;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MyButtonPanel extends JPanel implements InterfaceButton, InterfaceTable {

    public MyButtonPanel() {

        GridLayout ButtonGrid = new GridLayout(6, 1);
        setLayout(ButtonGrid);

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
                ActionClass.creer();
            }
        });

        b_dupliquer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionClass.dupliquer();
            }
        });

        b_supprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionClass.supprimer();
            }
        });

        b_marquer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionClass.marquer();
            }
        });

        b_editer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionClass.editer();
            }
        });

    }

}
