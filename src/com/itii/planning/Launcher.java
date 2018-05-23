package com.itii.planning;

import com.itii.planning.gui.MainWindow.MainWindow;
import com.itii.planning.objTask.DateObject;

public class Launcher{
    public static void main(String[] args){
        //dbAccess db = new dbAccess();

        //db.closeDb();
        //DateObject d=new DateObject("2017-12-01 23:30");
        //System.out.println(d.getDate());
        MainWindow.getInstance();

    }
}
