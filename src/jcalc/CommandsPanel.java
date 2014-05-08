package jcalc;

import java.awt.event.ActionListener;
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

public class CommandsPanel extends JPanel {
    private NumberButton[] buttons;
    private OperationButton[] operations;

    private static final int MAX_NUMBER = 9;

    public CommandsPanel(ActionListener listener) {

        super();

        buttons = new NumberButton[MAX_NUMBER+1];

        for (int i=0; i<buttons.length; i++) {
            buttons[i] = new NumberButton(i);
            buttons[i].addActionListener(listener);
            add(buttons[i]);
        }

        // tmp
        operations = new OperationButton[] {
            new OperationButton('+'),
            new OperationButton('=')
        };

        for (int i=0; i<operations.length; i++) {
            operations[i].addActionListener(listener);
            add(operations[i]);
        }
    }
}
