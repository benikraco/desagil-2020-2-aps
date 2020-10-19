package br.pro.hashi.ensino.deagil.aps.view;

import br.pro.hashi.ensino.deagil.aps.model.Gate;
import br.pro.hashi.ensino.deagil.aps.model.Switch;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GateView extends JPanel implements ActionListener {

    private final Gate gate;

    private final JCheckBox check1;
    private final JCheckBox check2;
    private final JCheckBox result;

    public GateView(Gate gate) {
        this.gate = gate;
        check1 = new JCheckBox("");
        check2 = new JCheckBox("");
        result = new JCheckBox("resultado");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        if (gate.getInputSize() == 1) {
            add(check1);
        } else {
            add(check1);
            add(check2);
        }

        add(result);
        check1.addActionListener(this);
        check2.addActionListener(this);

        result.setEnabled(false);

        update();

    }

    private void update() {
        boolean input1;
        boolean input2;

        System.out.println();

        Switch sw1 = new Switch();
        Switch sw2 = new Switch();

        input1 = check1.isSelected();
        input2 = check2.isSelected();
        if (input1) {
            sw1.turnOn();
        }
        this.gate.connect(0, sw1);

        if (this.gate.getInputSize() > 1) {
            if (input2) {
                sw2.turnOn();
            }
            this.gate.connect(1, sw2);
        }

        this.result.setSelected(this.gate.read());

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        update();
    }

}
