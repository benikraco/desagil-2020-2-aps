package br.pro.hashi.ensino.deagil.aps.view;

import javax.swing.*;
import java.awt.*;

public class FixedPanel extends JPanel {
    protected FixedPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(300, 250));

    }

    protected Component add(Component comp, int x, int y) {
        super.add(comp);
        comp.setBounds(x, y, 150, 30);
        return comp;
    }

}
