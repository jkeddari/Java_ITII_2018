package com.itii.planning.gui.task;

import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;


public class TaskDialog extends JDialog {

    public TaskDialog() {

        //setLayout(new GridBagLayout());


        setTitle("Nouvelle évenement");
        setSize(420,180);
        setVisible(true);

        JPanel PaneTaskDialog = new JPanel();
        GridBagConstraints grid = new GridBagConstraints();

        JTextField JT_event_name = new JTextField();
        JDatePicker date= new JDatePicker();
        JTextArea JT_event_comment = new JTextArea(3,1);


        JButton b_valider = new JButton("Valider");
        JButton b_annuler = new JButton("Annuler");
        GridLayout ButtonGrid = new GridLayout(2, 1);
        //PaneTaskDialog.add(b_valider,BorderLayout.EAST);
        //PaneTaskDialog.add(b_annuler,BorderLayout.WEST);

        JPanel TaskDialogInputPanel=new JPanel();
        TaskDialogInputPanel.add(JT_event_name);
        TaskDialogInputPanel.add(date);
        TaskDialogInputPanel.add(JT_event_name);


/********** Debut affichage "Commentaire" ******/
        TaskDialogInputPanel.setLayout(new GridBagLayout());

        grid.gridx=0;
        grid.gridy=0;

        grid.weightx=0.1;
        grid.weighty=1;
        //grid.fill=GridBagConstraints.EAST;

        TaskDialogInputPanel.add(new JLabel("Nom de la tâche : "),grid);

        grid.gridx=1;
        grid.weightx=1;
        grid.fill=GridBagConstraints.HORIZONTAL;
        TaskDialogInputPanel.add(JT_event_name,grid);

/********** Fin affichage "Nom de la tache" ******/

/********** Debut affichage "Date" ******/
        grid.gridx=0;
        grid.gridy=1;
        grid.weightx=0.2;
        grid.weighty=1;

        grid.fill=GridBagConstraints.NONE;
        TaskDialogInputPanel.add(new JLabel("Date : "),grid);

        grid.gridx=1;
        grid.gridy=1;
        grid.fill=GridBagConstraints.HORIZONTAL;
        TaskDialogInputPanel.add(date,grid);


/********** Fin affichage "Date" ******/

/********** Debut affichage "Commentaire" ******/
        grid.gridx=0;
        grid.gridy=2;
        grid.insets = new Insets(0,0,0,5);
        grid.weightx=0.1;
        grid.weighty=5;
        grid.fill=GridBagConstraints.NONE;
        TaskDialogInputPanel.add(new JLabel("Commentaire : "),grid);

        grid.gridx=1;
        grid.gridy=2;
        grid.fill=GridBagConstraints.HORIZONTAL;
        TaskDialogInputPanel.add(JT_event_comment,grid);

/********** Fin affichage "Commentaire" ******/

        PaneTaskDialog.add(TaskDialogInputPanel,BorderLayout.NORTH);

/******* Ajout des boutons avec un Panel ****/

        JPanel TaskDialogButtonPanel = new JPanel();
        TaskDialogButtonPanel.add(b_valider);
        TaskDialogButtonPanel.add(b_annuler);

        PaneTaskDialog.add(TaskDialogButtonPanel,BorderLayout.SOUTH);


        /* Ajout des boutons sans Panel */
     /*   grid.gridx=0;
        grid.gridy=3;
        grid.weightx=0.1;
        grid.weighty=1;
        grid.fill=GridBagConstraints.NONE;
        PaneTaskDialog.add(b_valider,grid);

        grid.gridx=1;
        grid.gridy=3;
        grid.fill=GridBagConstraints.HORIZONTAL;
        PaneTaskDialog.add(b_annuler,grid);

*/



        setContentPane(PaneTaskDialog);
        this.validate();
        this.repaint();

    }

}