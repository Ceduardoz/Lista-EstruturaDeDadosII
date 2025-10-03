/**
** Função: Função recursiva Aproximação de e
** Autor: Carlos Eduardo
** Data: 01/10/2025
** Observações:
*/

import java.util.*;

public class AproximaERecursivo {
    private static final double EPS = 1.0e-8;

    public static double calculaE() {
        return calculaE(1.0, 0, 1.0);
    }

    private static double calculaE(double termo, int n, double soma) {
        double prox = termo / (n + 1);
        if (prox < EPS) return soma;
        return calculaE(prox, n + 1, soma + prox);
    }

    public static void main(String[] args) {
        double e = calculaE();
        System.out.printf(Locale.US, "%.12f%n", e);
    }
}
