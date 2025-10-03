/**
** Função: Função recursiva mais vogais ou consoantes 
** Autor: Carlos Eduardo
** Data: 01/10/2025
** Observações:
*/

import java.util.*;

public class MaisVogaisRec {
    private static final String VOGAIS = "aeiouáàâãäéèêëíìîïóòôõöúùûü";

    public static boolean maisVogaisQueConsoantes(String texto) {
        return rec(texto, 0, 0);
    }

    private static boolean rec(String texto, int i, int diff) {
        if (i == texto.length()) return diff > 0;
        char c = texto.charAt(i);
        if (Character.isLetter(c)) {
            char lc = Character.toLowerCase(c);
            diff += (VOGAIS.indexOf(lc) >= 0) ? 1 : -1;
        }
        return rec(texto, i + 1, diff);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");
        String entrada = sc.hasNextLine() ? sc.nextLine() : "";
        sc.close();
        System.out.println(maisVogaisQueConsoantes(entrada));
    }
}
