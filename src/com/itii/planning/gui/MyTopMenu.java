package com.itii.planning.gui;

import javax.swing.*;
import java.awt.*;




public class MyTopMenu extends JPanel {
    private JPanel myTopMenu;

    private enum VueList{
        //Objets directement construits
        List ("Liste"),
        Month("Mois"),
        Week("Semaine");


        private String name = "";

        //Constructeur
        VueList(String name){
            this.name = name;
        }

        public String toString(){
            return name;
        }
    }


    public MyTopMenu(){
        String[] VueList = { "Liste", "Semaine", "Mois"};
        JPanel myTopMenu=new JPanel();
        JComboBox choix_vue=new JComboBox(VueList);

        JLabel Lchoix_vue=new JLabel("Vue : ");

        myTopMenu.add(Lchoix_vue,BorderLayout.WEST);
        myTopMenu.add(choix_vue);
    }

    public JPanel getMyTopMenu(){
        return myTopMenu;
    }
}
