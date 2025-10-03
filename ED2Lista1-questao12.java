/**
** Função: Função recursiva estruturas aninhadas
** Autor: Carlos Eduardo
** Data: 01/10/2025
** Observações:
*/

import java.util.*;

class Passageiro {
    String nome, cpf, telefone;
    Passageiro(String nome, String cpf, String telefone) {
        this.nome = nome; this.cpf = cpf; this.telefone = telefone;
    }
}

class ListaPassageiros {
    private static class Node {
        Passageiro p; Node next;
        Node(Passageiro p) { this.p = p; }
    }
    private Node head;

    void adicionarUltimo(Passageiro p) {
        Node n = new Node(p);
        if (head == null) { head = n; return; }
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = n;
    }

    boolean removerPorCpf(String cpf) {
        Node prev = null, cur = head;
        while (cur != null) {
            if (cur.p.cpf.equals(cpf)) {
                if (prev == null) head = cur.next; else prev.next = cur.next;
                return true;
            }
            prev = cur; cur = cur.next;
        }
        return false;
    }

    int tamanho() {
        int c = 0; Node cur = head;
        while (cur != null) { c++; cur = cur.next; }
        return c;
    }

    Passageiro retirarPrimeiro() {
        if (head == null) return null;
        Passageiro p = head.p;
        head = head.next;
        return p;
    }

    void imprimir() {
        Node cur = head;
        if (cur == null) { System.out.println("    <sem passageiros>"); return; }
        while (cur != null) {
            System.out.printf("    - %s (CPF %s, Tel %s)%n", cur.p.nome, cur.p.cpf, cur.p.telefone);
            cur = cur.next;
        }
    }
}

class FilaEspera {
    private static class Node {
        Passageiro p; Node next;
        Node(Passageiro p) { this.p = p; }
    }

    private final Node[] head = new Node[6];
    private final Node[] tail = new Node[6];

    private int clamp(int prioridade) { return Math.min(5, Math.max(1, prioridade)); }

    void enfileirar(Passageiro p, int prioridade) {
        int pr = clamp(prioridade);
        Node n = new Node(p);
        if (head[pr] == null) head[pr] = tail[pr] = n;
        else { tail[pr].next = n; tail[pr] = n; }
    }

    Passageiro desenfileirar() {
        for (int pr = 1; pr <= 5; pr++) {
            if (head[pr] != null) {
                Passageiro p = head[pr].p;
                head[pr] = head[pr].next;
                if (head[pr] == null) tail[pr] = null;
                return p;
            }
        }
        return null;
    }

    boolean removerPorCpf(String cpf) {
        for (int pr = 1; pr <= 5; pr++) {
            Node prev = null, cur = head[pr];
            while (cur != null) {
                if (cur.p.cpf.equals(cpf)) {
                    if (prev == null) head[pr] = cur.next; else prev.next = cur.next;
                    if (head[pr] == null) tail[pr] = null;
                    return true;
                }
                prev = cur; cur = cur.next;
            }
        }
        return false;
    }

    void imprimir() {
        for (int pr = 1; pr <= 5; pr++) {
            System.out.printf("  Prioridade %d:%n", pr);
            Node cur = head[pr];
            if (cur == null) System.out.println("    <vazia>");
            while (cur != null) {
                System.out.printf("    - %s (CPF %s)%n", cur.p.nome, cur.p.cpf);
                cur = cur.next;
            }
        }
    }
}

class Voo {
    String numero, destino, aeronave;
    int assentosTotais, assentosRestantes;
    ListaPassageiros passageiros = new ListaPassageiros();
    FilaEspera filaEspera = new FilaEspera();

    Voo(String numero, String destino, String aeronave, int assentosTotais) {
        this.numero = numero; this.destino = destino; this.aeronave = aeronave;
        this.assentosTotais = assentosTotais; this.assentosRestantes = assentosTotais;
    }

    void reservar(Passageiro p, int prioridade) {
        if (assentosRestantes > 0) {
            passageiros.adicionarUltimo(p);
            assentosRestantes--;
        } else {
            filaEspera.enfileirar(p, prioridade);
        }
    }

    boolean cancelar(String cpf) {
        if (passageiros.removerPorCpf(cpf)) {
            assentosRestantes++;
            Passageiro promovido = filaEspera.desenfileirar();
            if (promovido != null) {
                passageiros.adicionarUltimo(promovido);
                assentosRestantes--;
            }
            return true;
        } else if (filaEspera.removerPorCpf(cpf)) {
            return true;
        }
        return false;
    }

    void imprimir() {
        System.out.printf("Voo %s -> %s (%s)%n", numero, destino, aeronave);
        System.out.printf("  Assentos: %d/%d%n", passageiros.tamanho(), assentosTotais);
        System.out.println(" Passageiros:");
        passageiros.imprimir();
        System.out.println(" Fila de espera:");
        filaEspera.imprimir();
        System.out.println();
    }
}

class ListaVoos {
    private static class Node {
        Voo v; Node next;
        Node(Voo v) { this.v = v; }
    }
    private Node head;

    void adicionarUltimo(Voo v) {
        Node n = new Node(v);
        if (head == null) { head = n; return; }
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = n;
    }

    Voo buscarPorNumero(String numero) {
        Node cur = head;
        while (cur != null) {
            if (cur.v.numero.equals(numero)) return cur.v;
            cur = cur.next;
        }
        return null;
    }

    void imprimir() {
        Node cur = head;
        while (cur != null) { cur.v.imprimir(); cur = cur.next; }
    }
}

public class Main {
    public static void main(String[] args) {
        ListaVoos voos = new ListaVoos();

        Voo v1 = new Voo("AA101", "São Paulo", "Boeing 737", 2);
        Voo v2 = new Voo("BB202", "Rio de Janeiro", "Airbus A320", 3);
        voos.adicionarUltimo(v1);
        voos.adicionarUltimo(v2);

        v1.reservar(new Passageiro("Ana", "111", "9999"), 2);
        v1.reservar(new Passageiro("Bruno", "222", "8888"), 1);
        v1.reservar(new Passageiro("Carlos", "333", "7777"), 3);

        v2.reservar(new Passageiro("Daniel", "444", "6666"), 2);
        v2.reservar(new Passageiro("Elisa", "555", "5555"), 4);

        v1.cancelar("222");

        voos.imprimir();
    }
}
