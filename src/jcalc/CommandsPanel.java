package jcalc;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

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

    public NumberButton(int value, ActionListener l) {
        this(value);
        addActionListener(l);
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

    public OperationButton(char op, ActionListener l) {
        this(op);
        addActionListener(l);
    }

    public char getOp() { return op; }
}

class NumbersPanel extends JPanel {

    private NumberButton[] buttons;

    public NumbersPanel(ActionListener listener) {
        super();

        JPanel main = new JPanel(),
               more = new JPanel();

        // we might want to use a GridBagLayout instead in the future
        main.setLayout(new GridLayout(0, 3));

        setLayout(new BorderLayout());
        add(main, BorderLayout.CENTER);
        add(more, BorderLayout.SOUTH);

        buttons = new NumberButton[10];

        for (int i=0; i<buttons.length; i++) {
            buttons[i] = new NumberButton(i, listener);

            if (i > 0) {
                main.add(buttons[i]);
            } else {
                more.add(buttons[i]);
            }
        }
    }
}

class OperationsPanel extends JPanel {
    public OperationsPanel(ActionListener listener) {
        super();

        JPanel main = new JPanel(),
               more = new JPanel();

        // we might want to use a GridBagLayout instead in the future
        main.setLayout(new GridLayout(0, 2));

        setLayout(new BorderLayout());
        add(main, BorderLayout.CENTER);
        add(more, BorderLayout.SOUTH);

        OperationButton plus  = new OperationButton('+', listener);
        OperationButton minus = new OperationButton('-', listener);

        OperationButton equals = new OperationButton('=', listener);

        main.add(plus);
        main.add(minus);

        more.add(equals);
    }
}

public class CommandsPanel extends JPanel {
    public CommandsPanel(ActionListener listener) {
        super();

        add(new NumbersPanel(listener));
        add(new OperationsPanel(listener));
    }
}
