package com.itii.planning.gui.task;

import javax.swing.*;
import java.awt.*;

public class TaskDialogDatePanel extends JPanel {


    public TaskDialogDatePanel(JDialog taskdialogue) {

        //GridLayout DateGrid1 = new GridLayout(4, 1);
        GridBagConstraints DateGrid = new GridBagConstraints();
        //Heure:min
        /*HEURE*/
        DateGrid.gridx = 0;
        DateGrid.gridy = 2;
        DateGrid.weightx = 0.2;
        DateGrid.weighty = 1;
        DateGrid.fill = GridBagConstraints.NONE;
        add(new JLabel("Heure : "), DateGrid);
        DateGrid.gridx = 1;
        DateGrid.weightx = 0.3;
        DateGrid.fill = GridBagConstraints.HORIZONTAL;
        JTextField JT_event_hours = new JTextField();
        add(JT_event_hours, DateGrid);



        /*Min*/
        DateGrid.gridx = 2;
        DateGrid.gridy = 2;
        DateGrid.weightx = 0.2;
        DateGrid.weighty = 1;
        DateGrid.fill = GridBagConstraints.NONE;
        add(new JLabel("Min : "), DateGrid);
        DateGrid.gridx = 3;
        DateGrid.weightx = 0.3;
        DateGrid.fill = GridBagConstraints.HORIZONTAL;
        JTextField JT_event_minutes = new JTextField();
        add(JT_event_minutes, DateGrid);
    }
}
