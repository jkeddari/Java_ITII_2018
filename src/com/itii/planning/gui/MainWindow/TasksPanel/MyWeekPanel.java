package com.itii.planning.gui.MainWindow.TasksPanel;

import com.itii.planning.gui.MainWindow.TasksPanel.TaskPanel;
import com.itii.planning.objTask.TaskObject;

import java.awt.*;

public class MyWeekPanel extends TaskPanel {
    private static MyWeekPanel m = null;

    private MyWeekPanel(){
        setBackground(Color.LIGHT_GRAY);
        /* TODO */
    }

    public static MyWeekPanel GetMyWeekPanel(){
        if(m==null) m = new MyWeekPanel();
        return m;
    }



    protected void display() {
        /* TODO */
    }

    @Override
    public void pushTable(TaskObject o) {
        /* TODO */
    }

    @Override
    public void updateTable(TaskObject o) {
        /* TODO */
    }

    @Override
    public void suppRow() {
        /* TODO */
    }

    @Override
    public void editRow() {
        /* TODO */
    }

    @Override
    public void cloneRow() {
        /* TODO */
    }

    @Override
    public void markRow() {
        /* TODO */
    }
}
