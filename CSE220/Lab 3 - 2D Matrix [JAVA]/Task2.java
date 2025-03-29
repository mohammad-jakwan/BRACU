//Task 02: Decryption Process
class Task2{

    //Complete this method so that it gives the Expected Output
    public static Integer[] decryptMatrix( Integer[][] matrix ){
        int rows = matrix.length;
        int cols = matrix[0].length;
        Integer[] count = new Integer[cols];
        for (int i = 0; i < cols; i++){
            count[i] = 0;
            for (int j = 0; j < rows; j++){
                count[i] += matrix[j][i];
            }
        }
        Integer[] output = new Integer[cols - 1];
        for (int i = 0; i < cols - 1; i++) {
            output[i] = count[i + 1] - count[i];
        }
        return output;
    }

    

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] matrix = {
            {1,3,1},
            {6,4,2},
            {5,1,7},
            {9,3,3},
            {8,5,4}
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(matrix);
        System.out.println("\nExpected Output:\n[ -13 1 ]");
        Integer[] returned_val_1 = decryptMatrix( matrix );
        System.out.print("\nYour Output:\n");
        Arr.print(returned_val_1);

    }
}