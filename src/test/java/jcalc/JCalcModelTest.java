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
        assertEquals(0.0, m.getValue(), 0.0001);
    }
}
