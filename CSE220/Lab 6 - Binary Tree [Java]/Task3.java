// Complete the sumTree method
public class Task3 {

        //===================================TASK#3===================================
        // This method takes only 1 parameter which is root of the given tree
        // This method returns an Integer
        // At times you may need to typeCast root.elem to Integer
        // You can use extra helper private static methods as per need
        static int sum = 0 ;
        public static Integer sumTree( BTNode root ){
            sum = 0; 
            cal (root,0);
            return sum; 
        }
        public static void cal(BTNode node, int level) {
            if (node == null) {
                return;
            }
            else{
            int val = (Integer) node.elem;
            if (level == 0) {
                sum += val;
            } 
            else{
                sum += val % level;
            }
    
            cal(node.left, level + 1);
            cal(node.right, level + 1);
        }
    }
        //============================================================================

}
