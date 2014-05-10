package jcalc;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class JCalcModelTest {
    protected JCalcModel m;

    @Before
    public void setUp() {
        m = new JCalcModel();
    }

    @After
    public void tearDown() {}

    @Test
    public void testInitialValueIsZero() throws Exception {
        assertEquals(0.0, m.getValue(), 0);
    }

    @Test
    public void testSetValueChangesTheValue() throws Exception {
        double val = 42;
        m.setValue(val);
        assertEquals(val, m.getValue(), 0);
    }

    @Test
    public void testAppendDigit0To0() throws Exception {
        m.appendDigit(0);
        assertEquals(0, m.getValue(), 0);
    }

    @Test
    public void testAppendDigit0ToNonZeroValue() throws Exception {
        m.setValue(3);
        m.appendDigit(0);
        assertEquals(30, m.getValue(), 0);
    }

    @Test
    public void testAppendDigit() throws Exception {
        m.setValue(1);
        m.appendDigit(2);
        m.appendDigit(3);
        m.appendDigit(4);
        assertEquals(1234, m.getValue(), 0);
    }

    @Test
    public void testPushSetTheValueToZero() throws Exception {
        m.setValue(304);
        m.push();
        assertEquals(0, m.getValue(), 0);
    }

    @Test
    public void testPopPreserveValue() throws Exception {
        double val = 25;
        m.setValue(42);
        m.push();
        m.setValue(val);
        m.popValue();
        assertEquals(val, m.getValue(), 0);
    }

    @Test
    public void testPushPopSameValue() throws Exception {
        double val = 25;
        m.setValue(val);
        m.push();
        m.setValue(42);
        assertEquals(val, m.popValue(), 0);
    }

    @Test
    public void testPopEmptyGives0() throws Exception {
        double top = 1395;
        m.setValue(top);
        m.push();
        m.setValue(42);
        assertEquals(top, m.popValue(), 0);
        assertEquals(0, m.popValue(), 0);
        assertEquals(0, m.popValue(), 0);
    }

    @Test
    public void testResetValue() throws Exception {
        m.setValue(173);
        m.reset();
        assertEquals(0, m.getValue(), 0);
    }

    @Test
    public void testResetEmptyTheStack() throws Exception {
        m.setValue(173);
        m.push();
        m.reset();
        assertEquals(0, m.popValue(), 0);
    }

    @Test
    public void testExecuteAdditionOnEmptyStack() throws Exception {
        m.executeOperation('+');
        assertEquals(0, m.getValue(), 0);
    }

    @Test
    public void testExecuteAddition() throws Exception {
        double a = 12,
               b = 16;
        m.setValue(a);
        m.push();
        m.setValue(b);
        m.executeOperation('+');
        assertEquals(a+b, m.getValue(), 0);
    }

    @Test
    public void testExecuteSubtraction() throws Exception {
        double a = 12,
               b = 16;
        m.setValue(a);
        m.push();
        m.setValue(b);
        m.executeOperation('-');
        assertEquals(a-b, m.getValue(), 0);
    }
}
