package com.itii.planning.objTask;

import com.itii.planning.db.dbAccess;

public class TaskObject {
    private String id;
    private String name;
    private String date;
    private String comment;
    private String status;


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

    public void setId(String id){
        this.id=id;
    }

    public TaskObject(String name, String date, String comment){
        status="0";
        this.name=name;
        this.date=date;
        this.comment=comment;
    }


    public TaskObject(String name, String date, String comment, String id, String status){
        this.name=name;
        this.date=date;
        this.comment=comment;
        this.id=id;
        this.status=status;
    }

    public void pushDB(){
        dbAccess db= new dbAccess();
        db.writeDB(name,date,comment,status);
        db.closeDb();
    }

    public Object[] getTaskObject(){
        return new Object[]{name,date,comment};
    }

    public void updateTaskDB(int id){
        dbAccess db = new dbAccess();
        db.alterDB(name,date,comment,id);
        db.closeDb();
    }

    public void MarkTaskDB(int id){
        dbAccess db = new dbAccess();
        db.MarkDB(id);
        db.closeDb();
        status="1";
    }
    public void unMarkTaskDB(int id){
        dbAccess db = new dbAccess();
        db.unMarkDB(id);
        db.closeDb();
        status="0";
    }



}
