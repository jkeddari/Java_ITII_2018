package com.itii.planning;

import com.itii.planning.gui.MainWindow;
import com.itii.planning.db.dbAccess;

public class Launcher{
    public static void main(String[] args){
        dbAccess db = new dbAccess();
        db.deleteRow(3);
        db.closeDb();

        MainWindow.getInstance();

    }
}
