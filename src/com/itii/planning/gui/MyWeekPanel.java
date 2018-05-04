package com.itii.planning.gui;

import javax.swing.*;

public class MyWeekPanel extends TaskPanel {
    private JPanel WeekPanel;

    public MyWeekPanel(){
        WeekPanel=new JPanel();

    }

    @Override
    public void getData() {

    }

    public JPanel getMyWeekPanel(){
        return WeekPanel;
    }
}
