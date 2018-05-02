package com.itii.planning.gui;

import javax.swing.*;
import java.awt.*;

public class MyCenterPanel extends JPanel {
    private JPanel myCenterPanel;

    public MyCenterPanel(){
        myCenterPanel=new JPanel();
        myCenterPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();


        JPanel TaskPanel=new JPanel();
        JPanel panneauList=new JPanel();
        JPanel panneauMois=new JPanel();
        JPanel panneauSemaine=new JPanel();

        MyListPanel PanelList =new MyListPanel();
        panneauSemaine.setBackground(Color.RED);


        gbc.gridx=0;
        gbc.gridy=0;

        gbc.weightx=4;
        gbc.weighty=3;
        gbc.fill=GridBagConstraints.BOTH;

        gbc.insets = new Insets(2,5,5,2);

        myCenterPanel.add(PanelList.getMyListPanel(),gbc);



        MyButtonPanel myButtons=new MyButtonPanel();

        gbc.gridx=4;
        gbc.weightx=0.5;
        gbc.weighty=2;
        gbc.fill=GridBagConstraints.EAST;

        myCenterPanel.add(myButtons.getMyButton(),gbc);

    }

    public JPanel getMyCenterPanel(){
        return myCenterPanel;
    }
}
