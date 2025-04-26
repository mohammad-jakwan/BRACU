// Complete the subtractSummation method
public class Task5 {

    //===================================TASK#5===================================
    // This method takes only 1 parameter which is root of the given tree
    // This method returns an Integer
    // At times you may need to typeCast root.elem to Integer
    // You can use extra helper private static methods with extra extra params as per need
    public static Integer subtractSummation( BTNode root ){
        if (root == null) return 0;
        int lsum = sum(root.left);
        int rsum = sum(root.right);

        return lsum - rsum;
    }

    public static int sum(BTNode node) {
        if (node == null){
             return 0;
        }

        int val = (Integer) node.elem;
        int l = sum(node.left);
        int r = sum(node.right);
        return val + l + r;
    }
    

}