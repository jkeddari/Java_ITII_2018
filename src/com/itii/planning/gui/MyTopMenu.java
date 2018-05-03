package com.itii.planning.gui;

import javax.swing.*;
import java.awt.*;




public class MyTopMenu extends JPanel {

    public MyTopMenu(){
        String[] VueList = { "Liste", "Semaine", "Mois"};

        JComboBox choix_vue=new JComboBox(VueList);
        JLabel Lchoix_vue=new JLabel("Vue : ");

        add(Lchoix_vue,BorderLayout.WEST);
        add(choix_vue,BorderLayout.EAST);
    }

}
