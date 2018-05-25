package com.itii.planning.gui;

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
        MyMonthPanel.GetMyMonthPanel().suppRow();
        MyWeekPanel.GetMyWeekPanel().suppRow();
    }
    public static void editer(){
        MyListPanel.GetMyListPanel().editRow();
        MyMonthPanel.GetMyMonthPanel().editRow();
        MyWeekPanel.GetMyWeekPanel().editRow();
    }
    public static void dupliquer(){
        MyListPanel.GetMyListPanel().cloneRow();
        MyMonthPanel.GetMyMonthPanel().cloneRow();
        MyWeekPanel.GetMyWeekPanel().cloneRow();
    }
    public static void marquer(){
        MyListPanel.GetMyListPanel().markRow();
        MyWeekPanel.GetMyWeekPanel().markRow();
        MyMonthPanel.GetMyMonthPanel().markRow();
    }


}
