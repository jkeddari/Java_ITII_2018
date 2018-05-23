package com.itii.planning.objTask;

import com.itii.planning.db.dbAccess;
import com.itii.planning.gui.InterfaceTable;
import com.itii.planning.gui.alterTaskDialog.alterTaskDialog;
import com.itii.planning.gui.newTaskDialog.TaskDialog;

public class ActionClass implements InterfaceTable {


    public static void creer(){
        new TaskDialog();
    }

    public static void  supprimer(){
        if(table.getSelectedRow() != -1) {
            int row = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 3));

            dbAccess db = new dbAccess();
            db.deleteRow(row);
            list_tasks.remove(table.getSelectedRow());
            tableModel.removeRow(table.getSelectedRow());
            tableModel.fireTableDataChanged();
            db.closeDb();
        }
    }

    public static void editer(){
        if(table.getSelectedRow() != -1) {
            int id = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 3));
            new alterTaskDialog(id);
        }
    }

    public static void dupliquer(){
        if(table.getSelectedRow() != -1) {
            int id = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 3));

            dbAccess db = new dbAccess();
            Object[] obj = db.getObject(id);
            db.closeDb();

            String name = (String) obj[0];
            String date = (String) obj[1];
            String comment = (String) obj[2];

            TaskObject t = new TaskObject(name, date, comment);
            t.pushDB();
            t.pushTable();
        }
    }

    public static void marquer(){
        if(table.getSelectedRow() != -1){



        }
    }


}
