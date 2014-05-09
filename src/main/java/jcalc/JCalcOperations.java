package jcalc;

import java.util.Hashtable;

/**
 * A binary operation
 **/
abstract class JCalcBinaryOp {
    public void execute(JCalcModel m) {
        double a = m.popValue(),
               b = m.getValue();

        m.setValue(compute(a, b));
    }

    abstract double compute(double a, double b);
}

/**
 * A container for all calculator functions
 **/
public class JCalcOperations {
    private static Hashtable<Character, JCalcBinaryOp> ops = null;

    /**
     * return the default operations table
     **/
    public static Hashtable<Character, JCalcBinaryOp> defaultOps() {
        if (ops == null) {
            init();
        }
        return ops;
    }

    /**
     * initialize the available operations table
     **/
    private static void init() {
        ops = new Hashtable<Character, JCalcBinaryOp>();

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

        ops.put('/', new JCalcBinaryOp() {
            double compute(double a, double b) {
                return a/b;
            }
        });
    }
}
