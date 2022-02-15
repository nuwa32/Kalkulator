package org.ks.kalkulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {
    //    private String getExpresionasString(){
//        return (display.num1+"") + keyboard.operator + (display.num2+"");
//    }
    public Frame() {
        super("kalkulator");
        JPanel content = new JPanel();
        display = new Display();
        keyboard = new Keyboard(this);
        content.add(display);
        content.add(keyboard);
        setPreferredSize(new Dimension(415, 370));
        setContentPane(content);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == keyboard.nButtons[i]) {
                display.label.setText(display.label.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == keyboard.przecinek) {
            display.label.setText(display.label.getText().concat("."));
        }
        if (e.getSource() == keyboard.dodaj) {
            display.num1 = Double.parseDouble(display.label.getText());
            keyboard.operator = '+';
            display.label.setText("");
        }
        if (e.getSource() == keyboard.odejmij) {
            display.num1 = Double.parseDouble(display.label.getText());
            keyboard.operator = '-';
            display.label.setText("");
        }
        if (e.getSource() == keyboard.pomnoz) {
            display.num1 = Double.parseDouble(display.label.getText());
            keyboard.operator = '*';
            display.label.setText("");
        }
        if (e.getSource() == keyboard.podziel) {
            display.num1 = Double.parseDouble(display.label.getText());
            keyboard.operator = '/';
            display.label.setText("");
        }
        if (e.getSource() == keyboard.rowne) {
            if (keyboard.operator == '^') {
                display.num1 = Double.parseDouble(display.label.getText());
                display.result = display.num1 * display.num1;
            } else if (keyboard.operator == '√') {
                display.num1 = Double.parseDouble(display.label.getText());
                display.result = Math.sqrt(display.num1);
            } else {
                display.num2 = Double.parseDouble(display.label.getText());

                switch (keyboard.operator) {
                    case '+':
                        display.result = display.num1 + display.num2;
                        break;
                    case '-':
                        display.result = display.num1 - display.num2;
                        break;
                    case '*':
                        display.result = display.num1 * display.num2;
                        break;
                    case '/':
                        display.result = display.num1 / display.num2;
                        break;
                }
            }
            display.label.setText(String.valueOf(display.result));
            display.num1 = display.result;
        }
        if (e.getSource() == keyboard.pierwiastek) {
            keyboard.operator = '√';
        }
        if (e.getSource() == keyboard.potega) {
            keyboard.operator = '^';
        }
        if (e.getSource() == keyboard.procent){
            display.num2 = Double.parseDouble(display.label.getText());
            keyboard.operator = '%';
            display.num2 = (display.num2/100)*(display.num1);
        }
        if (e.getSource() == keyboard.wyczysc) {
            display.label.setText("");
        }
    }

    private Display display;
    private Keyboard keyboard;
}
