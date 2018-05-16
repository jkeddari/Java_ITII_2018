package com.itii.planning.objTask;

import com.itii.planning.db.dbAccess;

public class TaskObject {
    private String name;
    private String date;
    private String comment;

    public TaskObject(String name, String date, String comment){
        this.name=name;
        this.date=date;
        this.comment=comment;
    }

    public void pushDB(){
        dbAccess db= new dbAccess();
        db.writeDB(name,date,comment);
        db.closeDb();
    }
}
