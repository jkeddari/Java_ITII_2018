package com.itii.planning.gui;

import javax.swing.*;

public interface InterfaceButton {
    JButton b_supprimer = new JButton("Supprimer");
    JButton b_creer = new JButton("Créer");
    JButton b_dupliquer = new JButton("Dupliquer");
    JButton b_editer = new JButton("Editer");
    JButton b_marquer = new JButton("Marquer");

    String[] VueList = { "Liste", "Semaine", "Mois"};
    JComboBox choix_vue=new JComboBox(VueList);

}
