class Task3 {

    // Complete this method so that it gives the Expected Output
    public static Integer[] decryptMatrix(Integer[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: Calculate the column-wise summations
        Integer[] columnSums = new Integer[cols];
        for (int j = 0; j < cols; j++) {
            columnSums[j] = 0; // Initialize sum for each column
            for (int i = 0; i < rows; i++) {
                columnSums[j] += matrix[i][j]; // Add values in the column
            }
        }

        // Step 2: Calculate the difference of subsequent column sums
        Integer[] result = new Integer[cols - 1];
        for (int j = 0; j < cols - 1; j++) {
            result[j] = columnSums[j + 1] - columnSums[j];
        }

        return result;
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        Integer[][] matrix = {
            {1, 3, 1},
            {6, 4, 2},
            {5, 1, 7},
            {9, 3, 3},
            {8, 5, 4}
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(matrix);
        System.out.println("\nExpected Output:\n[ -13 1 ]");
        Integer[] returned_val_1 = decryptMatrix(matrix);
        System.out.print("\nYour Output:\n");
        Arr.print(returned_val_1);
    }
}
