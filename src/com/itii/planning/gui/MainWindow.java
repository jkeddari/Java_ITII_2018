package com.itii.planning.gui;

//* import tout y compris le Jframe
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{
    //Attributs
    private static MainWindow instance;

    private JPanel mainPanel;




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

        mainPanel.add(new MyTopMenu(),BorderLayout.NORTH);
        mainPanel.add(new MyCenterPanel());


        setJMenuBar(new MyMenuBar());
        setContentPane(mainPanel);
        this.validate();
        this.repaint();

    }


}


