import java.util.*;
 public class TaskF {
static List<List<Integer>> graph;
static int[] visited;
static String DFS(List<List<Integer>> graph, int node, int[] visited) {
 visited[node] = 1;
String get = "NO";
for (int i : graph.get(node)) {
 if (visited[i] == 0) {
  get = DFS(graph, i, visited);
 if (get.equals("YES")) break;
} else if (visited[i] == 1) { return "YES";
 }}    visited[node] = 2;
 return get; }
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 int N = sc.nextInt();
 int M = sc.nextInt();
graph = new ArrayList<>();
for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
 for (int j = 0; j < M; j++) {
 int x = sc.nextInt();
 int y = sc.nextInt();
graph.get(x).add(y);}
 for (List<Integer> neighbors : graph) Collections.sort(neighbors);
 visited = new int[N + 1];
String get = "NO";
for (int i = 1; i <= N; i++) {
 get = DFS(graph, i, visited);
  if (get.equals("YES")) break; }
System.out.println(get); }}