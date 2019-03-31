package org.lasencinas;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class RomanosTest {

    String mil = "M";
    String dosMil = "MM";
    String tresMil = "MMM";
    String fakeCuatroMil = "MMMM"; //Error
    String milQuinientos = "MD";
    String milMil = "MDD"; //Error
    String fakeMil = "DD"; //Error
    String milCien = "MC";
    String milDosCientos = "MCC";
    String milTresCientos = "MCCC";
    String fakeCuatrocientos= "CCCC"; //Error
    String seisCientos = "DC";
    String veinte = "X";
    String treinta = "XXX";
    String fakeCuarenta = "XXXX"; //Error
    String numeroUno = "IVX"; //Error
    String numeroDos = "MMMDCCCLXXXVIII";
    String numeroTres = "DM"; //Error
    String numeroCuatro = "CMCD"; //Error


    @Test
    public void getValorTest() {
        Romanos uno = Romanos.I;
        Romanos cien = Romanos.C;
        assertEquals(uno.getValor(), 1);
        assertEquals(cien.getValor(), 100);
    }

    @Test
    public void validarNumeroTest() {
        assertTrue(RomanMatcher.validarNumero(mil));
        assertTrue(RomanMatcher.validarNumero(dosMil));
        assertTrue(RomanMatcher.validarNumero(tresMil));
        assertFalse(RomanMatcher.validarNumero(fakeCuatroMil));
        assertTrue(RomanMatcher.validarNumero(milQuinientos));
        assertFalse(RomanMatcher.validarNumero(milMil));
        assertFalse(RomanMatcher.validarNumero(fakeMil));
        assertTrue(RomanMatcher.validarNumero(milCien));
        assertTrue(RomanMatcher.validarNumero(milDosCientos));
        assertTrue(RomanMatcher.validarNumero(milTresCientos));
        assertFalse(RomanMatcher.validarNumero(fakeCuatrocientos));
        assertTrue(RomanMatcher.validarNumero(seisCientos));
        assertTrue(RomanMatcher.validarNumero(veinte));
        assertTrue(RomanMatcher.validarNumero(treinta));
        assertFalse(RomanMatcher.validarNumero(fakeCuarenta));
        assertFalse(RomanMatcher.validarNumero(numeroUno));
        assertTrue(RomanMatcher.validarNumero(numeroDos));
        assertFalse(RomanMatcher.validarNumero(numeroTres));
        assertFalse(RomanMatcher.validarNumero(numeroCuatro));
    }

    @Test
    public void buscarSumanTest() {
        assertTrue(RomanMatcher.buscarSuman(numeroDos).contains("M"));
        assertTrue(RomanMatcher.buscarSuman(numeroDos).contains("D"));
        assertTrue(RomanMatcher.buscarSuman(numeroDos).contains("L"));
        assertTrue(RomanMatcher.buscarSuman(numeroDos).contains("X"));
        assertTrue(RomanMatcher.buscarSuman(milQuinientos).contains("M"));
        assertTrue(RomanMatcher.buscarSuman(milQuinientos).contains("D"));
    }


    @Test
    public void buscarRestanTest() {
        assertTrue(RomanMatcher.buscarRestan(numeroUno).contains("IV"));
        assertTrue(RomanMatcher.buscarRestan(numeroCuatro).contains("CM"));
    }

}
