/**
** Função: Função recursiva palíndromo
** Autor: Carlos Eduardo
** Data: 02/10/2025
** Observações:
*/

import java.util.*;

public class PalindromoRec {
    public static boolean ehPalindromo(String texto) {
        StringBuilder limpo = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isLetterOrDigit(c)) limpo.append(Character.toLowerCase(c));
        }
        return rec(limpo, 0, limpo.length() - 1);
    }

    private static boolean rec(CharSequence texto, int i, int j) {
        if (i >= j) return true;
        if (texto.charAt(i) != texto.charAt(j)) return false;
        return rec(texto, i + 1, j - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");
        String entrada = sc.hasNextLine() ? sc.nextLine() : "";
        sc.close();
        System.out.println(ehPalindromo(entrada));
    }
}
