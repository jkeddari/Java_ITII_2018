package com.itii.planning.gui.MainWindow.TasksPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;



public class MyListPanel extends TaskPanel {


    public MyListPanel(){

        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();

        //Titre des colonnes


        table.getColumnModel().getColumn(3).setMaxWidth(0);
        table.getColumnModel().getColumn(3).setMinWidth(0);
        table.getColumnModel().getColumn(3).setPreferredWidth(0);

        table.getColumnModel().getColumn(4).setMaxWidth(0);
        table.getColumnModel().getColumn(4).setMinWidth(0);
        table.getColumnModel().getColumn(4).setPreferredWidth(0);




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

        for (Object[] o : list_tasks) ((DefaultTableModel) table.getModel()).addRow(o);


    }

}

