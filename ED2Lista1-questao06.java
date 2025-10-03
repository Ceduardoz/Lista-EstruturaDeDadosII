/**
** Função: Função recursiva String revertida
** Autor: Carlos Eduardo
** Data: 29/09/2025
** Observações:
*/

import java.util.*;

public class Main {
    static class Node {
        int value;
        Node next;
        Node(int v) { value = v; }
    }

    static Node append(Node head, int v) {
        if (head == null) return new Node(v);
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = new Node(v);
        return head;
    }

    static int countNodes(Node head) {
        if (head == null) return 0;
        return 1 + countNodes(head.next);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            head = append(head, v);
        }
        System.out.println(countNodes(head));
        sc.close();
    }
}

