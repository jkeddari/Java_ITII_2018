package com.itii.planning.gui;

import javax.swing.*;
import java.awt.*;

public class MyCenterPanel extends JPanel {

    public MyCenterPanel(){

        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();


        JPanel TaskPanel=new JPanel();
        JPanel panneauList=new JPanel();
        JPanel panneauMois=new JPanel();
        JPanel panneauSemaine=new JPanel();

        
        MyListPanel PanelList =new MyListPanel();
        panneauSemaine.setBackground(Color.RED);

        MyMonthPanel PanelMonth = new MyMonthPanel();
        panneauMois.setBackground(Color.BLUE);

        gbc.gridx=0;
        gbc.gridy=0;

        gbc.weightx=4;
        gbc.weighty=3;
        gbc.fill=GridBagConstraints.BOTH;

        gbc.insets = new Insets(2,5,5,2);

        add(new MyListPanel(),gbc);

        gbc.gridx=0;
        gbc.gridy=0;

        gbc.weightx=4;
        gbc.weighty=3;
        gbc.fill=GridBagConstraints.BOTH;

        gbc.insets = new Insets(2,5,5,2);

        add(new MyMonthPanel(),gbc);


        gbc.gridx=4;
        gbc.weightx=0.5;
        gbc.weighty=2;
        gbc.fill=GridBagConstraints.EAST;

        add(new MyButtonPanel(),gbc);

    }

}
