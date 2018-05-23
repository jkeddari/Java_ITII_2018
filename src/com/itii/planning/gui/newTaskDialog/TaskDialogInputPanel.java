package com.itii.planning.gui.newTaskDialog;


import com.itii.planning.gui.MainWindow.TasksPanel.MyListPanel;
import com.itii.planning.gui.alterTaskDialog.alterHourFilter;
import com.itii.planning.objTask.DateObject;
import com.itii.planning.objTask.TaskObject;
import org.jdatepicker.ComponentFormatDefaults;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TaskDialogInputPanel extends JPanel {

    /**********************************/
    // METHODE FORMAT QUI INTERDIT UN HORAIRE NON CONFORME //
    private JTextField _txtFilterHour;
    protected JTextField getTxtFilterHour () {
        if (_txtFilterHour == null) {
            _txtFilterHour = new JTextField();
            _txtFilterHour.setDocument(new alterHourFilter());
        }
        return _txtFilterHour;
    }
    /**********************************/

    public TaskDialogInputPanel(JDialog taskdialogue){

        setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();

        //Nom de tache
        grid.gridx=0;
        grid.gridy=0;
        grid.weightx=GridBagConstraints.LINE_START;
        grid.weighty=1;
        add(new JLabel("Nom de la tâche : "),grid);

        grid.gridx=1;
        grid.weightx=1;

        grid.ipady=GridBagConstraints.NONE;
        grid.fill=GridBagConstraints.HORIZONTAL;

        JTextField name = new JTextField();
        add(name,grid);



        //Date
        grid.gridx=0;
        grid.gridy=1;
        grid.weightx=0.2;
        grid.weighty=1;
        grid.fill=GridBagConstraints.NONE;
        add(new JLabel("Date : "),grid);

        grid.gridx=1;

        grid.fill=GridBagConstraints.HORIZONTAL;


        ComponentFormatDefaults defaults = ComponentFormatDefaults.getInstance();
        defaults.setFormat(ComponentFormatDefaults.Key.SELECTED_DATE_FIELD, new SimpleDateFormat("yyyy-MM-dd"));
        JDatePicker date = new JDatePicker(Calendar.getInstance());
        add(date,grid);

        /************ HORAIRE ANCIEN FORMAT ***************/
        //Heure ANCIEN FORMAT
        /*grid.gridx=0;
        grid.gridy=2;
        grid.weightx=0.2;
        grid.weighty=1;
        grid.fill=GridBagConstraints.NONE;
        add(new JLabel("Heure : "),grid);

        grid.gridx=1;

        grid.fill=GridBagConstraints.HORIZONTAL;
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        JFormattedTextField heure= new JFormattedTextField(hourFormat);


        add(heure,grid);*/

        //Minute ANCIEN FORMAT
        /*grid.gridx=0;
        grid.gridy=3;
        grid.weightx=0.2;
        grid.weighty=1;
        grid.fill=GridBagConstraints.NONE;
        add(new JLabel("Minute : "),grid);

        grid.gridx=1;

        grid.fill=GridBagConstraints.HORIZONTAL;
        JTextField minute= new JTextField();
        add(minute,grid);

        //Commentaire
        grid.gridx=0;
        grid.gridy=4;
        grid.insets = new Insets(0,0,0,5);
        grid.weightx=0.1;
        grid.weighty=5;
        grid.fill=GridBagConstraints.NONE;
        add(new JLabel("Commentaire : "),grid);

        grid.gridx=1;
        grid.fill=GridBagConstraints.HORIZONTAL;

        JTextField comment = new JTextField();
        add(comment,grid);*/
        /************ FIN HORAIRE ANCIEN FORMAT ***************/

        /**********************************/
        // FORMAT QUI INTERDIT UN HORRAIRE NON CONFORME //
        grid.gridx=0;
        grid.gridy=2;
        grid.weightx=0.2;
        grid.weighty=1;
        grid.fill=GridBagConstraints.NONE;
        add(new JLabel("Heure : "),grid);


        grid.gridx=1;
        grid.fill=GridBagConstraints.HORIZONTAL;
        _txtFilterHour = new JTextField();
        _txtFilterHour.setDocument(new alterHourFilter());
        add(getTxtFilterHour(),grid);

        /**********************************/

        //Commentaire
        grid.gridx=0;
        grid.gridy=4;
        grid.insets = new Insets(0,0,0,5);
        grid.weightx=0.1;
        grid.weighty=5;
        grid.fill=GridBagConstraints.NONE;
        add(new JLabel("Commentaire : "),grid);

        grid.gridx=1;
        grid.fill=GridBagConstraints.HORIZONTAL;

        JTextField comment = new JTextField();
        add(comment,grid);




        JButton b_valider = new JButton("Valider");
        JButton b_annuler = new JButton("Annuler");
        grid.gridx=0;
        grid.gridy=5;
        grid.weightx=1;
        grid.weighty=1;

        add(b_valider,grid);


        grid.gridx=1;
        add(b_annuler,grid);

        b_annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taskdialogue.dispose();
            }
        });


        b_valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!name.getText().equals("") && ! _txtFilterHour.getText().equals("") && ! _txtFilterHour.getText().equals("") && !comment.getText().equals("") && !date.getFormattedTextField().getText().equals("")){

                    DateObject d = new DateObject(date.getFormattedTextField().getText()+" "+ _txtFilterHour.getText()/*+":"+minute.getText()*/);
                    TaskObject newTask = new TaskObject(name.getText(),d.getDate(),comment.getText());
                    newTask.pushDB();
                    MyListPanel.GetMyListPanel().pushTable(newTask);

                }
                taskdialogue.dispose();
            }
        });






    }

}
