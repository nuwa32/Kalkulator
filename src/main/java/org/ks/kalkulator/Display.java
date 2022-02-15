package org.ks.kalkulator;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {
    public double num1=0,num2=0,result=0;
    public JLabel label;
    /*public void addContent(String string){
        label.setText(label.getText()+string);
    }*/
    public Display() {
        super();
        label = new JLabel("");
        add(label);
        setPreferredSize(new Dimension(400, 30));
    }
}
