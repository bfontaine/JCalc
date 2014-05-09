package jcalc;

import java.util.Hashtable;

abstract class JCalcOp {
    abstract void execute(JCalcModel m);
}
abstract class JCalcBinaryOp extends JCalcOp {
    public void execute(JCalcModel m) {
        int b = m.popValue(),
            a = m.popValue();

        m.pushValue(compute(a, b));
    }

    abstract int compute(int a, int b);
}

/**
 * A container for all calculator functions
 **/
public class JCalcOperations {
    private static Hashtable<Character, JCalcOp> ops = null;

    /**
     * return the default operations table
     **/
    public static Hashtable<Character, JCalcOp> defaultOps() {
        if (ops == null) {
            init();
        }
        return ops;
    }

    /**
     * initialize the available operations table
     **/
    private static void init() {
        ops = new Hashtable<Character, JCalcOp>();

        ops.put('+', new JCalcBinaryOp() {
            int compute(int a, int b) {
                return a+b;
            }
        });

        ops.put('-', new JCalcBinaryOp() {
            int compute(int a, int b) {
                return a-b;
            }
        });

        ops.put('*', new JCalcBinaryOp() {
            int compute(int a, int b) {
                return a*b;
            }
        });
    }
}
