package com.itii.planning.objTask;

import com.itii.planning.db.dbAccess;
import com.itii.planning.gui.InterfaceTable;

import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class TaskObject implements InterfaceTable {
    private String id;
    private String name;
    private String date;
    private String comment;
    private String status;

    public TaskObject(String name, String date, String comment){
        this.name=name;
        this.date=date;
        this.comment=comment;
    }

    public TaskObject(String name, DateObject date, String comment){
        this.name=name;
        this.date=date.getDate();
        this.comment=comment;
    }

    public TaskObject(String name, String date, String comment, String id, String status){
        this.name=name;
        this.date=date;
        this.comment=comment;
        this.id=id;
    }

    public TaskObject(String name, DateObject date, String comment, String id, String status){
        this.name=name;
        this.date=date.getDate();
        this.comment=comment;
        this.status=status;
    }

    public void pushDB(){
        dbAccess db= new dbAccess();
        db.writeDB(name,date,comment);
        db.closeDb();
    }

    public void alterTaskDB(int id){
        dbAccess db = new dbAccess();
        db.alterDB(name,date,comment,id);
    }

    public void pushTable(){
        dbAccess db = new dbAccess();
        list_tasks.add(new Object[]{name,date,comment, db.getTopID(),0});
        ((DefaultTableModel) table.getModel()).addRow(new Object[]{name,date,comment,db.getTopID(),0});
        db.closeDb();
    }

    public void alterTaskTable(){
        list_tasks.set(table.getSelectedRow(),new Object[]{name,date,comment, id,0});
        ((DefaultTableModel) table.getModel()).setValueAt(name,table.getSelectedRow(),0);
        ((DefaultTableModel) table.getModel()).setValueAt(date,table.getSelectedRow(),1);
        ((DefaultTableModel) table.getModel()).setValueAt(comment,table.getSelectedRow(),2);
    }




}
