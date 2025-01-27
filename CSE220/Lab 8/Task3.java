import java.util.*;

class DirectedGraph {
    private int numVertices;
    private int maxEdges;
    private int[][] matrix;
    private int[][] outNeighbors;
    private int[][] weights;
    private int[] outEdgeCounts;

    public DirectedGraph(int numVertices, int maxEdges) {
        this.numVertices = numVertices;
        this.maxEdges = maxEdges;
        this.matrix = new int[numVertices][numVertices];
        this.outNeighbors = new int[numVertices][maxEdges];
        this.weights = new int[numVertices][maxEdges];
        this.outEdgeCounts = new int[numVertices];

        for (int[] row : outNeighbors) {
            Arrays.fill(row, -1);
        }

        for (int[] row : weights) {
            Arrays.fill(row, -1);
        }
    }

    public void addEdge(int fromVertex, int toVertex, int weight) {
        matrix[fromVertex][toVertex] = weight;

        int idx = outEdgeCounts[fromVertex];
        if (idx < maxEdges) {
            outNeighbors[fromVertex][idx] = toVertex;
            weights[fromVertex][idx] = weight;
            outEdgeCounts[fromVertex]++;
        }
    }

    public int[] findMaxOutDegreeMatrix() {
        int maxDegree = 0;
        int maxVertex = 0;

        for (int vertex = 0; vertex < numVertices; vertex++) {
            int degree = 0;
            for (int j = 0; j < numVertices; j++) {
                if (matrix[vertex][j] != 0) {
                    degree++;
                }
            }
            if (degree > maxDegree) {
                maxDegree = degree;
                maxVertex = vertex;
            }
        }

        return new int[] { maxVertex, maxDegree };
    }

    public int[] findMaxOutDegreeArrays() {
        int maxDegree = 0;
        int maxVertex = 0;

        for (int vertex = 0; vertex < numVertices; vertex++) {
            int degree = outEdgeCounts[vertex];
            if (degree > maxDegree) {
                maxDegree = degree;
                maxVertex = vertex;
            }
        }

        return new int[] { maxVertex, maxDegree };
    }

    public int[] maxWeightSumMatrix() {
        int maxSum = 0;
        int maxVertex = 0;

        for (int vertex = 0; vertex < numVertices; vertex++) {
            int currentSum = 0;
            for (int j = 0; j < numVertices; j++) {
                currentSum += matrix[vertex][j];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxVertex = vertex;
            }
        }

        return new int[] { maxVertex, maxSum };
    }

    public int[] maxWeightedSumOfArrays() {
        int maxSum = 0;
        int maxVertex = 0;

        for (int vertex = 0; vertex < numVertices; vertex++) {
            int currentSum = 0;
            for (int i = 0; i < outEdgeCounts[vertex]; i++) {
                currentSum += weights[vertex][i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxVertex = vertex;
            }
        }

        return new int[] { maxVertex, maxSum };
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(7, 6);

        int[][] edges = {
            {0, 1, 5}, {0, 2, 4}, {0, 3, 3}, {0, 5, 6},
            {1, 2, 2}, {1, 3, 6}, {1, 4, 3}, {1, 5, 3},
            {2, 3, 4}, {2, 4, 5}, {2, 5, 4}, {2, 6, 3},
            {3, 5, 5}, {3, 6, 4}, {4, 5, 2}, {5, 6, 3}
        };

        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1], edge[2]);
        }

        int[] matrixDegree = graph.findMaxOutDegreeMatrix();
        int[] arrayDegree = graph.findMaxOutDegreeArrays();
        System.out.println("Task 1 - Maximum Out-degree:");
        System.out.println("Matrix: Vertex " + matrixDegree[0] + " has max out-degree of " + matrixDegree[1] + ".");
        System.out.println("Arrays: Vertex " + arrayDegree[0] + " has max out-degree of " + arrayDegree[1] + ".");

        int[] matrixWeight = graph.maxWeightSumMatrix();
        int[] arrayWeight = graph.maxWeightedSumOfArrays();
        System.out.println("\nTask 2 - Maximum Outgoing Weight Sum:");
        System.out.println("Matrix: Vertex " + matrixWeight[0] + " has max weight sum of " + matrixWeight[1] + ".");
        System.out.println("Arrays: Vertex " + arrayWeight[0] + " has max weight sum of " + arrayWeight[1] + ".");
    }
}
