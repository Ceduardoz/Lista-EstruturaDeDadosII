/**
** Função: Função recursiva String revertida
** Autor: Carlos Eduardo
** Data: 28/09/2025
** Observações:
*/

import java.util.*;

public class InverterStringRec {
    public static void imprimirInvertido(String texto) {
        if (texto == null || texto.length() == 0) return;
        imprimirInvertido(texto.substring(1));
        System.out.print(texto.charAt(0));
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String texto = entrada.hasNextLine() ? entrada.nextLine() : "";
        imprimirInvertido(texto);
        System.out.println();
        entrada.close();
    }
}

