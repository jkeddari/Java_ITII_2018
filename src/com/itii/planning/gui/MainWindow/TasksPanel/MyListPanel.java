package com.itii.planning.gui.MainWindow.TasksPanel;

import com.itii.planning.db.dbAccess;
import com.itii.planning.gui.alterTaskDialog.alterTaskDialog;
import com.itii.planning.objTask.TaskObject;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;



public class MyListPanel extends TaskPanel {
    private static MyListPanel m=null;

    private String list_header[] = {"Nom de la tâche", "Date dûe","Commentaire"};
    private DefaultTableModel tableModel = new DefaultTableModel(list_header, 0);

    private JTable table=new JTable(tableModel);/* {
        public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
            Color[] colors = {Color.LIGHT_GRAY, new Color(240, 240, 240), new Color(220, 220, 120)};
            Component c = super.prepareRenderer(renderer, row, col);

            //System.out.println(row);
            if (!isCellSelected(row, col) && TaskPanel.returnSate(row) == 1) {

                c.setForeground(Color.RED);
            }
            c.setForeground(Color.BLACK);

            return c;
        };
    };
    */


    private MyListPanel(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();



        table.setDefaultRenderer(Object.class, new MyTableCellRender());

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

        display(); //fill the table
    }

    public static MyListPanel GetMyListPanel(){
        if(m==null) m=new MyListPanel();
        return m;
    }


    protected void display() {

        for (Object[] o : list_tasks){

            ((DefaultTableModel) table.getModel()).addRow(o);
        }

    }

    public void pushTable(TaskObject o){
        dbAccess db = new dbAccess();
        TaskPanel.getListTasks().add(new Object[]{o.getName(),o.getDate(),o.getComment(), db.getTopID(),"0"});

        //((DefaultTableModel) table.getModel()).fireTableDataChanged();
        ((DefaultTableModel) table.getModel()).addRow(new Object[]{o.getName(),o.getDate(),o.getComment()});

        db.closeDb();
    }

    public void updateTable(TaskObject o){


        //TaskPanel.getListTasks().remove(table.getSelectedRow());
        System.out.println(o.getStatus());
        TaskPanel.getListTasks().set(table.getSelectedRow(),new Object[]{o.getName(),o.getDate(),o.getComment(), o.getId(),o.getStatus()});


        ((DefaultTableModel) table.getModel()).setValueAt(o.getName(),table.getSelectedRow(),0);
        ((DefaultTableModel) table.getModel()).setValueAt(o.getDate(),table.getSelectedRow(),1);
        ((DefaultTableModel) table.getModel()).setValueAt(o.getComment(),table.getSelectedRow(),2);
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
            Object[] obj = db.getObject(id);
            db.closeDb();

            String name = (String) obj[0];
            String date = (String) obj[1];
            String comment = (String) obj[2];

            TaskObject t = new TaskObject(name, date, comment);
            t.pushDB();
            pushTable(t);
        }
    }

    public void markRow(){
        if(table.getSelectedRow() != -1){
            int id = returnID(table.getSelectedRow());


            Object[] o = getValueAt(table.getSelectedRow());


            if(TaskPanel.returnSate(table.getSelectedRow())==0) {
                TaskObject.MarkTaskDB(id);
                o[4]="1";
            }
            else{
                TaskObject.unMarkTaskDB(id);
                o[4]="0";
            }

            TaskPanel.getListTasks().set(table.getSelectedRow(),o);
            tableModel.fireTableDataChanged();


        }
    }


}

