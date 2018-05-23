package com.itii.planning.gui.MainWindow.TasksPanel;

import com.itii.planning.db.dbAccess;
import com.itii.planning.objTask.TaskObject;
import javax.swing.*;
import java.util.ArrayList;

/* Abstract pour ne pas pouvoir créer un objet de type TaskPanel*/
public abstract class TaskPanel extends JPanel {

    protected static ArrayList<Object[]> list_tasks=new dbAccess().readDB();

    protected abstract void display();

    public void addValue(Object[] obj){
        list_tasks.add(obj);
    }

    public static ArrayList<Object[]> getListTasks(){
        return list_tasks;
    }

    public int returnID(int row){
        Object[] o = list_tasks.get(row);

        return Integer.parseInt((String)o[3]);
    }

    public static int returnSate(int row){
        Object[] o = list_tasks.get(row);

        return Integer.parseInt((String)o[4]);
    }

    public abstract void pushTable(TaskObject o);
    public abstract void updateTable(TaskObject o);
    public abstract void suppRow();
    public abstract void editRow();
    public abstract void cloneRow();
    public abstract void markRow();

}
