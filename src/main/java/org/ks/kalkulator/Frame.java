package org.ks.kalkulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {
    int flag = 0,minFlag = 0;
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
            if(flag==1){
            flag=0;
            display.label.setText(String.valueOf(display.num1));
            }
            if (e.getSource() == keyboard.nButtons[i]) {
                display.label.setText(display.label.getText().concat(String.valueOf(i)));
                if(minFlag==0){
                    minFlag=1;
                }
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
            if(minFlag==0){
                display.label.setText(display.label.getText().concat(String.valueOf("-")));
            }else{
                display.num1 = Double.parseDouble(display.label.getText());
                keyboard.operator = '-';
                display.label.setText("");
            }
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
        if (e.getSource() == keyboard.procent){
            keyboard.operator2 = '%';
        }
        if (e.getSource() == keyboard.rowne) {
            if (keyboard.operator == '^') {
                display.num1 = Double.parseDouble(display.label.getText());
                display.result = display.num1 * display.num1;
                display.label.setText(String.valueOf(display.num1)+keyboard.operator+display.num1+"="+display.result);
            } else if (keyboard.operator == '√') {
                display.num1 = Double.parseDouble(display.label.getText());
                display.result = Math.sqrt(display.num1);
                display.label.setText(keyboard.operator+String.valueOf(display.num1)+"="+display.result);
            } else {
                display.num2 = Double.parseDouble(display.label.getText());
                if(keyboard.operator2 == '%'){
                    display.num2 = ((display.num2/100)*(display.num1));
                    display.label.setText(String.valueOf(display.num1)+keyboard.operator+display.num2+"="+display.result);
                }
                switch (keyboard.operator) {
                    case '+' -> {
                        display.result = display.num1 + display.num2;
                        display.label.setText(String.valueOf(display.num1) + keyboard.operator + display.num2 + "=" + display.result);
                    }
                    case '-' -> {
                        display.result = display.num1 - display.num2;
                        display.label.setText(String.valueOf(display.num1) + keyboard.operator + display.num2 + "=" + display.result);
                    }
                    case '*' -> {
                        display.result = display.num1 * display.num2;
                        display.label.setText(String.valueOf(display.num1) + keyboard.operator + display.num2 + "=" + display.result);
                    }
                    case '/' -> {
                        display.result = display.num1 / display.num2;
                        display.label.setText(String.valueOf(display.num1) + keyboard.operator + display.num2 + "=" + display.result);
                    }
                }
            }
            display.num1 = display.result;
            flag=1;
        }
        if (e.getSource() == keyboard.pierwiastek) {
            keyboard.operator = '√';
        }
        if (e.getSource() == keyboard.potega) {
            keyboard.operator = '^';
        }
        if (e.getSource() == keyboard.wyczysc) {
            flag = 0;
            display.num2 = 0;
            display.num1 = 0;
            display.result = 0;
            display.label.setText("");

        }
    }
    private Display display;
    private Keyboard keyboard;
}
