/**
** Função: Função recursiva Ocorrrencias de um número
** Autor: Carlos Eduardo
** Data: 28/09/2025
** Observações:
*/

import java.util.*;

public class ContarDigitoRec {
    public static int contarDigito(long numero, int digito) {
        if (digito < 0 || digito > 9) throw new IllegalArgumentException("O dígito deve ser entre 0 e 9");
        if (numero < 0) numero = -numero;
        if (numero == 0) return (digito == 0) ? 1 : 0;
        return contarAuxiliar(numero, digito);
    }

    private static int contarAuxiliar(long numero, int digito) {
        if (numero == 0) return 0;
        int ultimo = (int)(numero % 10);
        return (ultimo == digito ? 1 : 0) + contarAuxiliar(numero / 10, digito);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        long numero = entrada.nextLong();
        int digito = entrada.nextInt();
        System.out.println(contarDigito(numero, digito));
        entrada.close();
    }
}
