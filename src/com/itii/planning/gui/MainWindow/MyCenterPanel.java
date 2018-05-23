package com.itii.planning.gui.MainWindow;

import com.itii.planning.gui.InterfaceButton;
import com.itii.planning.gui.InterfaceTaskPanel;
import com.itii.planning.gui.MainWindow.TasksPanel.MyListPanel;
import com.itii.planning.gui.MainWindow.TasksPanel.MyMonthPanel;
import com.itii.planning.gui.MainWindow.TasksPanel.MyWeekPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCenterPanel extends JPanel implements InterfaceButton, InterfaceTaskPanel {


    public MyCenterPanel(){



        months.setVisible(false);
        weeks.setVisible(false);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();


        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=4;
        gbc.weighty=3;
        gbc.fill=GridBagConstraints.BOTH;
        gbc.insets = new Insets(2,5,5,2);

        add(list,gbc);
        add(months,gbc);
        add(weeks,gbc);


        gbc.gridx=4;
        gbc.weightx=0.5;
        gbc.weighty=2;
        gbc.fill=GridBagConstraints.EAST;

        add(new MyButtonPanel(),gbc);


        choix_vue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(choix_vue.getSelectedIndex()==0){
                    months.setVisible(false);
                    weeks.setVisible(false);
                    list.setVisible(true);
                }
                if(choix_vue.getSelectedIndex()==1){
                    months.setVisible(false);
                    weeks.setVisible(true);
                    list.setVisible(false);
                }
                if(choix_vue.getSelectedIndex()==2){
                    months.setVisible(true);
                    weeks.setVisible(false);
                    list.setVisible(false);
                }

            }
        });


    }

}
