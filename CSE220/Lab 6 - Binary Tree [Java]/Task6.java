// Complete the levelSum method
public class Task6 {

    //===================================TASK#6===================================
    // This method takes only 1 parameter which is root of the given tree
    // This method returns an Integer
    // At times you may need to typeCast root.elem to Integer
    // You can use extra helper private static methods with extra extra params as per need
    public static Integer levelSum( BTNode root ){
        return sum (root, 0); 
    }

    private static int sum (BTNode node, int level) {
        if (node == null){
             return 0;
        }
        else{
        int value = (Integer) node.elem;
        int addorsub;
        if (level % 2 != 0){
            addorsub = 1;
        } 
        else{
            addorsub = -1; 
        }

        int l = sum (node.left, level + 1);
        int r = sum (node.right, level + 1);

        int current = addorsub * value;
        int total = current + l + r;

        return total;
    
        }
    }

}