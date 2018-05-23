package com.itii.planning.gui;

import com.itii.planning.db.dbAccess;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public interface InterfaceTable {
    ArrayList<Object[]> list_tasks=new dbAccess().readDB();
    String title[] = {"Nom de la tâche", "Date dûe", "Détails", "ID","State"};
    DefaultTableModel tableModel = new DefaultTableModel(title, 0);
    JTable table=new JTable(tableModel);

}
