package jcalc;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * A button with an internal value
 **/
class CalcButton<E> extends JButton {

    private E value;

    public CalcButton() { super(); }

    /**
     * Create a button and add it a listener
     * @param value the button's value
     * @param l a listener for this button
     **/
    public CalcButton(E value, ActionListener l, String action) {
        super(value.toString());
        this.value = value;
        setActionCommand(action);
        addActionListener(l);
    }

    public E getValue() { return value; }
}

/**
 * A button for numbers
 **/
class DigitButton extends CalcButton<Integer> {
    public DigitButton(Integer v, ActionListener l) {
        super(v, l, "number");
    }
}

/**
 * A button for operations.
 **/
class OperationButton extends CalcButton<Character> {
    public OperationButton(Character v, ActionListener l) {
        super(v, l, "operation");
    }
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
            buttons[i] = new DigitButton(new Integer(i), listener);

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
