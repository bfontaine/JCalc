package jcalc;

import java.util.Hashtable;

/**
 * A binary operation
 **/
abstract class JCalcBinaryOp {

    /**
     * Execute the operation on a model
     * @param m the model
     **/
    public void execute(JCalcModel m) {
        double a = m.popValue(),
               b = m.getValue();

        m.setValue(compute(a, b));
    }

    /**
     * Shortcut for simple operations
     * @param a first value
     * @param b second value
     * @return the result of the operation applied on these values
     **/
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
