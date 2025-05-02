public class Main {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.insert(6);

        System.out.print("Original Heap: ");
        minHeap.printHeap();

        minHeap.delete(3);  // Deletes value 3
        System.out.print("After deleting 3: ");
        minHeap.printHeap();

        minHeap.delete(10);  // Try to delete value not in heap
    }
}
