package com.itii.planning.gui;

import com.itii.planning.db.dbAccess;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class MyListPanel extends TaskPanel{

    private JTable table;

    public MyListPanel(){

        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();

        //Titre des colonnes
        String title[] = {"Nom de la tâche", "Date dûe", "Détails"};
        DefaultTableModel tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);


        display(); //fill the table

        table.setFillsViewportHeight(true);
        table.setShowGrid(true);
        table.setGridColor(Color.LIGHT_GRAY);
        table.setAutoCreateRowSorter(true);
        JScrollPane j = new JScrollPane(table);
        j.createHorizontalScrollBar();
        j.createVerticalScrollBar();
        j.setBorder(null);

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weighty=1;
        gbc.weightx=1;

        gbc.fill=GridBagConstraints.BOTH;

        Border line = BorderFactory.createLineBorder(Color.LIGHT_GRAY,2);

        add(j,gbc);


    }


    protected void display() {

        for (Object[] o : getArrayData()) ((DefaultTableModel) table.getModel()).addRow(o);
    }

}

