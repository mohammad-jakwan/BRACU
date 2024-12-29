import java.util.*;

class DirectedGraph {
    private int numVertices;
    private int[][] matrix;
    private List<List<int[]>> adjList;

    public DirectedGraph(int numVertices) {
        this.numVertices = numVertices;
        this.matrix = new int[numVertices][numVertices];
        this.adjList = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int fromVertex, int toVertex, int weight) {
        matrix[fromVertex][toVertex] = weight;
        adjList.get(fromVertex).add(new int[] { toVertex, weight });
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public List<List<int[]>> getAdjList() {
        return adjList;
    }
}

class UndirectedGraph {
    private int numVertices;
    private int[][] matrix;
    private List<List<int[]>> adjList;

    public UndirectedGraph(int numVertices) {
        this.numVertices = numVertices;
        this.matrix = new int[numVertices][numVertices];
        this.adjList = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void convertFromDirected(DirectedGraph directedGraph) {
        int[][] directedMatrix = directedGraph.getMatrix();
        List<List<int[]>> directedList = directedGraph.getAdjList();

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (directedMatrix[i][j] != 0) {
                    matrix[i][j] = directedMatrix[i][j];
                    matrix[j][i] = directedMatrix[i][j];
                }
            }
        }

        for (int u = 0; u < numVertices; u++) {
            for (int[] edge : directedList.get(u)) {
                int v = edge[0];
                int weight = edge[1];
                addEdgeToList(u, v, weight);
                addEdgeToList(v, u, weight);
            }
        }
    }

    private void addEdgeToList(int vertex, int neighbor, int weight) {
        adjList.get(vertex).add(new int[] { neighbor, weight });
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public List<List<int[]>> getAdjList() {
        return adjList;
    }

    public void printMatrix() {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void printAdjList() {
        for (int vertex = 0; vertex < adjList.size(); vertex++) {
            System.out.print("Vertex " + vertex + ": ");
            for (int[] edge : adjList.get(vertex)) {
                System.out.print("(" + edge[0] + ", " + edge[1] + ") ");
            }
            System.out.println();
        }
    }
}

public class Task4 {
    public static void main(String[] args) {
        int numVertices = 7;
        DirectedGraph directedGraph = new DirectedGraph(numVertices);

        int[][] directedEdges = {
            {0, 1, 5}, {0, 2, 3}, {0, 3, 6}, {1, 4, 4},
            {1, 5, 2}, {2, 5, 8}, {2, 6, 7}, {3, 4, 3},
            {3, 6, 2}, {4, 5, 6}, {4, 6, 5}, {5, 6, 4},
            {5, 3, 1}, {6, 0, 7}, {1, 3, 3}, {2, 4, 2}
        };

        for (int[] edge : directedEdges) {
            directedGraph.addEdge(edge[0], edge[1], edge[2]);
        }

        UndirectedGraph undirectedGraph = new UndirectedGraph(numVertices);
        undirectedGraph.convertFromDirected(directedGraph);

        System.out.println("Adjacency Matrix of Undirected Graph:");
        undirectedGraph.printMatrix();

        System.out.println("\nAdjacency List of Undirected Graph:");
        undirectedGraph.printAdjList();
    }
}
