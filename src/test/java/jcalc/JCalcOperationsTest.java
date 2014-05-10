package jcalc;

import java.util.Hashtable;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class JCalcOperationsTest {
    protected Hashtable<Character, JCalcBinaryOp> opts;

    @Before
    public void setUp() {
        opts = JCalcOperations.defaultOps();
    }

    @After
    public void tearDown() {}

    @Test
    public void nonNullOperations() {
        assertNotNull(opts);
    }

    @Test
    public void testAddition() {
        assertTrue(opts.containsKey('+'));
        JCalcBinaryOp op = opts.get('+');

        assertEquals(4.0, op.compute(3, 1), 0);
        assertEquals(9.0, op.compute(2, 7), 0);
        assertEquals(5.0, op.compute(-2, 7), 0);
        assertEquals(3.4, op.compute(1.2, 2.2), 0.001);
    }

    @Test
    public void testSubtraction() {
        assertTrue(opts.containsKey('-'));
        JCalcBinaryOp op = opts.get('-');

        assertEquals(2.0, op.compute(3, 1), 0);
        assertEquals(-5.0, op.compute(2, 7), 0);
        assertEquals(-9.0, op.compute(-2, 7), 0);
        assertEquals(-1.0, op.compute(1.2, 2.2), 0.001);
    }

    @Test
    public void testMultiplication() {
        assertTrue(opts.containsKey('*'));
        JCalcBinaryOp op = opts.get('*');

        assertEquals(3.0, op.compute(3, 1), 0);
        assertEquals(14.0, op.compute(2, 7), 0);
        assertEquals(-14.0, op.compute(-2, 7), 0);
        assertEquals(2.64, op.compute(1.2, 2.2), 0.001);
    }

    @Test
    public void testDivision() {
        assertTrue(opts.containsKey('/'));
        JCalcBinaryOp op = opts.get('/');

        assertEquals(3.0, op.compute(3, 1), 0);
        assertEquals(0.4, op.compute(2, 5), 0);
        assertEquals(-0.4, op.compute(-2, 5), 0.01);
        assertEquals(1.375, op.compute(2.2, 1.6), 0.0001);

        assertEquals(1/0.0, op.compute(1, 0), 0);
    }

    @Test
    public void testPower() {
        assertTrue(opts.containsKey('^'));
        JCalcBinaryOp op = opts.get('^');

        assertEquals(3.0, op.compute(3, 1), 0);
        assertEquals(1.0, op.compute(3, 0), 0);
        assertEquals(32.0, op.compute(2, 5), 0);
        assertEquals(16.0, op.compute(-2, 4), 0.01);
    }

    @Test
    public void testModulo() {
        assertTrue(opts.containsKey('%'));
        JCalcBinaryOp op = opts.get('%');

        assertEquals(1.0, op.compute(3, 2), 0);
        assertEquals(0.0, op.compute(3, 3), 0);
        assertEquals(2.0, op.compute(2, 5), 0);
        assertEquals(3.0, op.compute(15, 4), 0);
    }
}
