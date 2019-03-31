package org.lasencinas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanMatcher {

    //Atributos

    private static String numero = "";

    private static String valido = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})";
    private String suma = "";
    private String resta = "";

    Pattern validos = Pattern.compile(valido);
    Pattern suman = Pattern.compile(suma);
    Pattern restan = Pattern.compile(resta);

    //Métodos

    public static Boolean validarNumero(String numero) {
        return numero.matches(valido);
    }
}
