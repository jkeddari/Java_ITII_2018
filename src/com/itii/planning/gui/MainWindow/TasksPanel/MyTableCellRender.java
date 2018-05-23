package com.itii.planning.gui.MainWindow.TasksPanel;

import com.itii.planning.objTask.TaskObject;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class MyTableCellRender extends DefaultTableCellRenderer implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int rowIndex, int vColIndex) {

        setText((String)value);
        setToolTipText((String) value);

        if(isSelected) setBackground(Color.GRAY);

        else if(!isSelected && TaskPanel.returnSate(rowIndex)==1){
            setBackground(Color.yellow);
        }
        else{
            setBackground(Color.white);
        }

        return this;
    }

    /*
    public MyTableCellRender() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        int state = TaskPanel.returnSate(row);


        if(state == 1) {
            setForeground(Color.black);
            setBackground(Color.red);
        }
        else{
            setForeground(Color.black);
            setBackground(Color.white);
        }


        setText(value !=null ? value.toString() : "");

        return this;
    }
    */

} 