/**
** Função: Função recursiva soma dos quadrados de N
** Autor: Carlos Eduardo
** Data: 01/10/2025
** Observações:
*/

import java.util.*;

public class SomaQuadradosRec {
    public static long somaQuadrados(int n) {
        if (n <= 0) return 0L;
        return somaQuadrados(n - 1) + 1L * n * n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(somaQuadrados(n));
        sc.close();
    }
}
