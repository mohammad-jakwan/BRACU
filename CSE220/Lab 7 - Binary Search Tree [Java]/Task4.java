// Complete the addOfLeaves method
public class Task4 {

    //===================================TASK#4======================
    // This method takes only one parameter
    // it is root of the given tree
    // You can use extra helper private static methods as per need
    public static Integer mirrorSum( BSTNode root ){
                if (root == null){
                    return 0;
                }
                else{
                return helper(root.left, root.right);
                }
            }
        
            public static Integer helper(BSTNode left, BSTNode right) {
                if (left == null || right == null) {
                    return 0;
                }
                
                int add = left.elem + right.elem;
                
                add += helper(left.left, right.right);
                add += helper(left.right, right.left);
                
                return add;
            }
            //===============================================================
        


}
