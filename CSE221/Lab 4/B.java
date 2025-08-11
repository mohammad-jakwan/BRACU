import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] node = new int[m];
        for (int i = 0; i < m; i++) node[i] = sc.nextInt();
        int[] begin = new int[m];
        for (int i = 0; i < m; i++) begin[i] = sc.nextInt();
        int[] end = new int[m];
        for (int i = 0; i < m; i++) end[i] = sc.nextInt();

        Node[] graph = new Node[n];
        for (int i = 0; i < m; i++) {
            int idx = node[i] - 1;
            if (graph[idx] == null) {
                graph[idx] = new Node(begin[i], end[i]);
            } else {
                Node curr = graph[idx];
                while (curr.next != null) curr = curr.next;
                curr.next = new Node(begin[i], end[i]);
            }
        }

        for (int k = 0; k < graph.length; k++) {
            if (graph[k] == null) {
                System.out.println((k + 1) + ":");
            } else if (graph[k].next == null) {
                System.out.println((k + 1) + ": (" + graph[k].begin + ", " + graph[k].end + ")");
            } else {
                System.out.print((k + 1) + ": ");
                Node temp = graph[k];
                while (temp.next != null) {
                    System.out.print("(" + temp.begin + ", " + temp.end + ") ");
                    temp = temp.next;
                }
                System.out.println("(" + temp.begin + ", " + temp.end + ")");
            }
        }

    }
}
class Node {
    int begin, end;
    Node next;

    Node(int begin, int end) {
        this.begin = begin;
        this.end = end;
        this.next = null;
    }
}

