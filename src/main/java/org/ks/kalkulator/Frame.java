package org.ks.kalkulator;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame(){
        super("kalkulator");
        JPanel content = new JPanel();
        display = new Display();
        keyboard = new Keyboard();
        content.add(display);
        content.add(keyboard);
        setPreferredSize(new Dimension(150,450));
        setContentPane(content);
        pack();
    }
    private Display display;
    private Keyboard keyboard;
}
