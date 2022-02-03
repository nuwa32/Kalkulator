package org.ks.kalkulator;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {
    private JLabel label;
    public Display() {
        super();
        label = new JLabel("0");
        add(label);
        setPreferredSize(new Dimension(100, 100));
    }
}
