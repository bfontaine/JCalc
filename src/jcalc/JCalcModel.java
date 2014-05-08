package jcalc;

import java.util.*;

// this is a suffix calc model for now
class JCalcModel extends Observable {

    // we'll use integers for now
    private Deque<Integer> numbers;

    public JCalcModel() {
        numbers = new ArrayDeque<Integer>();
    }

    private void notifyChange() {
        setChanged();
        notifyObservers(getValue());
    }

    public int getValue() {
        Integer v = numbers.peek();

        return v != null ? v : 0;
    }

    public void pushValue(int n) {
        numbers.push(new Integer(n));
        notifyChange();
    }

    public int popValue() {
        if (numbers.isEmpty()) {
            return 0;
        }
        return numbers.pop();
    }

    public void reset() {
        numbers.clear();
        notifyChange();
    }

    // tmp method, we'll use a more generic way to do operations after
    public void executeOperation(char op) {
        switch(op) {
        case '+':
            pushValue(popValue()+popValue());
            break;
        case '-':
            int p = popValue();
            pushValue(popValue()-p);
        }

        notifyChange();
    }
}
