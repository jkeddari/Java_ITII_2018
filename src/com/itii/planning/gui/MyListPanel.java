package com.itii.planning.gui;

import com.itii.planning.db.dbAccess;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class MyListPanel extends TaskPanel {

    private JTable table;

    public MyListPanel(){

        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();

        //Titre des colonnes
        String title[] = {"Nom de la tâche", "Date dûe", "Détails"};
        DefaultTableModel tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);

       // ((DefaultTableModel) table.getModel()).addRow(new Object[]{"TP1#", "2018/04/20 : 12h00", "terminer le tp !"});
       // ((DefaultTableModel) table.getModel()).addRow(new Object[]{"TP2#", "2018/04/20 : 12h00", "terminer le tp !"});

        display(); /*remplit le tableau qui sera affiché plus tard */

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

    @Override
    protected void getData() {
        list_tasks = new ArrayList<Object[]>();
        dbAccess dbObj=new dbAccess();
        list_tasks=dbObj.readDb();
    }

    private void display(){
        getData();
            for (Object[] o : list_tasks) {

                    ((DefaultTableModel) table.getModel()).addRow(o);


                    System.out.println("Erreur d'affichage des taches");

            }


        ((DefaultTableModel) table.getModel()).addRow(new Object[]{"TP1#", "2018/04/20 : 12h00", "terminer le tp !"});
        ((DefaultTableModel) table.getModel()).addRow(new Object[]{"TP2#", "2018/04/20 : 12h00", "terminer le tp !"});
    }
}

