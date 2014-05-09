package jcalc;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * A button with a static action command string
 **/
class CalcButton extends JButton {

    /** the class' action command string */
    public static final String actionCommand = null;

    /**
     * @param s text of the button
     **/
    public CalcButton(String s) { super(s); }
}

/**
 * A button for numbers
 **/
class DigitButton extends CalcButton {

    public static final String actionCommand = "number";

    /** the button's value */
    private final int value;

    /**
     * @param value the button's value
     **/
    public DigitButton(int value) {
        super(""+value);
        this.value = value;
        setActionCommand(DigitButton.actionCommand);
    }

    /**
     * Create a button and add it a listener
     * @param value the button's value
     * @param l a listener for this button
     **/
    public DigitButton(int value, ActionListener l) {
        this(value);
        addActionListener(l);
    }

    /**
     * @return the button's value
     **/
    public int getValue() { return value; }
}

/**
 * A button for operations. A button's operation is represented as a char for
 * the moment.
 **/
class OperationButton extends CalcButton {
    public static final String actionCommand = "operation";

    /** the button's operation */
    private final char op;

    /**
     * @param op the button's operation
     **/
    public OperationButton(char op) {
        super(""+op);
        this.op = op;
        setActionCommand(OperationButton.actionCommand);
    }

    /**
     * Create a button and add it a listener
     * @param op the button's operation
     * @param l a listener for this button
     **/
    public OperationButton(char op, ActionListener l) {
        this(op);
        addActionListener(l);
    }

    /**
     * @return the button's operation
     **/
    public char getOp() { return op; }
}

/**
 * A panel for digit buttons
 **/
class DigitsPanel extends JPanel {

    /**
     * the panel's buttons
     **/
    private DigitButton[] buttons;

    /**
     * Create a panel with a common listener for all buttons
     * @param listener the listener to add on each button
     **/
    public DigitsPanel(ActionListener listener) {
        super();

        JPanel main = new JPanel(),
               more = new JPanel();

        // we might want to use a GridBagLayout instead in the future
        main.setLayout(new GridLayout(0, 3));

        setLayout(new BorderLayout());
        add(main, BorderLayout.CENTER);
        add(more, BorderLayout.SOUTH);

        buttons = new DigitButton[10];

        for (int i=0; i<buttons.length; i++) {
            buttons[i] = new DigitButton(i, listener);

            if (i > 0) {
                main.add(buttons[i]);
            } else {
                more.add(buttons[i]);
            }
        }
    }
}

/**
 * A panel for operation buttons
 **/
class OperationsPanel extends JPanel {

    /**
     * Create a panel with a common listener for all buttons
     * @param listener the listener to add on each button
     **/
    public OperationsPanel(ActionListener listener) {
        super();

        JPanel main = new JPanel(),
               more = new JPanel();

        // we might want to use a GridBagLayout instead in the future
        main.setLayout(new GridLayout(0, 2));

        setLayout(new BorderLayout());
        add(main, BorderLayout.CENTER);
        add(more, BorderLayout.SOUTH);

        for (Character c : new Character[] { '+', '-', '*' }) {
            main.add(new OperationButton(c, listener));
        }

        for (Character c : new Character[] { '=' }) {
            more.add(new OperationButton(c, listener));
        }
    }
}

/**
 * A panel for a calculator's buttons.
 **/
public class CommandsPanel extends JPanel {

    /**
     * Create a panel with a common listener for all buttons
     * @param listener the listener to add on each button
     **/
    public CommandsPanel(ActionListener listener) {
        super();

        add(new DigitsPanel(listener));
        add(new OperationsPanel(listener));
    }
}
