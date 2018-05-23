package com.itii.planning.gui.MainWindow.TasksPanel;

import com.itii.planning.gui.MainWindow.TasksPanel.TaskPanel;
import com.itii.planning.objTask.TaskObject;

import javax.swing.*;
import java.awt.*;

/*import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;*/


public class MyMonthPanel extends TaskPanel {
    private JTable table;
    private static MyMonthPanel m = null;

    private MyMonthPanel() {
        setBackground(Color.red);

        /* TODO */

    }

    public static MyMonthPanel GetMyMonthPanel(){
        if(m==null) m=new MyMonthPanel();
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
