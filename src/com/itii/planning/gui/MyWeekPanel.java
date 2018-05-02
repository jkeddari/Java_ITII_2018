package com.itii.planning.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.border.Border;

public class MyWeekPanel extends TaskPanel {
    private JPanel WeekPanel;

    public MyWeekPanel(){
        WeekPanel=new JPanel();

    }

    public JPanel getMyWeekPanel(){
        return WeekPanel;
    }
}
