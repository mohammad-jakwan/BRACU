// Complete the sumOfLeaves method
public class Task2 {

    //===================================TASK#2===================================
    // This method takes only 2 parameters
    // 1st one is root
    // 2nd one is an Integer
    // You'll need to find the path from the root to a node containing the Integer
    // return the path as a String
    public static String findPath( BSTNode root, Integer key ){
        StringBuilder path = new StringBuilder();
        boolean found = findPathHelper(root, key, path);
        
        if (found) {
            return path.toString().trim(); // remove trailing space
        } else {
            return "No Path Found";
        }
    }
    
    private static boolean findPathHelper(BSTNode node, Integer key, StringBuilder path) {
        if (node == null) {
            return false;
        }
        
        path.append(node.elem).append(" ");
        
        // If current node matches the key
        if (node.elem.equals(key)) {
            return true;
        }
        
        // Search in left or right subtree
        if (key < node.elem) {
            if (findPathHelper(node.left, key, path)) {
                return true;
            }
        } else {
            if (findPathHelper(node.right, key, path)) {
                return true;
            }
        }
        
        // If not found in this path, backtrack
        int lastSpaceIndex = path.lastIndexOf(" ", path.length() - 2);
        path.delete(lastSpaceIndex + 1, path.length());
        
        return false;
    }
    
    //============================================================================

}
