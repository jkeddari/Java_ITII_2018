package com.itii.planning.gui.MainWindow;

import javax.swing.*;
import java.awt.*;

public class MyMainPanel extends JPanel {

    public MyMainPanel(){
        setLayout(new BorderLayout());
        add(new MyTopMenu(),BorderLayout.NORTH);
        add(new MyCenterPanel());
    }
}
