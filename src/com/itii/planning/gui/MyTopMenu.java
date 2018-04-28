package com.itii.planning.gui;

import javax.swing.*;
import java.awt.*;




public class MyTopMenu extends JPanel {
    private JPanel myTopMenu;


    public MyTopMenu(){
        String[] VueList = { "Liste", "Semaine", "Mois"};

        myTopMenu=new JPanel();

        JComboBox choix_vue=new JComboBox(VueList);
        JLabel Lchoix_vue=new JLabel("Vue : ");

        myTopMenu.add(Lchoix_vue,BorderLayout.WEST);
        myTopMenu.add(choix_vue,BorderLayout.EAST);
    }

    public JPanel getMyTopMenu(){
        return myTopMenu;
    }
}
