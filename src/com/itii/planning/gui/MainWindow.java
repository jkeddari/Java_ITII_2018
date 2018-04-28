package com.itii.planning.gui;

//* import tout y compris le Jframe
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{
    //Attributs
    private static MainWindow instance;

    private JPanel mainPanel;


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

        MyMenuBar myBar = new MyMenuBar();
        MyTopMenu topMenu = new MyTopMenu();


        mainPanel.add(topMenu.getMyTopMenu(),BorderLayout.NORTH);


        JPanel TaskPanel=new JPanel();
        panneauList=new JPanel();
        panneauMois=new JPanel();
        panneauSemaine=new JPanel();

        panneauSemaine.setBackground(Color.RED);





        JPanel CenterPanel=new JPanel();

        CenterPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc=new GridBagConstraints();



        gbc.gridx=0;
        gbc.gridy=0;

        gbc.weightx=4;
        gbc.weighty=3;
        gbc.fill=GridBagConstraints.BOTH;



        CenterPanel.add(panneauSemaine,gbc);
        //mainPanel.add(panneauMois);
        //mainPanel.add(panneauList)



        ButtonZone=new JPanel();
        GridLayout ButtonGrid= new GridLayout(5,1);
        ButtonZone.setLayout(ButtonGrid);
        b_creer=new JButton("Créer");
        b_dupliquer=new JButton("Dupliquer");
        b_editer=new JButton("Editer");
        b_marquer=new JButton("Marquer");
        b_supprimer=new JButton("Supprimer");



        ButtonZone.add(b_creer);
        ButtonZone.add(b_dupliquer);
        ButtonZone.add(b_editer);
        ButtonZone.add(b_marquer);
        ButtonZone.add(b_supprimer);


        gbc.gridx=4;
        gbc.weightx=0.5;
        gbc.weighty=2;
        gbc.fill=GridBagConstraints.EAST;

        CenterPanel.add(ButtonZone,gbc);


        mainPanel.add(CenterPanel);


        setJMenuBar(myBar.getMyMenuBar());
        setContentPane(mainPanel);
        this.validate();
        this.repaint();

    }


}


