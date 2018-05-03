package com.itii.planning.gui;

import javax.swing.*;
import java.awt.*;

public class MyMainPanel extends JPanel {

    public MyMainPanel(){
        add(new MyTopMenu(),BorderLayout.NORTH);
        add(new MyCenterPanel());
    }
}
