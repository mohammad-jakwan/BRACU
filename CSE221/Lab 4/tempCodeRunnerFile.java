import java.util.*;
public class TaskD {
 public static int[] Through_the_jungle(List<List<Integer>> graph, int N, int Source, int Destination, List<Integer> path) {
int[] visited = new int[N + 1]; int[] parent = new int[N + 1];
int[] distance = new int[N + 1];
 queue Que = new queue();
Que.enqueue(Source); visited[Source] = 1;
 while (Que.elements()) { int u = Que.dequeue(); for (int i : graph.get(u)) {
if (visited[i] == 0) {
 visited[i] = 1;distance[i] = distance[u] + 1;parent[i] = u;
Que.enqueue(i); }}}   
 if (Source == Destination) {
 path.add(Destination);
  return new int[]{0}; }
if (distance[Destination] == 0) return new int[]{-1};
 int enter = Destination;  while (true) {
path.add(enter);if (enter == Source) break;
enter = parent[enter]; }
Collections.reverse(path); return new int[]{distance[Destination]};}
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
int N = sc.nextInt(); int Edge = sc.nextInt();
 int Source = sc.nextInt(); int Destination = sc.nextInt();int mid = sc.nextInt();
 List<List<Integer>> graph = new ArrayList<>();
 for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
for (int i = 0; i < Edge; i++) {
  int x = sc.nextInt();
 int y = sc.nextInt();
 graph.get(x).add(y); }
 for (int j = 0; j <= N; j++) Collections.sort(graph.get(j));
 List<Integer> first_path = new ArrayList<>();
  List<Integer> second_path = new ArrayList<>();
 int[] first_dist = Through_the_jungle(graph, N, Source, mid, first_path);
int[] second_dist = Through_the_jungle(graph, N, mid, Destination, second_path);
 if (first_dist[0] == -1 || second_dist[0] == -1) {System.out.println(-1); } else {
System.out.println(first_dist[0] + second_dist[0]);
for (int i = 0; i < first_path.size(); i++) System.out.print(first_path.get(i) + " ");
 for (int i = 1; i < second_path.size(); i++) System.out.print(second_path.get(i) + " "); }}
class Node {
 int value;
 Node next;
Node(int value) {this.value = value;
this.next = null; }}
 class queue {
 Node head, tail;
queue() {
head = tail = null; }
void enqueue(int value) {
 Node new_node = new Node(value);
 if (head == null) {head = tail = new_node; } else {
tail.next = new_node;
tail = new_node; }}
 int dequeue() {
 if (head == null) return -1;
int removed_value = head.value;
 head = head.next;
 if (head == null) tail = null;
return removed_value; }
boolean elements() {
 return head != null;  }}
}