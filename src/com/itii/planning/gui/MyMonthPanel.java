package com.itii.planning.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.border.Border;

public class MyMonthPanel extends TaskPanel{
    private JPanel MonthPanel;

    public MyMonthPanel(){
        MonthPanel=new JPanel();
    }

    public JPanel getMyMonthPanel(){
        return MonthPanel;
    }

}
