package com.itii.planning.gui.MainWindow.TasksPanel;

import com.itii.planning.db.dbAccess;
import com.itii.planning.gui.alterTaskDialog.alterTaskDialog;
import com.itii.planning.objTask.TaskObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;



public class MyListPanel extends TaskPanel {

    private static MyListPanel m=null;
    private DefaultTableModel tableModel;
    private JTable table;


    private MyListPanel(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();

        String[] list_header = {"Nom de la tâche", "Date dûe", "Commentaire"};
        tableModel = new DefaultTableModel(list_header, 0){
            @Override
            public boolean isCellEditable(int row, int column) { //Class anonyme pour rendre les cellules non editables
                return false;
            }
        };
        table=new JTable(tableModel);

        table.setDefaultRenderer(Object.class, new MyListTableCellRender());


        table.setSelectionBackground(Color.GRAY);
        table.setFillsViewportHeight(true);
        table.setShowGrid(true);
        table.setGridColor(Color.LIGHT_GRAY);
        table.setAutoCreateRowSorter(true);
        JScrollPane j = new JScrollPane(table);
        j.createHorizontalScrollBar();
        j.createVerticalScrollBar();
        j.setBorder(null);

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weighty=1;
        gbc.weightx=1;

        gbc.fill=GridBagConstraints.BOTH;

        add(j,gbc);

        display();
    }

    public static MyListPanel GetMyListPanel(){
        if(m==null) m=new MyListPanel();
        return m;
    }


    protected void display() {
        for (TaskObject task : list_tasks){
            ((DefaultTableModel) table.getModel()).addRow(task.getTaskObject());
        }
    }

    public void pushTable(TaskObject task){
        dbAccess db = new dbAccess();

        TaskPanel.getListTasks().add(task);

        ((DefaultTableModel) table.getModel()).addRow(task.getTaskObject());

        db.closeDb();
    }

    public void updateTable(TaskObject task){
        TaskPanel.getListTasks().set(table.getSelectedRow(),task);

        tableModel.setValueAt(task.getName(),table.getSelectedRow(),0);
        tableModel.setValueAt(task.getDate(),table.getSelectedRow(),1);
        tableModel.setValueAt(task.getComment(),table.getSelectedRow(),2);
    }

    public void suppRow(){
        if(table.getSelectedRow() != -1) {
            int id = returnID(table.getSelectedRow());
            dbAccess db = new dbAccess();
            db.deleteRow(id);
            TaskPanel.getListTasks().remove(table.getSelectedRow());
            tableModel.removeRow(table.getSelectedRow());
            tableModel.fireTableDataChanged();
            db.closeDb();
        }
    }
    public void editRow(){
        if(table.getSelectedRow() != -1) {
            int id = returnID(table.getSelectedRow());
            int status = returnSate(table.getSelectedRow());
            new alterTaskDialog(id,status);
        }
    }
    public void cloneRow(){
        if(table.getSelectedRow() != -1) {
            int id = returnID(table.getSelectedRow());

            dbAccess db = new dbAccess();
            TaskObject task = db.getTask(id);
            db.closeDb();

            task.pushDB();
            pushTable(task);
        }
    }

    public void markRow(){
        if(table.getSelectedRow() != -1){
            int id = returnID(table.getSelectedRow());

            TaskObject task = getValueAt(table.getSelectedRow());

            if(TaskPanel.returnSate(table.getSelectedRow())==0) {
                task.MarkTaskDB(id);
            }
            else{
                task.unMarkTaskDB(id);
            }

            TaskPanel.getListTasks().set(table.getSelectedRow(),task);
            tableModel.fireTableDataChanged();
        }
    }
}

