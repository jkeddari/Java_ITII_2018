package com.itii.planning.gui.MainWindow;

import com.itii.planning.db.dbAccess;
import com.itii.planning.gui.InterfaceTable;
import com.itii.planning.gui.InterfaceTaskPanel;
import com.itii.planning.gui.alterTaskDialog.alterTaskDialog;
import com.itii.planning.gui.newTaskDialog.TaskDialog;
import com.itii.planning.objTask.ActionClass;
import com.itii.planning.objTask.TaskObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenuBar extends JMenuBar implements InterfaceTable, InterfaceTaskPanel {


    public MyMenuBar(){

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

        /** Ajout action sur bouttons **/
        quitter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        creer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ActionClass.creer();
            }
        });

        supprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionClass.supprimer();
            }
        });

        dupliquer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionClass.dupliquer();
            }
        });

        editer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionClass.editer();
            }
        });

        liste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                months.setVisible(false);
                weeks.setVisible(false);
                list.setVisible(true);
            }
        });

        mois.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                months.setVisible(true);
                weeks.setVisible(false);
                list.setVisible(false);
            }
        });

        semaine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                months.setVisible(false);
                weeks.setVisible(true);
                list.setVisible(false);
            }
        });


        /** Ajout des menu à la bar **/
        add(fichier);
        add(edition);
        add(vue);
        add(aide);
    }
}
