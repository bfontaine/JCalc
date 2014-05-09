package jcalc;

import java.util.*;
import java.util.logging.Logger;

/**
 * A model for a calculator. This is a digits suffix calculator for now.
 **/
public class JCalcModel extends Observable {

    /**
     * Internal numbers stack. These are integers for now.
     **/
    private Deque<Integer> numbers;

    /**
     * Available operations
     **/
    private Hashtable<Character, JCalcOp> ops = JCalcOperations.defaultOps();

    private static Logger logger = Logger.getLogger("jcalc.JCalcModel");

    /**
     * Create a new model with an empty numbers stack
     **/
    public JCalcModel() {
        numbers = new ArrayDeque<Integer>();
    }

    /**
     * Send a change notification to all observers with the model's current top
     * value.
     * @see getValue
     **/
    private void notifyChange() {
        setChanged();
        notifyObservers(getValue());
    }

    /**
     * Return the current top value
     * @return current top value
     **/
    public int getValue() {
        Integer v = numbers.peek();

        return v != null ? v : 0;
    }

    /**
     * Push a new value on the numbers stack
     * @param n the new value
     * @see popValue
     **/
    public void pushValue(int n) {
        numbers.push(new Integer(n));
        notifyChange();
    }

    /**
     * Pop a value from the numbers stack
     * @return the top value
     * @see pushValue
     **/
    public int popValue() {
        if (numbers.isEmpty()) {
            return 0;
        }
        return numbers.pop();
    }

    /**
     * Reset the model and empty its numbers stack
     **/
    public void reset() {
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
