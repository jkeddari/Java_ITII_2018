package com.itii.planning.gui.task;

import javax.swing.*;
import java.awt.*;

public class TaskDialogMainPanel extends JPanel {

    public TaskDialogMainPanel(JDialog taskdialog){
        //Ajout InputPanel
        add(new TaskDialogInputPanel(),BorderLayout.NORTH);
        //Ajout ButtonPanel
        add(new TaskDialogButtonPanel(taskdialog),BorderLayout.SOUTH);
    }
}
