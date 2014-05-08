package jcalc;

import java.util.Observer;
import java.util.Observable;
import java.awt.event.*;
import javax.swing.*;

class CalcButton extends JButton {
    public static final String actionCommand = null;

    public CalcButton(String s) { super(s); }
}

class NumberButton extends CalcButton {

    public static final String actionCommand = "number";
    private final int value;

    public NumberButton(int value) {
        super(""+value);
        this.value = value;
        setActionCommand(NumberButton.actionCommand);
    }

    public int getValue() { return value; }
}

class OperationButton extends CalcButton {
    public static final String actionCommand = "operation";
    private final char op;

    public OperationButton(char op) {
        super(""+op);
        this.op = op;
        setActionCommand(OperationButton.actionCommand);
    }
}

class JCalcView extends JPanel implements Observer {

    private JTextField result;

    private NumberButton[] numbers;
    private OperationButton[] operations;

    public JCalcView() {
        super();
        setup();
    }

    private void setup() {
        result = new JTextField(20);

        result.setText("0");
        result.setEnabled(false);
        result.setHorizontalAlignment(JTextField.RIGHT);

        setupNumbers();
        setupOperations();

        add(result);
    }

    private void setupNumbers() {}
    private void setupOperations() {}

    public void update(Observable source, Object data) {
    }
}
