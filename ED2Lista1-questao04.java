/**
** Função: Função recursiva resto da divisão
** Autor: Carlos Eduardo
** Data: 28/09/2025
** Observações:
*/

import java.util.*;

public class ModuloRec {
    public static int modulo(int x, int y) {
        if (x <= 0 || y <= 0) throw new IllegalArgumentException("x e y devem ser inteiros positivos");
        if (x == y) return 0;
        if (x < y) return x;
        return modulo(x - y, y);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int x = entrada.nextInt();
        int y = entrada.nextInt();
        System.out.println(modulo(x, y));
        entrada.close();
    }
}
