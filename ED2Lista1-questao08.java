/**
** Função: Função recursiva String revertida
** Autor: Carlos Eduardo
** Data: 29/09/2025
** Observações:
*/

import java.util.*;

public class Main {
    static long total = 0;

    private static void gerarPermutacoes(char[] caracteres, boolean[] usado, StringBuilder atual) {
        if (atual.length() == caracteres.length) {
            System.out.println(atual.toString());
            total++;
            return;
        }
        for (int i = 0; i < caracteres.length; i++) {
            if (usado[i]) continue;
            if (i > 0 && caracteres[i] == caracteres[i - 1] && !usado[i - 1]) continue;

            usado[i] = true;
            atual.append(caracteres[i]);
            gerarPermutacoes(caracteres, usado, atual);
            atual.deleteCharAt(atual.length() - 1);
            usado[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = sc.hasNextLine() ? sc.nextLine().trim() : "";
        sc.close();

        char[] caracteres = entrada.toCharArray();
        Arrays.sort(caracteres);
        gerarPermutacoes(caracteres, new boolean[caracteres.length], new StringBuilder());

        System.out.println("Quantidade de permutações: " + total);
    }
}
