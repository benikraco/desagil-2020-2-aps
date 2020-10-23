package br.pro.hashi.ensino.deagil.aps.view;

import br.pro.hashi.ensino.deagil.aps.model.Gate;
import br.pro.hashi.ensino.deagil.aps.model.Light;
import br.pro.hashi.ensino.deagil.aps.model.Switch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;


public class GateView extends FixedPanel implements ActionListener, MouseListener {

    private final Gate gate;

    private final JCheckBox check1;
    private final JCheckBox check2;
    //private final JCheckBox result;
    private final Switch sw1;
    private final Switch sw2;
    private final Image image;
    private final Light light = new Light(255, 0, 0);
    private Color color;

    public GateView(Gate gate) {
        super();

        sw1 = new Switch();
        sw2 = new Switch();

        this.gate = gate;
        check1 = new JCheckBox("");
        check2 = new JCheckBox("");
        //result = new JCheckBox("");


        if (gate.getInputSize() == 1) {
            add(check1, 25, 90);
        } else {
            add(check1, 25, 68);
            add(check2, 25, 113);
        }

        //add(result,200, 45,25,25);

        color = light.getColor();

        String name = gate.toString() + ".png";
        //System.out.println(name);
        URL url = getClass().getClassLoader().getResource(name);
        image = getToolkit().getImage(url);

        check1.addActionListener(this);
        check2.addActionListener(this);

        //result.setEnabled(false);

        addMouseListener(this);

        update();
        repaint();

    }

    private void update() {
        boolean input1;
        boolean input2;

        //Switch sw1 = new Switch();
        //Switch sw2 = new Switch();

        input1 = check1.isSelected();
        input2 = check2.isSelected();

        if (input1) {
            sw1.turnOn();
        } else {
            sw1.turnOff();
        }
        this.gate.connect(0, sw1);

        if (this.gate.getInputSize() > 1) {
            if (input2) {
                sw2.turnOn();
            } else{
                sw2.turnOff();
            }
            this.gate.connect(1, sw2);
        }


        color = light.getColor();
        light.connect(0, this.gate);

        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        update();
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        int x = event.getX();
        int y = event.getY();

        if (Math.pow((x - 247), 2) + Math.pow((y - 105), 2) <= 225) {
            if (this.gate.read()) {
                light.setColor(JColorChooser.showDialog(this, null, color));
            } else {
                light.setColor(Color.BLACK);
            }
        }
        update();

    }

    @Override
    public void mousePressed(MouseEvent event) {

    }

    @Override
    public void mouseReleased(MouseEvent event) {

    }

    @Override
    public void mouseEntered(MouseEvent event) {

    }

    @Override
    public void mouseExited(MouseEvent event) {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 50, 40, 180, 130, this);
        g.setColor(color);
        g.fillOval(232, 90, 30, 30);
        getToolkit().sync();
    }

}


