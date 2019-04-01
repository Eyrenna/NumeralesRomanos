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
    String veinte = "XX";
    String treinta = "XXX";
    String fakeCuarenta = "XXXX"; //Error
    String numeroUno = "IVX"; //Error
    String numeroDos = "MMMDCCCLXXXVIII";
    String numeroTres = "DM"; //Error
    String numeroCuatro = "CMCD"; //Error
    String numeroCinco = "MMCMXLVI";
    String dosDosCuatro = "CCXXIV";


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
    public void buscarGrupos() {
        assertTrue(RomanMatcher.buscarGrupos(numeroDos).contains("M"));
        assertTrue(RomanMatcher.buscarGrupos(numeroDos).contains("D"));
        assertTrue(RomanMatcher.buscarGrupos(numeroDos).contains("L"));
        assertTrue(RomanMatcher.buscarGrupos(numeroDos).contains("X"));
        assertTrue(RomanMatcher.buscarGrupos(milQuinientos).contains("M"));
        assertTrue(RomanMatcher.buscarGrupos(milQuinientos).contains("D"));
        assertTrue(RomanMatcher.buscarGrupos(numeroUno).contains("IV"));
        assertTrue(RomanMatcher.buscarGrupos(numeroCinco).contains("CM"));
        assertTrue(RomanMatcher.buscarGrupos(numeroCinco).contains("M"));
        assertTrue(RomanMatcher.buscarGrupos(numeroCinco).contains("XL"));
    }

    @Test
    public void traducirTest() {
        assertEquals(3888, RomanMatcher.traducirRomano(numeroDos), 0);
        assertEquals(1000, RomanMatcher.traducirRomano(mil), 0);
        assertEquals(2000, RomanMatcher.traducirRomano(dosMil), 0);
        assertEquals(3000, RomanMatcher.traducirRomano(tresMil), 0);
        assertEquals(0, RomanMatcher.traducirRomano(fakeCuatroMil), 0);
        assertEquals(1500, RomanMatcher.traducirRomano(milQuinientos), 0);
        assertEquals(0, RomanMatcher.traducirRomano(milMil), 0);
        assertEquals(0, RomanMatcher.traducirRomano(fakeMil), 0);
        assertEquals(1100, RomanMatcher.traducirRomano(milCien), 0);
        assertEquals(1200, RomanMatcher.traducirRomano(milDosCientos), 0);
        assertEquals(1300, RomanMatcher.traducirRomano(milTresCientos), 0);
        assertEquals(0, RomanMatcher.traducirRomano(fakeCuatrocientos), 0);
        assertEquals(600, RomanMatcher.traducirRomano(seisCientos), 0);
        assertEquals(20, RomanMatcher.traducirRomano(veinte), 0);
        assertEquals(30, RomanMatcher.traducirRomano(treinta), 0);
        assertEquals(0, RomanMatcher.traducirRomano(fakeCuarenta), 0);
        assertEquals(0, RomanMatcher.traducirRomano(numeroUno), 0);
        assertEquals(3888, RomanMatcher.traducirRomano(numeroDos), 0);
        assertEquals(0, RomanMatcher.traducirRomano(numeroTres), 0);
        assertEquals(0, RomanMatcher.traducirRomano(numeroCuatro), 0);
        //assertEquals(2946, RomanMatcher.traducirRomano(numeroCinco), 0);
        assertEquals(224, RomanMatcher.traducirRomano(dosDosCuatro), 0);
    }



}
