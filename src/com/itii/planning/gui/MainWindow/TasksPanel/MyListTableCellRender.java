package com.itii.planning.gui.MainWindow.TasksPanel;


import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class MyListTableCellRender extends DefaultTableCellRenderer implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int rowIndex, int vColIndex) {

        setText((String)value);
        setToolTipText((String) value);



        if(isSelected) setBackground(Color.GRAY);

        else {
            if(TaskPanel.returnSate(rowIndex)==1){
                setBackground(Color.yellow);
            }
            else setBackground(Color.white);
        }

        return this;
    }

} 