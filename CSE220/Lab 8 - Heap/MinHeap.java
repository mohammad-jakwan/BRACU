//Task 1

public class MinHeap {

    private int[] heap;
    private int size;

    public MinHeap(int cap){
        heap = new int[cap];
        size = 0;
    }

    public void insert(int val){
        if (size == heap.length){
            System.out.println("Heap is full");
            return;
        }
        heap[size] = val;
        swim(size);
        size++;
    }

    private void swim(int idx) {
        while (idx > 0 && heap[idx] < heap[(idx - 1) / 2]) {
            int parent = (idx - 1) / 2;
            swap(idx, parent);
            idx = parent;
        }
    }

    public int extractMin(){
        if (size == 0){
            System.out.println("Heap is empty");
        }
        int min = heap[0];
        heap[0] = heap[--size];
        sink(0);
        return min;
    }

    private void sink(int idx) {
        while (2 * idx + 1 < size) {
            int leftChild = 2 * idx + 1;
            int rightChild = leftChild + 1;
            int smallest = leftChild;

            if (rightChild < size && heap[rightChild] < heap[leftChild]) {
                smallest = rightChild;
            }

            if (heap[idx] <= heap[smallest]) {
                break;
            }
            swap(idx, smallest);
            idx = smallest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void sort() {
        int length = size;
        for (int i = size - 1; i > 0; i--) {
            swap(0, i);
            size--;
            sink(0);
        }
        size = length;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(4);
        minHeap.printHeap();
        minHeap.sort();
        minHeap.printHeap();
    }
}