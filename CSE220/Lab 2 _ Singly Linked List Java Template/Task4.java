// Task04: Word Decoder
public class Task4 {

    public static Node wordDecoder( Node head ){
        int count = 0;
        Node current = head;
        while (current != null){
            count++;
            current = current.next;
        }  
        int step = 13 % count;
        Node empty = new Node(null); 
        Node tail = empty;          
        current = head;
        int idx = 0;

        while (current != null){
           if (idx % step == 0){ 
              Node newNode = new Node(current.elem);
              newNode.next = tail.next;             
              tail.next = newNode;
            }
            idx++;
            current = current.next;
        }
        return empty.next;
      }

    //NOTE: if you find any issue with the driver code please inform AIB
    //DO NOT TOUCH THE DRIVER CODE BELOW
    public static void main(String[] args){
        System.out.println("==============Test Case 1=============");
        Node head = LinkedList.createList(new Character[]{'B', 'M', 'D', 'T', 'N', 'O', 'A', 'P', 'S', 'C'});
        System.out.print("Encoded Word: ");
        LinkedList.printLL(head);
        System.out.println("\nExpected output: null -> C -> A -> T");
        Node result = wordDecoder(head);
        System.out.println( "Your output: ");
        LinkedList.printLL(result); //This should print null -> C -> A -> T
        System.out.println();
        System.out.println("==============Test Case 2=============");
        head = LinkedList.createList(new Character[]{'Z', 'O', 'T', 'N', 'X'});
        System.out.print("Encoded Word: ");
        LinkedList.printLL(head);
        System.out.println("\nExpected output: null -> N");
        result = wordDecoder(head);
        System.out.println( "Your output: ");
        LinkedList.printLL(result); //This should print null -> N
        System.out.println();
    }
}
