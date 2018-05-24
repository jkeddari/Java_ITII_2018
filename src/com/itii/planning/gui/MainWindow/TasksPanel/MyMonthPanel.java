package com.itii.planning.gui.MainWindow.TasksPanel;

import com.itii.planning.gui.MainWindow.TasksPanel.TaskPanel;
import com.itii.planning.objTask.TaskObject;

import javax.swing.*;
import java.awt.*;

/*import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;*/


public class MyMonthPanel extends TaskPanel {
    private JTable table;
    private static MyMonthPanel m = null;

    private MyMonthPanel() {
        setBackground(Color.red);

        /* TODO
        * Faire un Layout BoxSizer, creer un nouveau panel qui representera les jours du mois en cours,
        * Créer un bon nombre des ces sous panel en fonction du nombre de jours dans le mois à l'aide d'un boucle
        * Ajouter ces sous panel dans le BoxSizer en tenant compte des decallage si le premier jour du mois n'est pas un lundi
        *
        * Les panel jours afficherons le noms des evenement correspondant à leur jours
        * */

    }

    public static MyMonthPanel GetMyMonthPanel(){
        if(m==null) m=new MyMonthPanel();
        return m;
    }

    protected void display() {
        /* TODO */
    }

    @Override
    public void pushTable(TaskObject o) {
        /* TODO */
    }

    @Override
    public void updateTable(TaskObject o) {
        /* TODO */
    }

    @Override
    public void suppRow() {
        /* TODO */
    }

    @Override
    public void editRow() {
        /* TODO */
    }

    @Override
    public void cloneRow() {
        /* TODO */
    }

    @Override
    public void markRow() {
        /* TODO */
    }

}
