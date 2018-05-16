package com.itii.planning.gui.task;

import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;

public class TaskDialogMainPanel extends JPanel {

    public TaskDialogMainPanel(JDialog taskdialog){
        add(new TaskDialogInputPanel(taskdialog)); //Ajout InputPanel
    }
}
