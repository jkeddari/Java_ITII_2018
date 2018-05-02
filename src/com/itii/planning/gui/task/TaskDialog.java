package com.itii.planning.gui.task;

import org.jdatepicker.JDatePicker;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;


public class TaskDialog extends JDialog {
    //Boîte du message d'information
    private JOptionPane newTaskDialog;
    private JDatePicker calendar;

    public TaskDialog() {
        newTaskDialog = new JOptionPane();
        newTaskDialog.showMessageDialog(null, "Message informatif", "Information", JOptionPane.INFORMATION_MESSAGE);

    }
}