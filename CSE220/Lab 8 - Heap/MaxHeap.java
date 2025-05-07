// Task 2

public class MaxHeap {

    private int[] heap;
    private int size;

    public MaxHeap(int cap){
        heap = new int[cap];
        size = 0;
    }

    public void insert(int val){
        if (size == heap.length) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = val;
        swim(size);
        size++;
    }

    private void swim(int idx){
        while (idx > 0 && heap[idx] > heap[(idx - 1) / 2]) {
            int parent = (idx - 1) / 2;
            swap(idx, parent);
            idx = parent;
        }
    }

    public int extractMax() {
        if (size == 0) {
            System.out.println("Heap is empty");
        }
        int max = heap[0];
        heap[0] = heap[--size];
        sink(0);
        return max;
    }

    private void sink(int idx){
        while (2 * idx + 1 < size) {
            int leftChild = 2 * idx + 1;
            int rightChild = leftChild + 1;
            int largest = leftChild;

            if (rightChild < size && heap[rightChild] > heap[leftChild]) {
                largest = rightChild;
            }

            if (heap[idx] >= heap[largest]){
                break;
            }
            swap(idx, largest);
            idx = largest;
        }
    }

    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void sort() {
        int originalSize = size;
        for (int i = size - 1; i > 0; i--){
            swap(0, i);
            size--;
            sink(0);
        }
        size = originalSize;
    }

    public void printHeap(){
        for (int i = 0; i < size; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(3);
        maxHeap.insert(1);
        maxHeap.insert(6);
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(4);
        maxHeap.printHeap();
        maxHeap.sort();
        maxHeap.printHeap();
    }
}
