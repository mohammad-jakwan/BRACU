//Task 01: Zigzag Walk
class Task1{

    //Complete this method so that it gives the Expected Output
    public static void walkZigzag( Integer[][] matrix ){

        int rows = matrix.length;
        int cols = matrix[0].length;
    
        // Traverse through each diagonal
        for (int diagonal = 0; diagonal < rows + cols - 1; diagonal++) {
            if (diagonal % 2 == 0) { // Even diagonal: Top-right to bottom-left
                int row = Math.min(diagonal, rows - 1);
                int col = diagonal - row;
    
                while (row >= 0 && col < cols) {
                    System.out.print(matrix[row][col] + " ");
                    row--;
                    col++;
                }
            } else { 
                int col = Math.min(diagonal, cols - 1);
                int row = diagonal - col;

            }
            System.out.println(); // New line after processing each diagonal
        }
    }           

    

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] floor1 = {
            {3 , 8 , 4 , 6 , 1},
            {7 , 2 , 1 , 9 , 3},
            {9 , 0 , 7 , 5 , 8},
            {2 , 1 , 3 , 4 , 0},
            {1 , 4 , 2 , 8 , 6}
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(floor1);
        System.out.println("\nExpected Output:");
        System.out.print("3 9 1\n1 2\n4 7 2\n4 9\n1 8 6\n");
        System.out.print("\nYour Output:\n");
        walkZigzag( floor1 );

        System.out.print("\n======================\n");

        Integer[][] floor2 = {
            {3 , 8 , 4 , 6 , 1},
            {7 , 2 , 1 , 9 , 3},
            {9 , 0 , 7 , 5 , 8},
            {2 , 1 , 3 , 4 , 0},
        };
        System.out.println("\nGiven Matrix: ");
        Arr.print2D(floor2);
        System.out.println("\nExpected Output:");
        System.out.print("3 9\n1 2\n4 7\n4 9\n1 8\n");
        System.out.print("\nYour Output:\n");
        walkZigzag( floor2 );

    }
}