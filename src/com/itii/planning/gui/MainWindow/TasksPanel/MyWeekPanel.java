package com.itii.planning.gui.MainWindow.TasksPanel;

import com.itii.planning.gui.MainWindow.TasksPanel.TaskPanel;
import com.itii.planning.objTask.TaskObject;

import java.awt.*;

public class MyWeekPanel extends TaskPanel {
    private static MyWeekPanel m = null;

    private MyWeekPanel(){
        setBackground(Color.LIGHT_GRAY);
        /* TODO
        * Faire un JTable comme ListPanel mais avec 7 colonnes représentant les jours de la semaine en cours,
        * ajouter les Task dans la bonne colonne en fonction de leur date,
        * utiliser la Class DateObject dans le package objTask pour découper un date en forme de string et extraire le
        * jour,le mois et l'année
        * */
    }

    public static MyWeekPanel GetMyWeekPanel(){
        if(m==null) m = new MyWeekPanel();
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
