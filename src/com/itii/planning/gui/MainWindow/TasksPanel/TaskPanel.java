package com.itii.planning.gui.MainWindow.TasksPanel;

import com.itii.planning.db.dbAccess;
import com.itii.planning.gui.InterfaceButton;
import com.itii.planning.gui.InterfaceTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Abstract pour ne pas pouvoir créer un objet de type TaskPanel*/
public abstract class TaskPanel extends JPanel implements InterfaceButton, InterfaceTable {

    /*Objet pour stocker les éléments de la base */

    public TaskPanel(){


        dbAccess dbObj=new dbAccess();


        b_supprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }






}
