import java.util.*;
 public class TaskA {
 static List<List<Integer>> graph;
 static boolean[] visited;
 static List<Integer> arr;
static List<Integer> bfsOfGraph(List<List<Integer>> graph, int s, boolean[] visited, List<Integer> arr) {  Queue<Integer> q = new LinkedList<>();
 visited[s] = true;
 q.add(s);
 while (!q.isEmpty()) {
  int curr = q.poll();
  arr.add(curr);
   List<Integer> neighbors = new ArrayList<>(graph.get(curr));
    Collections.sort(neighbors);
    for (int x : neighbors) {
    if (!visited[x]) {
     visited[x] = true;
     q.add(x);  }}}
      return arr; }
     public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int N = sc.nextInt();
     int M = sc.nextInt();
     graph = new ArrayList<>();
     for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
     for (int i = 0; i < M; i++) {
     int u = sc.nextInt();
     int v = sc.nextInt();
     graph.get(u).add(v);
     graph.get(v).add(u); }
      visited = new boolean[N + 1];
      arr = new ArrayList<>();
      bfsOfGraph(graph, 1, visited, arr);
      for (int i = 0; i < arr.size(); i++) {
      System.out.print(arr.get(i));
       if (i < arr.size() - 1) System.out.print(" ");
       }}}