package com.itii.planning.gui;

import com.itii.planning.db.dbAccess;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/* Abstract pour ne pas pouvoir créer un objet de type TaskPanel*/
public class TaskPanel extends JPanel implements InterfaceButton {

    private ArrayList<Object[]> list_tasks; /*Objet pour stocker les éléments de la base */

    public TaskPanel(){

        list_tasks = new ArrayList<Object[]>();
        dbAccess dbObj=new dbAccess();
        list_tasks=dbObj.readDB();

        b_supprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    public ArrayList<Object[]> getArrayData(){
        return list_tasks;
    }




}
