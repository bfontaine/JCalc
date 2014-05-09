package jcalc;

import java.util.Hashtable;

abstract class JCalcOp {
    abstract void execute(JCalcModel m);
}
abstract class JCalcBinaryOp extends JCalcOp {
    public void execute(JCalcModel m) {
        double b = m.popValue(),
               a = m.popValue();

        m.pushValue(compute(a, b));
    }

    abstract double compute(double a, double b);
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
            double compute(double a, double b) {
                return a+b;
            }
        });

        ops.put('-', new JCalcBinaryOp() {
            double compute(double a, double b) {
                return a-b;
            }
        });

        ops.put('*', new JCalcBinaryOp() {
            double compute(double a, double b) {
                return a*b;
            }
        });
    }
}
