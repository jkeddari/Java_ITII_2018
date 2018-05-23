package com.itii.planning.gui.alterTaskDialog;

import com.itii.planning.db.dbAccess;
import com.itii.planning.gui.MainWindow.TasksPanel.MyListPanel;
import com.itii.planning.gui.MainWindow.TasksPanel.MyMonthPanel;
import com.itii.planning.gui.MainWindow.TasksPanel.MyWeekPanel;
import com.itii.planning.objTask.DateObject;
import com.itii.planning.objTask.TaskObject;
import com.itii.planning.objTask.alterHourFilter;
import org.jdatepicker.ComponentFormatDefaults;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class alterTaskDialogInputPanel extends JPanel {

    /**********************************/
    // METHODE FORMAT QUI INTERDIT UN HORAIRE NON CONFORME //
    private JTextField _txtFilterHour;
    protected JTextField getTxtFilterHour(){
        if (_txtFilterHour == null) {
            _txtFilterHour = new JTextField();
            _txtFilterHour.setDocument(new alterHourFilter());
            _txtFilterHour.setBorder(BorderFactory.createLineBorder(Color.black));
        }
        return _txtFilterHour;
    }

    /**********************************/


    public alterTaskDialogInputPanel(JDialog atask, int id){

        setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();




        dbAccess db=new dbAccess();
        Object[] o = db.getObject(id);
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
        name.setText((String)o[0]);
        add(name,grid);



        /************ D A T E **********/
        DateObject oldDate= new DateObject((String)o[1]);

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

        /*****************HORAIRE*****************/
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
        //Heure  ANCIEN FORMAT
        /*grid.gridx=0;
        grid.gridy=2;
        grid.weightx=0.2;
        grid.weighty=1;
        grid.fill=GridBagConstraints.NONE;
        add(new JLabel("Heure : "),grid);

        grid.gridx=1;

        grid.fill=GridBagConstraints.HORIZONTAL;
        JTextField heure= new JTextField();
        heure.setText(oldDate.getHours());
        add(heure,grid);*/

        //Minute -- ANCIEN FORMAT

        /*grid.gridx=0;
        grid.gridy=3;
        grid.weightx=0.2;
        grid.weighty=1;
        grid.fill=GridBagConstraints.NONE;
        add(new JLabel("Minute : "),grid);

        grid.gridx=1;

        grid.fill=GridBagConstraints.HORIZONTAL;
        JTextField minute= new JTextField();
        minute.setText(oldDate.getMinute());
        add(minute,grid);*/

        /****************************************/

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
        comment.setText((String) o[2]);
        add(comment,grid);




        JButton b_valider = new JButton("Valider");
        JButton b_annuler = new JButton("Annuler");


        grid.gridx=0;
        grid.gridy=5;
        //grid.insets=null;
        grid.weightx=1;
        grid.weighty=1;

        add(b_valider,grid);


        grid.gridx=1;
        add(b_annuler,grid);

        b_annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atask.dispose();
            }
        });


        b_valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!name.getText().equals("") && !_txtFilterHour.getText().equals("") && !_txtFilterHour.getText().equals("") && !comment.getText().equals("") && !date.getFormattedTextField().getText().equals("")){
                    DateObject d = new DateObject(date.getFormattedTextField().getText()+" "+_txtFilterHour.getText()/*+":"+minute.getText()*/);
                    TaskObject newTask = new TaskObject(name.getText(),d.getDate(),comment.getText());
                    newTask.updateTaskDB(id);

                    MyListPanel.GetMyListPanel().updateTable(newTask);
                    MyMonthPanel.GetMyMonthPanel().updateTable(newTask);
                    MyWeekPanel.GetMyWeekPanel().updateTable(newTask);
                }
                atask.dispose();
            }
        });
    }
}
