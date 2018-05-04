package com.itii.planning.gui.task;

import javax.swing.*;
import java.awt.*;

public class TaskDialogTimePanel extends JPanel {

    public TaskDialogTimePanel(){
        setLayout(new GridLayout(1,4));
        JLabel heure;
        JLabel minute;


        add(new JLabel("Heure : "));
        JTextField JT_hours = new JTextField();
        add(JT_hours);

        add(new JLabel("Minute : "));
        JTextField JT_minutes = new JTextField();
        add(JT_minutes);
    }
}
