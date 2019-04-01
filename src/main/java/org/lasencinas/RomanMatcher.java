package org.lasencinas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanMatcher {

    //Atributos

    private String numero = "";
    private Set<String> conjuntoSuman = new HashSet<>();
    private Set<String> conjuntoRestan = new HashSet<>();

    private static String valido = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})";
    private static String suma = "(?<!C)[MD]|(?<!X)[CL](?![DM])|(?<!I)[XV](?!LC)|[I](?!XV)";
    private static String resta = "(C[MD])|(X[CL])|(I[XV])";

    static Pattern suman = Pattern.compile(suma);
    static Pattern restan = Pattern.compile(resta);

    private Integer totalRestan = 0;

    //Métodos

    public static Boolean validarNumero(String numero) {
        return numero.matches(valido);
    }


    public static List<String> buscarSuman(String numero) {
        List<String> conjuntoSuman = new ArrayList<>();
        Matcher romano = suman.matcher(numero);
        while (romano.find()) {
            conjuntoSuman.add(romano.group());
        }
        return conjuntoSuman;
    }


    /*public static Set<String> buscarRestan(String numero) {
        Matcher romano = restan.matcher(numero);
        while (romano.find()) {
            conjuntoRestan.add(romano.group());
        }
        return conjuntoRestan;
    }*/


    public static Integer traducirRomano(String numero) {
        Integer totalSuman = 0;
        for (String grupo : buscarSuman(numero)) {
            for (Romanos romano : Romanos.values()) {
                if (romano.name().equals(grupo)) {
                    totalSuman += romano.getValor();
                }
            }
        }
        return totalSuman;
    }
}
