package org.lasencinas;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RomanosTest {


    @Test
    public void getValorTest() {
        Romanos uno = Romanos.I;
        assertEquals(uno.getValor(), 1);
    }
}
