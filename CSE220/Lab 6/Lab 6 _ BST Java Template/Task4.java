// Complete the sumOfLeaves method
public class Task4 {

    //===================================TASK#4======================
    // This method takes only 2 parameters
    // 1st one is root of the given tree
    // 2nd one is the Node of which you need to find the predecessor
    // This method returns the predecessor's Node
    // You can use extra helper private static methods as per need
    public static BSTNode inOrderPredecessor( BSTNode root, BSTNode x ){
        BSTNode predecessor = null;
        while (root != null) {
            if (x.elem <= root.elem) {
                root = root.left;
            } else {
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }
    //===============================================================


}
