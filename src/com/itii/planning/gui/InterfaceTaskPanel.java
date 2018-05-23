package com.itii.planning.gui;

import com.itii.planning.gui.MainWindow.TasksPanel.MyListPanel;
import com.itii.planning.gui.MainWindow.TasksPanel.MyMonthPanel;
import com.itii.planning.gui.MainWindow.TasksPanel.MyWeekPanel;

public interface InterfaceTaskPanel {
    MyListPanel list = new MyListPanel();
    MyMonthPanel months = new MyMonthPanel();
    MyWeekPanel weeks = new MyWeekPanel();
}
