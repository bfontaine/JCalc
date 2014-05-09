package jcalc;

import java.util.*;
import java.util.logging.Logger;

/**
 * A model for a stack-based calculator
 **/
public class JCalcModel extends Observable {

    /**
     * Internal numbers stack.
     **/
    private Deque<Double> numbers;

    private double value;

    /**
     * Available operations
     **/
    private Hashtable<Character, JCalcOp> ops = JCalcOperations.defaultOps();

    private static Logger logger = Logger.getLogger("jcalc.JCalcModel");

    /**
     * Create a new model with an empty numbers stack
     **/
    public JCalcModel() {
        numbers = new ArrayDeque<Double>();
    }

    /**
     * Send a change notification to all observers with the model's current top
     * value.
     * @see getValue
     **/
    private void notifyChange() {
        setChanged();
        notifyObservers(value);
    }

    /**
     * Return the current value
     * @return current value
     **/
    public double getValue() { return value; }

    /**
     * Push the current value on the stack
     **/
    public void push() {
        numbers.push(value);
        value = 0;
        notifyChange();
    }

    /**
     * Set the current value
     **/
    public void setValue(double value) {
        this.value = value;
        notifyChange();
    }

    /**
     * Add a digit to the current value
     **/
    public void appendDigit(int d) {
        value = value * 10 + d;
        notifyChange();
    }

    /**
     * Pop a value from the numbers stack
     * @return the top value
     **/
    public double popValue() {
        if (numbers.isEmpty()) {
            return 0;
        }
        return numbers.pop();
    }

    /**
     * Reset the model and empty its numbers stack
     **/
    public void reset() {
        value = 0;
        numbers.clear();
        notifyChange();
    }

    /**
     * Execute an operation on the current stack. We might need to use a more
     * generic way of doing that in the future
     * @param op the operation
     **/
    public void executeOperation(char op) {
        if (!ops.containsKey(op)) {
            logger.warning("Unknown operation: "+op);
            return;
        }

        ops.get(op).execute(this);
        notifyChange();
    }
}
