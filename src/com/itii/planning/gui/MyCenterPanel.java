package com.itii.planning.gui;

import javax.swing.*;
import java.awt.*;

public class MyCenterPanel extends JPanel {
    private MyListPanel list;
    private MyMonthPanel months;
    private MyWeekPanel weeks;


    public MyCenterPanel(){

        list = new MyListPanel();
        months = new MyMonthPanel();
        weeks = new MyWeekPanel();


        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();



        gbc.gridx=0;
        gbc.gridy=0;

        gbc.weightx=4;
        gbc.weighty=3;
        gbc.fill=GridBagConstraints.BOTH;

        gbc.insets = new Insets(2,5,5,2);

        add(list,gbc);

        /*
        gbc.gridx=0;
        gbc.gridy=0;

        gbc.weightx=4;
        gbc.weighty=3;
        gbc.fill=GridBagConstraints.BOTH;

        gbc.insets = new Insets(2,5,5,2);

        add(new MyMonthPanel(),gbc);
        */

        gbc.gridx=4;
        gbc.weightx=0.5;
        gbc.weighty=2;
        gbc.fill=GridBagConstraints.EAST;

        add(new MyButtonPanel(),gbc);

    }

}
