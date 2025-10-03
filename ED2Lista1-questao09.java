/**
** Função: Função recursiva String revertida
** Autor: Carlos Eduardo
** Data: 29/09/2025
** Observações:
*/

import java.util.*;

public class CesarPT {
    static String cifra(String texto, int deslocamento) {
        int shift = ((deslocamento % 26) + 26) % 26;
        StringBuilder resultado = new StringBuilder(texto.length());
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                resultado.append((char) ('A' + (c - 'A' + shift) % 26));
            } else if (c >= 'a' && c <= 'z') {
                resultado.append((char) ('a' + (c - 'a' + shift) % 26));
            } else {
                resultado.append(c);
            }
        }
        return resultado.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");
        String modo = sc.next();
        int chave = sc.nextInt();
        sc.nextLine();
        String mensagem = sc.hasNextLine() ? sc.nextLine() : "";
        sc.close();

        int deslocamento = modo.equalsIgnoreCase("D") ? -chave : chave;
        String resultado = cifra(mensagem, deslocamento);
        System.out.println(resultado);
    }
}
