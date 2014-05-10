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
}
