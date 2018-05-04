package com.itii.planning.gui;

import javax.swing.*;
import java.util.ArrayList;

/* Abstract pour ne pas pouvoir créer un objet de type TaskPanel*/
public abstract class TaskPanel extends JPanel {

    /*Objet pour stocker les éléments de la base */
    protected ArrayList<Object[]> list_tasks;

    protected abstract void getData();

}
