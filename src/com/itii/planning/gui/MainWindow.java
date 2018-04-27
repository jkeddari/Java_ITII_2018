package com.itii.planning.gui;

//* import tout y compris le Jframe
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{
    //Attributs
    private static MainWindow instance;

    private JPanel mainPanel;

    private JMenuBar menuBar; //Attribut// pour la création du Menu
    private JMenu fichier,edition,vue,aide;

    private JMenuItem quitter; //Item menu Fichier
    private JMenuItem creer, editer,marquer,dupliquer,supprimer; //Item menu Edition
    private JMenuItem liste,semaine,mois; //Item menu Vue


    private JComboBox choix_vue;

    private JPanel panneauList, panneauSemaine, panneauMois;
    private JPanel ButtonZone;

    private JButton b_creer,b_editer,b_marquer,b_dupliquer,b_supprimer;


    public static MainWindow getInstance(){
        if (instance==null){
            instance=new MainWindow();
        }
        return instance;
    }

    private MainWindow(){
        initialize();
    }

    private void initialize(){
        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Arret d'execution du programme lors de la fermeture de la fenêtre

        mainPanel=new JPanel(new BorderLayout());



        menuBar=new JMenuBar(); //Instance de la MenuBar

        fichier=new JMenu("Fichier");
        edition=new JMenu("Edition");
        vue=new JMenu("Vue");
        aide=new JMenu("Aide");


        quitter=new JMenuItem("quitter"); //MenuItem pour fichier


        /** MenuItem pour Edition */
        creer=new JMenuItem("Créer");
        editer=new JMenuItem("Editer");
        marquer=new JMenuItem("Marquer");
        dupliquer=new JMenuItem("Dupliquer");
        supprimer=new JMenuItem("Supprimer");

        /** MenuItem pour Vue */
        liste=new JMenuItem("Liste");
        semaine=new JMenuItem("Semaine");
        mois=new JMenuItem("Mois");
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


        menuBar.add(fichier);
        menuBar.add(edition);
        menuBar.add(vue);
        menuBar.add(aide);

        /*********************************/



        choix_vue=new JComboBox();
        panneauList=new JPanel();
        panneauMois=new JPanel();
        panneauSemaine=new JPanel();
        

        mainPanel.add(choix_vue);
        //mainPanel.add(panneauSemaine);
        //mainPanel.add(panneauMois);
        //mainPanel.add(panneauList)


        ButtonZone=new JPanel();

        b_creer=new JButton();
        b_dupliquer=new JButton();
        b_editer=new JButton();
        b_marquer=new JButton();
        b_supprimer=new JButton();

        ButtonZone.add(b_creer);
        ButtonZone.add(b_dupliquer);
        ButtonZone.add(b_editer);
        ButtonZone.add(b_marquer);
        ButtonZone.add(b_supprimer);

        setJMenuBar(menuBar);
        setContentPane(mainPanel);
        this.validate();
        this.repaint();
    }


}


