import java.util.*;

public class Task1 {

    public static int[] findMaxDegreeMatrix(int[][] adjMatrix) {
        int n = adjMatrix.length;
        int maxDegree = 0;
        int maxDegreeVertex = 0;

        for (int i = 0; i < n; i++) {
            int currentDegree = 0;
            for (int j = 0; j < n; j++) {
                currentDegree += adjMatrix[i][j];
            }

            if (currentDegree > maxDegree) {
                maxDegree = currentDegree;
                maxDegreeVertex = i;
            }
        }

        return new int[] { maxDegree, maxDegreeVertex };
    }

    public static int[] findMaxDegreeList(List<List<Integer>> adjList) {
        int maxDegree = 0;
        int maxDegreeVertex = 0;

        for (int vertex = 0; vertex < adjList.size(); vertex++) {
            int currentDegree = adjList.get(vertex).size();

            if (currentDegree > maxDegree) {
                maxDegree = currentDegree;
                maxDegreeVertex = vertex;
            }
        }

        return new int[] { maxDegree, maxDegreeVertex };
    }

    public static void main(String[] args) {
    
        int[][] adjMatrix = {
            {0, 1, 1, 1, 0, 1, 0},
            {1, 0, 1, 1, 1, 1, 0},
            {1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 1, 1},
            {0, 1, 1, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 0, 1},
            {0, 0, 1, 1, 0, 1, 0}
        };

        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(Arrays.asList(1, 2, 3, 5));
        adjList.add(Arrays.asList(0, 2, 3, 4, 5));
        adjList.add(Arrays.asList(0, 1, 3, 4, 5, 6));
        adjList.add(Arrays.asList(0, 1, 2, 5, 6));
        adjList.add(Arrays.asList(1, 2, 5));
        adjList.add(Arrays.asList(0, 1, 2, 3, 4, 6));
        adjList.add(Arrays.asList(2, 3, 5));

        int[] matrixResult = findMaxDegreeMatrix(adjMatrix);
        int[] listResult = findMaxDegreeList(adjList);

        System.out.println("Matrix Implemented Max Degree: " + matrixResult[0] + ", Vertex: " + matrixResult[1]);
        System.out.println("List Implementation - Max Degree: " + listResult[0] + ", Vertex: " + listResult[1]);
    }
}
