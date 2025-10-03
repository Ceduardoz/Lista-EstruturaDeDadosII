/**
** Função: Função recursiva Binômio de Newton
** Autor: Carlos Eduardo
** Data: 02/10/2025
** Observações:
*/

import java.util.*;

public class BinomioNewton {
    static long[][] memo = new long[11][11];

    static long C(int n, int k) {
        if (k == 0 || k == n) return 1;
        if (memo[n][k] != 0) return memo[n][k];
        return memo[n][k] = C(n - 1, k - 1) + C(n - 1, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        if (n < 0 || n >= 10) {
            System.out.println("n deve satisfazer 0 <= n < 10");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("(x+1)^").append(n).append(" = ");

        for (int i = n; i >= 0; i--) {
            long coef = C(n, i);
            sb.append(coef).append("*x**").append(i);
            if (i > 0) sb.append(" + ");
        }
        System.out.println(sb.toString());
    }
}
