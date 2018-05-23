package com.itii.planning.gui.MainWindow;

import com.itii.planning.gui.InterfaceButton;

import javax.swing.*;
import java.awt.*;




public class MyTopMenu extends JPanel implements InterfaceButton {

    public MyTopMenu(){

        JLabel Lchoix_vue=new JLabel("Vue : ");

        add(Lchoix_vue,BorderLayout.WEST);
        add(choix_vue,BorderLayout.EAST);

    }

}
