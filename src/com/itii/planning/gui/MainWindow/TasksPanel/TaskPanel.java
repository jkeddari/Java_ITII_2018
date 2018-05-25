package com.itii.planning.gui.MainWindow.TasksPanel;

import com.itii.planning.db.dbAccess;
import com.itii.planning.objTask.TaskObject;
import javax.swing.*;
import java.util.ArrayList;

/* Abstract pour ne pas pouvoir créer un objet de type TaskPanel*/
public abstract class TaskPanel extends JPanel {

    static ArrayList<TaskObject> list_tasks=new dbAccess().readTaskDB();

    protected abstract void display();

    TaskObject getValueAt(int row){
        return list_tasks.get(row);
    }

    static ArrayList<TaskObject> getListTasks(){
        return list_tasks;
    }

    int returnID(int row){
        TaskObject task = list_tasks.get(row);
        return Integer.parseInt(task.getId());
    }

    static int returnSate(int row){
        TaskObject task = list_tasks.get(row);

        return Integer.parseInt(task.getStatus());
    }

    public abstract void pushTable(TaskObject o);
    public abstract void updateTable(TaskObject o);
    public abstract void suppRow();
    public abstract void editRow();
    public abstract void cloneRow();
    public abstract void markRow();

}
