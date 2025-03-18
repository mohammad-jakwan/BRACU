public class Task3 {
    public static Node idGenerator(Node head1, Node head2, Node head3) {
   
         Node reversedHead1 = reverseList(head1);
         Node curr2 = head2;
         Node curr3 = head3;
         Node four = null;
         Node fourTail = null;
 
         while (curr2 != null && curr3 != null) {
             int sum = (Integer) curr2.elem + (Integer) curr3.elem;
             int digit = sum % 10; 
 
             Node newNode = new Node(digit);
             if (four == null) {
                 four = newNode;
                 fourTail = newNode;
             } else {
                 fourTail.next = newNode;
                 fourTail = newNode;
             }
 
             curr2 = curr2.next;
             curr3 = curr3.next;
         }
 
         
         Node curr = reversedHead1;
         while (curr.next != null) {
             curr = curr.next;
         }
         curr.next = four;
 
         return reversedHead1;
     }
 
     // Helper function to reverse a linked list
     private static Node reverseList(Node head) {
         Node prev = null;
         Node current = head;
         while (current != null) {
             Node nextNode = current.next;
             current.next = prev;
             prev = current;
             current = nextNode;
         }
         return prev;
     }
 
    

    //NOTE: if you find any issue with the driver code please inform AIB
    //DO NOT MAKE ANY MODIFICATIONS IN THE TESTER CODE BELOW
    public static void main(String[] args) {
        System.out.println("=========Test Case 1=============");
        Node head1 = LinkedList.createList(new Integer[]{0, 3, 2, 2});
        Node head2 = LinkedList.createList(new Integer[]{5, 2, 2, 1});
        Node head3 = LinkedList.createList(new Integer[]{4, 3, 2, 1});

        System.out.print("LinkedList#1:  ");
        LinkedList.printLL(head1); // This should print 0 -> 3 -> 2 -> 2

        System.out.print("LinkedList#2:  ");
        LinkedList.printLL(head2); // This should print 5 -> 2 -> 2 -> 1

        System.out.print("LinkedList#3:  ");
        LinkedList.printLL(head3); // This should print 4 -> 3 -> 2 -> 1

        Node result = Task3.idGenerator(head1, head2, head3);

        System.out.print("\nNew ID:  ");
        LinkedList.printLL(result); // This should print 2 -> 2 -> 3 -> 0 -> 9 -> 5 -> 4 -> 2

        System.out.println("\n=========Test Case 2=============");
        Node head4 = LinkedList.createList(new Integer[]{0, 3, 9, 1});
        Node head5 = LinkedList.createList(new Integer[]{3, 6, 5, 7});
        Node head6 = LinkedList.createList(new Integer[]{2, 4, 3, 8});

        System.out.print("LinkedList#4:  ");
        LinkedList.printLL(head4); // This should print 0 -> 3 -> 9 -> 1

        System.out.print("LinkedList#5:  ");
        LinkedList.printLL(head5); // This should print 3 -> 6 -> 5 -> 7

        System.out.print("LinkedList#6:  ");
        LinkedList.printLL(head6); // This should print 2 -> 4 -> 3 -> 8

        Node result2 = Task3.idGenerator(head4, head5, head6);

        System.out.print("\nNew ID:  ");
        LinkedList.printLL(result2); // This should print 1 -> 9 -> 3 -> 0 -> 5 -> 0 -> 8 -> 5
    }
}
