package jcalc;

import java.util.Observer;
import java.util.Observable;
import java.awt.event.*;
import javax.swing.*;

class JCalcView extends JPanel implements Observer {

    private JTextField result;

    public JCalcView() {
        super();
        setup();
    }

    private void setup() {
        result = new JTextField(20);

        result.setText("0");
        result.setEnabled(false);
        result.setHorizontalAlignment(JTextField.RIGHT);

        add(result);
    }

    public void update(Observable source, Object data) {
    }
}
