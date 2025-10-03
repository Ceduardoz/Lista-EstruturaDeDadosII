/**
** Função: Função recursiva invertendo o array
** Autor: Carlos Eduardo
** Data: 28/09/2025
** Observações:
*/

import java.util.*;

public class InverterRecursivo {
    public static void inverter(int[] vetor) { inverter(vetor, 0, vetor.length - 1); }
    private static void inverter(int[] vetor, int inicio, int fim) {
        if (inicio >= fim) return;
        int temp = vetor[inicio]; 
        vetor[inicio] = vetor[fim]; 
        vetor[fim] = temp;
        inverter(vetor, inicio + 1, fim - 1);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int tamanho = entrada.nextInt();
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) vetor[i] = entrada.nextInt();
        inverter(vetor);
        for (int i = 0; i < tamanho; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(vetor[i]);
        }
        System.out.println();
        entrada.close();
    }
}
