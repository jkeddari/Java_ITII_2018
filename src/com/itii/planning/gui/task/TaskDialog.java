package com.itii.planning.gui.task;

import com.itii.planning.gui.MainWindow;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;


public class TaskDialog extends JDialog {

    public TaskDialog() {

        setTitle("Nouvelle évenement");
        setSize(240,160);
        setVisible(true);

        JTextField JT_event_name = new JTextField();
        JLabel JL_event_name = new JLabel("Nom de la tâche : ");

        JPanel PaneTaskDialog = new JPanel();

        PaneTaskDialog.add(JL_event_name);
        PaneTaskDialog.add(JT_event_name,BorderLayout.EAST);

        setContentPane(PaneTaskDialog);
        this.validate();
        this.repaint();

    }
}