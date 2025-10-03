/**
** Função: Função recursiva permutações/anagramas
** Autor: Carlos Eduardo
** Data: 29/09/2025
** Observações:
*/

import java.util.*;

public class PermutacoesAnagramas {
    static long total = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = sc.hasNextLine() ? sc.nextLine() : "";
        sc.close();

        char[] caracteres = entrada.toCharArray();
        Arrays.sort(caracteres);
        boolean[] usado = new boolean[caracteres.length];
        StringBuilder atual = new StringBuilder();

        gerarPermutacoes(caracteres, usado, atual);

        System.out.println("Quantidade: " + total);
    }

    private static void gerarPermutacoes(char[] caracteres, boolean[] usado, StringBuilder atual) {
        if (atual.length() == caracteres.length) {
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
}
