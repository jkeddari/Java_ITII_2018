package com.itii.planning.objTask;

import com.itii.planning.db.dbAccess;

public class TaskObject {
    private String id;
    private String name;
    private String date;
    private String comment;
    private String status="0";


    public String getName(){
        return name;
    }
    public String getDate(){
        return date;
    }
    public String getComment(){
        return comment;
    }
    public String getStatus(){
        return status;
    }
    public String getId(){
        return id;
    }

    public TaskObject(String name, String date, String comment){
        status="0";
        this.name=name;
        this.date=date;
        this.comment=comment;
    }

    public TaskObject(String name, DateObject date, String comment){
        status="0";
        this.name=name;
        this.date=date.getDate();
        this.comment=comment;
    }

    public TaskObject(String name, String date, String comment, String id, String status){
        this.name=name;
        this.date=date;
        this.comment=comment;
        this.id=id;
        this.status=status;
    }

    public TaskObject(String name, DateObject date, String comment, String id, String status){
        this.name=name;
        this.date=date.getDate();
        this.comment=comment;
        this.id=id;
        this.status=status;
    }

    public void pushDB(){
        dbAccess db= new dbAccess();
        db.writeDB(name,date,comment);
        db.closeDb();
    }

    public void updateTaskDB(int id){
        dbAccess db = new dbAccess();
        db.alterDB(name,date,comment,id);
        db.closeDb();
    }

    public static void MarkTaskDB(int id){
        dbAccess db = new dbAccess();
        db.MarkDB(id);
        db.closeDb();
    }
    public static void unMarkTaskDB(int id){
        dbAccess db = new dbAccess();
        db.unMarkDB(id);
        db.closeDb();
    }



}
