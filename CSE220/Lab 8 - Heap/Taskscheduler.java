import java.util.Arrays;
import java.util.Scanner;

public class Taskscheduler {

    private int[] heap;
    private int size;
    private int capacity;
    private boolean isMinHeap;

    public Taskscheduler(int capacity, boolean isMinHeap) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
        this.isMinHeap = isMinHeap;
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = value;
        swim(size++);
    }

    private void swim(int index) {
        while (index > 0 && compare(heap[index], heap[parent(index)])) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int extractRoot() {
        if (size == 0) {
            System.out.println("Heap is empty");
        }
        int root = heap[0];
        heap[0] = heap[--size];
        sink(0);
        return root;
    }

    private void sink(int index) {
        int child;
        while ((child = leftChild(index)) < size) {
            if (rightChild(index) < size && compare(heap[rightChild(index)], heap[child])) {
                child = rightChild(index);
            }
            if (!compare(heap[child], heap[index])) {
                break;
            }
            swap(index, child);
            index = child;
        }
    }

    private int parent(int index) { return (index - 1) / 2; }
    private int leftChild(int index) { return 2 * index + 1; }
    private int rightChild(int index) { return 2 * index + 2; }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    private boolean compare(int a, int b) { return isMinHeap ? a < b : a > b; }

    public void displayHeap() {
        System.out.println("Heap:");
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter capacity: ");
        int capacity = sc.nextInt();
        System.out.print("Is Min Heap (true/false): ");
        boolean isMinHeap = sc.nextBoolean();

        Taskscheduler heap = new Taskscheduler(capacity, isMinHeap);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            heap.insert(sc.nextInt());
        }
        heap.displayHeap();
        System.out.println("Extracted root: " + heap.extractRoot());
        heap.displayHeap();
        sc.close();
    }
}
