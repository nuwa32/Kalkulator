package org.ks.kalkulator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Keyboard extends JPanel {
    private List<JButton> buttons = new ArrayList<JButton>();
    public Keyboard() {
        super();
        setLayout(new GridLayout(3,3));
        for (int i = 1; i <= 9; i++) {
            JButton b = new JButton();
            b.setText(""+i);
            add(b);
            buttons.add(b);
        }
        setPreferredSize(new Dimension(100,300));
    }
}
