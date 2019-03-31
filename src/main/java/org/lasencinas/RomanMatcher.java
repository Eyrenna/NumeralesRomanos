package org.lasencinas;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanMatcher {

    //Atributos

    private static String numero = "";
    private static Set<String> conjuntoSuman = new HashSet<>();
    private static Set<String> conjuntoRestan = new HashSet<>();

    private static String valido = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})";
    private static String suma = "(?<!C)[MD]|(?<!X)[CL](?![DM])|(?<!I)[XV](?!LC)|[I](?!XV)";
    private static String resta = "(C[MD])|(X[CL])|(I[XV])";

    static Pattern suman = Pattern.compile(suma);
    static Pattern restan = Pattern.compile(resta);

    //Métodos

    public static Boolean validarNumero(String numero) {
        return numero.matches(valido);
    }


    public static Set<String> buscarSuman(String numero) {
        Matcher romano = suman.matcher(numero);
        while (romano.find()) {
            conjuntoSuman.add(romano.group());
        }
        return conjuntoSuman;
    }


    public static Set<String> buscarRestan(String numero) {
        Matcher romano = restan.matcher(numero);
        while (romano.find()) {
            conjuntoRestan.add(romano.group());
        }
        return conjuntoRestan;
    }

}
