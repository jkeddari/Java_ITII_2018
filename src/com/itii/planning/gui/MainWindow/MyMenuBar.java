package com.itii.planning.gui.MainWindow;

import com.itii.planning.gui.InterfaceButton;
import com.itii.planning.gui.MainWindow.TasksPanel.MyListPanel;
import com.itii.planning.gui.MainWindow.TasksPanel.MyMonthPanel;
import com.itii.planning.gui.MainWindow.TasksPanel.MyWeekPanel;
import com.itii.planning.gui.ActionClass;
import javax.swing.*;


class MyMenuBar extends JMenuBar implements InterfaceButton {


    MyMenuBar(){

        JMenu fichier=new JMenu("Fichier");
        JMenu edition=new JMenu("Edition");
        JMenu vue=new JMenu("Vue");
        JMenu aide=new JMenu("Aide");

        JMenuItem quitter=new JMenuItem("quitter"); //MenuItem pour fichier


        /* MenuItem pour Edition */
        JMenuItem creer=new JMenuItem("Créer");
        JMenuItem editer=new JMenuItem("Editer");
        JMenuItem marquer=new JMenuItem("Marquer");
        JMenuItem dupliquer=new JMenuItem("Dupliquer");
        JMenuItem supprimer=new JMenuItem("Supprimer");

        /* MenuItem pour Vue */
        JMenuItem liste=new JMenuItem("Liste");
        JMenuItem semaine=new JMenuItem("Semaine");
        JMenuItem mois=new JMenuItem("Mois");
        /* *****************************/

        fichier.add(quitter);

        edition.add(creer);
        edition.add(editer);
        edition.add(marquer);
        edition.add(dupliquer);
        edition.add(supprimer);

        vue.add(liste);
        vue.add(semaine);
        vue.add(mois);

        /* Ajout action sur bouttons **/
        quitter.addActionListener(e -> System.exit(0));

        creer.addActionListener(e -> ActionClass.creer());

        supprimer.addActionListener(e -> ActionClass.supprimer());

        dupliquer.addActionListener(e -> ActionClass.dupliquer());

        editer.addActionListener(e -> ActionClass.editer());

        marquer.addActionListener(e -> ActionClass.marquer());

        liste.addActionListener(e -> {
            MyMonthPanel.GetMyMonthPanel().setVisible(false);
            MyWeekPanel.GetMyWeekPanel().setVisible(false);
            MyListPanel.GetMyListPanel().setVisible(true);

            choix_vue.setSelectedIndex(0);

        });

        mois.addActionListener(e -> {
            MyMonthPanel.GetMyMonthPanel().setVisible(true);
            MyWeekPanel.GetMyWeekPanel().setVisible(false);
            MyListPanel.GetMyListPanel().setVisible(false);

            choix_vue.setSelectedIndex(2);
        });

        semaine.addActionListener(e -> {
            MyMonthPanel.GetMyMonthPanel().setVisible(false);
            MyWeekPanel.GetMyWeekPanel().setVisible(true);
            MyListPanel.GetMyListPanel().setVisible(false);

            choix_vue.setSelectedIndex(1);
        });


        /* Ajout des menu à la bar **/
        add(fichier);
        add(edition);
        add(vue);
        add(aide);
    }
}
