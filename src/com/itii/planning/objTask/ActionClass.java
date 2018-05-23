package com.itii.planning.objTask;

import com.itii.planning.gui.MainWindow.TasksPanel.MyListPanel;
import com.itii.planning.gui.MainWindow.TasksPanel.MyMonthPanel;
import com.itii.planning.gui.MainWindow.TasksPanel.MyWeekPanel;
import com.itii.planning.gui.newTaskDialog.TaskDialog;

public class ActionClass {


    public static void creer(){
        new TaskDialog();
    }

    public static void  supprimer(){
        MyListPanel.GetMyListPanel().suppRow();

    }

    public static void editer(){
        MyListPanel.GetMyListPanel().editRow();

    }

    public static void dupliquer(){
        MyListPanel.GetMyListPanel().cloneRow();
    }

    public static void marquer(){
        MyListPanel.GetMyListPanel().markRow();
    }


}
