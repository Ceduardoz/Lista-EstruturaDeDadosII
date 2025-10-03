/**
** Função: Função recursiva
** Autor: Carlos Eduardo
** Data: 28/09/2025
** Observações:
*/

import java.util.*;

public class Harmonico {

    public static double calcularHarmonico(int numero) {
        if (numero < 1) throw new IllegalArgumentException("O número deve ser >= 1");
        if (numero == 1) return 1.0;
        return calcularHarmonico(numero - 1) + 1.0 / numero;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero = entrada.nextInt();
        System.out.printf("H(%d) = %.10f%n", numero, calcularHarmonico(numero));
        entrada.close();
    }
}
