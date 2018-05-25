package com.itii.planning.gui.MainWindow;

import com.itii.planning.gui.InterfaceButton;
import com.itii.planning.gui.MainWindow.TasksPanel.MyListPanel;
import com.itii.planning.gui.MainWindow.TasksPanel.MyMonthPanel;
import com.itii.planning.gui.MainWindow.TasksPanel.MyWeekPanel;

import javax.swing.*;
import java.awt.*;


class MyCenterPanel extends JPanel implements InterfaceButton {


    MyCenterPanel(){

        MyMonthPanel.GetMyMonthPanel().setVisible(false);
        MyWeekPanel.GetMyWeekPanel().setVisible(false);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();


        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=4;
        gbc.weighty=3;
        gbc.fill=GridBagConstraints.BOTH;
        gbc.insets = new Insets(2,5,5,2);

        add(MyListPanel.GetMyListPanel(),gbc);
        add(MyMonthPanel.GetMyMonthPanel(),gbc);
        add(MyWeekPanel.GetMyWeekPanel(),gbc);


        gbc.gridx=4;
        gbc.weightx=0.5;
        gbc.weighty=2;
        gbc.fill=GridBagConstraints.EAST;

        add(new MyButtonPanel(),gbc);


        choix_vue.addActionListener(e -> {
            if(choix_vue.getSelectedIndex()==0){
                MyMonthPanel.GetMyMonthPanel().setVisible(false);
                MyWeekPanel.GetMyWeekPanel().setVisible(false);
                MyListPanel.GetMyListPanel().setVisible(true);
            }
            if(choix_vue.getSelectedIndex()==1){
                MyMonthPanel.GetMyMonthPanel().setVisible(false);
                MyWeekPanel.GetMyWeekPanel().setVisible(true);
                MyListPanel.GetMyListPanel().setVisible(false);
            }
            if(choix_vue.getSelectedIndex()==2){
                MyMonthPanel.GetMyMonthPanel().setVisible(true);
                MyWeekPanel.GetMyWeekPanel().setVisible(false);
                MyListPanel.GetMyListPanel().setVisible(false);
            }

        });


    }

}
