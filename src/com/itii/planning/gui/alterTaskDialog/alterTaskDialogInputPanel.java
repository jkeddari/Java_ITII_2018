package com.itii.planning.gui.alterTaskDialog;

import com.itii.planning.db.dbAccess;
import com.itii.planning.gui.MainWindow.TasksPanel.MyListPanel;
import com.itii.planning.gui.MainWindow.TasksPanel.MyMonthPanel;
import com.itii.planning.gui.MainWindow.TasksPanel.MyWeekPanel;
import com.itii.planning.objTask.DateObject;
import com.itii.planning.objTask.TaskObject;
import com.itii.planning.HourFilter.alterHourFilter;
import org.jdatepicker.ComponentFormatDefaults;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

class alterTaskDialogInputPanel extends JPanel {

    /**********************************/
    // METHODE FORMAT QUI INTERDIT UN HORAIRE NON CONFORME //
    private JTextField _txtFilterHour;

    private JTextField getTxtFilterHour(){
        if (_txtFilterHour == null) {
            _txtFilterHour = new JTextField();
            _txtFilterHour.setDocument(new alterHourFilter());
            _txtFilterHour.setBorder(BorderFactory.createLineBorder(Color.black));
        }
        return _txtFilterHour;
    }

    /**********************************/


    alterTaskDialogInputPanel(JDialog atask, int id, int status){

        setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();




        dbAccess db=new dbAccess();
        TaskObject task = db.getTask(id);
        db.closeDb();

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
        name.setText(task.getName());
        add(name,grid);



        /* *********** D A T E **********/
        DateObject oldDate= new DateObject(task.getDate());

        grid.gridx=0; grid.gridy=1;
        grid.weightx=0.2; grid.weighty=1;
        grid.fill=GridBagConstraints.NONE;

        add(new JLabel("Date : "),grid);



        grid.gridx=1;
        grid.fill=GridBagConstraints.HORIZONTAL;

        ComponentFormatDefaults defaults = ComponentFormatDefaults.getInstance();
        defaults.setFormat(ComponentFormatDefaults.Key.SELECTED_DATE_FIELD, new SimpleDateFormat("yyyy-MM-dd"));
        JDatePicker date = new JDatePicker(Calendar.getInstance());
        date.getFormattedTextField().setText(oldDate.getYear()+"-"+oldDate.getMonth()+"-"+oldDate.getDay());
        add(date,grid);

        /* ****************HORAIRE*****************/
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
        _txtFilterHour.setText(new DateObject(task.getDate()).getTime());
        add(getTxtFilterHour(),grid);


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
        comment.setText(task.getComment());
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

        b_annuler.addActionListener(e -> atask.dispose());


        b_valider.addActionListener(e -> {
            if(!name.getText().equals("") && !_txtFilterHour.getText().equals("") && !date.getFormattedTextField().getText().equals("")){

                DateObject d = new DateObject(date.getFormattedTextField().getText()+" "+_txtFilterHour.getText()/*+":"+minute.getText()*/);
                TaskObject newTask = new TaskObject(name.getText(),d.getDate(),comment.getText(),Integer.toString(id),Integer.toString(status));
                newTask.updateTaskDB(id);

                MyListPanel.GetMyListPanel().updateTable(newTask);
                MyMonthPanel.GetMyMonthPanel().updateTable(newTask);
                MyWeekPanel.GetMyWeekPanel().updateTable(newTask);

                atask.dispose();
            }
        });
    }
}
