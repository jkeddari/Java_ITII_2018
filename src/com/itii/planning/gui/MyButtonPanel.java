package com.itii.planning.gui;

import javax.swing.*;
import java.awt.*;

public class MyButtonPanel extends JPanel {

    private JPanel ButtonZone;

    public MyButtonPanel() {
        ButtonZone = new JPanel();
        GridLayout ButtonGrid = new GridLayout(5, 1);
        ButtonZone.setLayout(ButtonGrid);
        JButton b_creer = new JButton("Créer");
        JButton b_dupliquer = new JButton("Dupliquer");
        JButton b_editer = new JButton("Editer");
        JButton b_marquer = new JButton("Marquer");
        JButton b_supprimer = new JButton("Supprimer");

        ButtonZone.add(b_creer);
        ButtonZone.add(b_dupliquer);
        ButtonZone.add(b_editer);
        ButtonZone.add(b_marquer);
        ButtonZone.add(b_supprimer);

    }

    public JPanel getMyButton(){
        return ButtonZone;
    }
}
