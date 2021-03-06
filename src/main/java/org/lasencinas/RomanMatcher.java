package org.lasencinas;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanMatcher {

    //Atributos

    private static String valido = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})";

    private static String grupos = "(C[MD])|(?<!C)[MD]|(X[CL])|(?<!X)[CL](?![DM])|(?<!I)[XV](?!LC)|(I[XV])|[I](?!XV)";


    //Métodos

    public static Boolean validarNumero(String numero) {
        return numero.matches(valido);
    }


    public static List<String> buscarGrupos(String numero) {
        List<String> conjunto = new ArrayList<>();
        Pattern patron = Pattern.compile(grupos);
        Matcher romano = patron.matcher(numero);
        while (romano.find()) {
            conjunto.add(romano.group());
        }
        return conjunto;
    }


    public static Integer traducirRomano(String numero) {
        Integer traduccion = 0;
        if (validarNumero(numero)){
            for (String grupo : buscarGrupos(numero)) {
                for (Romanos romano : Romanos.values()) {
                    if (romano.name().equals(grupo)) {
                        traduccion += romano.getValor();
                    }
                }
            }
        }return traduccion;
    }
}
