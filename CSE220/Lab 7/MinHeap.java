public class MinHeap{
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public void insert(int value){
        if (size == capacity){
            System.out.println("Heap is full");
            return;
        }
        heap[size] = value;
        swim(size);
        size++;
    }
    private void swim(int index) {
        while (index > 0 && heap[parent(index)] > heap[index]) {
            swap(parent(index), index);
            index = parent(index);
        }
    }
    public int extractMin() {
        if (size == 0) {
            System.out.println("Heap is empty");
        }
        int min = heap[0];
        heap[0] = heap[--size];
        sink(0);
        return min;
    }
    private void sink(int index) {
        while (leftChild(index) < size) {
            int smallerChild = leftChild(index);
            if (rightChild(index) < size && heap[rightChild(index)] < heap[smallerChild]) {
                smallerChild = rightChild(index);
            }
            if (heap[index] <= heap[smallerChild]) {
                break;
            }
            swap(index, smallerChild);
            index = smallerChild;
        }
    }
    public void sort() {
        int originalSize = size;
        for (int i = size - 1; i > 0; i--) {
            swap(0, i);
            size--;
            sink(0);
        }
        size = originalSize;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}


