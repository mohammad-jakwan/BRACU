public class Task6 {
    public static int sumDist(Node head, int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            int distance = arr[i];
            Node current = head;  

         for (int j = 0; j < distance && current != null; j++){
             current = current.next;
            }

       if (current != null){
            sum += (Integer) current.elem;
        }
        }

        return sum; 
    }

 

    public static void main(String[] args) {
        System.out.println("=========Test Case 1=============");
        Node head1 = LinkedList.createList(new Integer[]{10, 16, -5, 9, 3, 4});
        int[] dist = new int[] {2, 0, 5, 2, 8};
        int returnedValue = Task6.sumDist(head1, dist);
        System.out.println("Sum of Nodes: "+returnedValue); // This should print: Sum of Nodes: 4
    }
}
