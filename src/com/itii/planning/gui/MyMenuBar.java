package com.itii.planning.gui;

import javax.swing.*;

public class MyMenuBar extends JMenuBar {

    private JMenuBar myBar;

    public MyMenuBar(){
        myBar=new JMenuBar();

        JMenu fichier=new JMenu("Fichier");
        JMenu edition=new JMenu("Edition");
        JMenu vue=new JMenu("Vue");
        JMenu aide=new JMenu("Aide");

        JMenuItem quitter=new JMenuItem("quitter"); //MenuItem pour fichier


        /** MenuItem pour Edition */
        JMenuItem creer=new JMenuItem("Créer");
        JMenuItem editer=new JMenuItem("Editer");
        JMenuItem marquer=new JMenuItem("Marquer");
        JMenuItem dupliquer=new JMenuItem("Dupliquer");
        JMenuItem supprimer=new JMenuItem("Supprimer");

        /** MenuItem pour Vue */
        JMenuItem liste=new JMenuItem("Liste");
        JMenuItem semaine=new JMenuItem("Semaine");
        JMenuItem mois=new JMenuItem("Mois");
        /*********************************/

        fichier.add(quitter);

        edition.add(creer);
        edition.add(editer);
        edition.add(marquer);
        edition.add(dupliquer);
        edition.add(supprimer);

        vue.add(liste);
        vue.add(semaine);
        vue.add(mois);


        myBar.add(fichier);
        myBar.add(edition);
        myBar.add(vue);
        myBar.add(aide);
    }

    public JMenuBar getMyMenuBar(){
        return myBar;
    }
}
