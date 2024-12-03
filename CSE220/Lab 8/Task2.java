import java.util.*;

class WeightedGraph {
    private int numVertices;
    private int maxEdges;
    private int[][] matrix;
    private int[][] neighbors;
    private int[][] weights;
    private int[] edgeCounts;

    public WeightedGraph(int numVertices, int maxEdges) {
        this.numVertices = numVertices;
        this.maxEdges = maxEdges;
        this.matrix = new int[numVertices][numVertices];
        this.neighbors = new int[numVertices][maxEdges];
        this.weights = new int[numVertices][maxEdges];
        this.edgeCounts = new int[numVertices];

        for (int[] row : neighbors) {
            Arrays.fill(row, -1);
        }

        for (int[] row : weights) {
            Arrays.fill(row, -1);
        }
    }

    public void addEdge(int vertex1, int vertex2, int weight) {
        matrix[vertex1][vertex2] = weight;
        matrix[vertex2][vertex1] = weight;

        int index1 = edgeCounts[vertex1];
        if (index1 < maxEdges) {
            neighbors[vertex1][index1] = vertex2;
            weights[vertex1][index1] = weight;
            edgeCounts[vertex1]++;
        }

        int index2 = edgeCounts[vertex2];
        if (index2 < maxEdges) {
            neighbors[vertex2][index2] = vertex1;
            weights[vertex2][index2] = weight;
            edgeCounts[vertex2]++;
        }
    }

    public int[] maxWeightedSumUsingMatrix() {
        int maxSum = 0;
        int maxVertex = 0;

        for (int vertex = 0; vertex < numVertices; vertex++) {
            int currentSum = 0;
            for (int weight : matrix[vertex]) {
                currentSum += weight;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxVertex = vertex;
            }
        }

        return new int[] { maxVertex, maxSum };
    }

    public int[] maxWeightedSumUsingArrays() {
        int maxSum = 0;
        int maxVertex = 0;

        for (int vertex = 0; vertex < numVertices; vertex++) {
            int currentSum = 0;
            for (int i = 0; i < edgeCounts[vertex]; i++) {
                if (weights[vertex][i] != -1) {
                    currentSum += weights[vertex][i];
                }
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxVertex = vertex;
            }
        }

        return new int[] { maxVertex, maxSum };
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(7, 6);

        int[][] edges = {
            {0, 1, 5}, {0, 2, 4}, {0, 3, 3}, {0, 5, 6},
            {1, 2, 2}, {1, 3, 6}, {1, 4, 3}, {1, 5, 3},
            {2, 3, 4}, {2, 4, 5}, {2, 5, 4}, {2, 6, 3},
            {3, 5, 5}, {3, 6, 4}, {4, 5, 2}, {5, 6, 3}
        };

        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1], edge[2]);
        }

        int[] matrixResult = graph.maxWeightedSumUsingMatrix();
        int[] arrayResult = graph.maxWeightedSumUsingArrays();

        System.out.println("Using adjacency matrix:");
        System.out.println("Vertex -> [" + matrixResult[0] + "] has the highest weight; And sum of that vertex is " + matrixResult[1] + ".");

        System.out.println("\nUsing arrays:");
        System.out.println("Vertex -> [" + arrayResult[0] + "] has the highest weight; And sum of that vertex is " + arrayResult[1] + ".");
    }
}

    
