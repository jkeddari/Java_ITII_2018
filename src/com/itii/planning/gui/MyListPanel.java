package com.itii.planning.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.border.Border;


public class MyListPanel extends TaskPanel {


    public MyListPanel(){

        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();

        //Titre des colonnes
        String title[] = {"Nom de la tâche", "Date dûe", "Détails"};
        DefaultTableModel tableModel = new DefaultTableModel(title, 0);
        JTable table = new JTable(tableModel);

        ((DefaultTableModel) table.getModel()).addRow(new Object[]{"TP1#", "2018/04/20 : 12h00", "terminer le tp !"});
        ((DefaultTableModel) table.getModel()).addRow(new Object[]{"TP2#", "2018/04/20 : 12h00", "terminer le tp !"});
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
}

