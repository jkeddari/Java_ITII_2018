package com.itii.planning.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MyPanneauList extends JPanel {

    private JPanel PanneauList;
    public MyPanneauList(){
        PanneauList=new JPanel();

        PanneauList.setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();

        Object[][] data = {
                {"TP1#", "2018/04/20 : 12h00", "terminer le tp !"}
        };

        //Titre des colonnes
        String title[] = {"Nom de la tache", "Date due", "Details"};
        DefaultTableModel tableModel = new DefaultTableModel(title, 3);
        JTable table = new JTable(tableModel);

        ((DefaultTableModel) table.getModel()).addRow(data);
        table.setFillsViewportHeight(true);
        JScrollPane j = new JScrollPane(table);



        PanneauList.add(j,BorderLayout.CENTER);








    }
    public JPanel getMyPanneauList(){
        return PanneauList;
    }

}

