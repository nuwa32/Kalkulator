package org.ks.kalkulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class Keyboard extends JPanel implements ActionListener {

    private List<JButton> buttons = new ArrayList<JButton>();
    public JButton[] nButtons = new JButton[10];
    public JButton[] fButtons = new JButton[10];
    public JButton dodaj, odejmij, pomnoz, podziel, procent, pierwiastek, potega;
    public JButton przecinek, rowne, wyczysc;
    public char operator;
    private Frame parent;

    public Keyboard(Frame parent) {
        super();
        this.parent = parent;
        setLayout(new GridLayout(5, 4));
        dodaj = new JButton("+");
        odejmij = new JButton("-");
        pomnoz = new JButton("*");
        podziel = new JButton("/");
        procent = new JButton("%");
        pierwiastek = new JButton("√");
        potega = new JButton("^");
        przecinek = new JButton(".");
        rowne = new JButton("=");
        wyczysc = new JButton("C");
        fButtons[0] = dodaj;
        fButtons[1] = odejmij;
        fButtons[2] = pomnoz;
        fButtons[3] = podziel;
        fButtons[4] = procent;
        fButtons[5] = pierwiastek;
        fButtons[6] = potega;
        fButtons[7] = przecinek;
        fButtons[8] = rowne;
        fButtons[9] = wyczysc;
        for (int i = 0; i < 10; i++) {
            fButtons[i].setFocusable(false);
            fButtons[i].addActionListener(this);
        }

        for (int i = 0; i < 10; i++) {
            nButtons[i] = new JButton(String.valueOf(i));
            nButtons[i].addActionListener(this);
            nButtons[i].setFocusable(false);
        }
        add(pierwiastek);
        add(wyczysc);
        add(potega);
        add(podziel);
        add(procent);
        add(dodaj);
        add(odejmij);
        add(pomnoz);
        add(nButtons[7]);
        add(nButtons[8]);
        add(nButtons[9]);
        add(rowne);
        add(nButtons[4]);
        add(nButtons[5]);
        add(nButtons[6]);
        add(przecinek);
        add(nButtons[1]);
        add(nButtons[2]);
        add(nButtons[3]);
        add(nButtons[0]);
        buttons.add(dodaj);
        buttons.add(odejmij);
        buttons.add(pomnoz);
        buttons.add(podziel);
        buttons.add(procent);
        buttons.add(pierwiastek);
        buttons.add(potega);
        buttons.add(przecinek);
        buttons.add(rowne);
        buttons.add(wyczysc);
        buttons.add(nButtons[0]);
        buttons.add(nButtons[1]);
        buttons.add(nButtons[2]);
        buttons.add(nButtons[3]);
        buttons.add(nButtons[4]);
        buttons.add(nButtons[5]);
        buttons.add(nButtons[6]);
        buttons.add(nButtons[7]);
        buttons.add(nButtons[8]);
        buttons.add(nButtons[9]);
        setPreferredSize(new Dimension(400, 300));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.parent.actionPerformed(e);
    }
}



