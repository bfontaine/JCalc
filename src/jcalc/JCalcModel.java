package jcalc;

import java.util.*;

class JCalcModel extends Observable {

    // we'll use integers for now
    private Deque<Integer> numbers;

    public JCalcModel() {
        numbers = new ArrayDeque<Integer>();
    }

    public int getValue() {
        Integer v = numbers.peek();

        return v != null ? v : 0;
    }

    public void pushValue(int n) {
        numbers.push(new Integer(n));
        setChanged();
        notifyObservers();
    }

    public void reset() {
        numbers.clear();
        setChanged();
        notifyObservers();
    }

    public void executeOperation(char op) {
        // TODO
        setChanged();
        notifyObservers();
    }
}
