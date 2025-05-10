import java.util.Arrays;
import java.util.Scanner;

public class LargestK{

    private int[] heap;
    private int size;
    private int capacity;

    public LargestK(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
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
        while (index > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
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

    private void sink(int index) {
        int largerChild;
        while ((largerChild = leftChild(index)) < size) {
            int right = rightChild(index);
            if (right < size && heap[right] > heap[largerChild]) {
                largerChild = right;
            }
            if (heap[index] >= heap[largerChild]) break;
            swap(index, largerChild);
            index = largerChild;
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

    public static int[] findTopK(int[] nums, int k) {
        LargestK maxHeap = new LargestK(nums.length);
        for (int num : nums) {
            maxHeap.insert(num);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.extractMax();
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();
        int[] result = findTopK(nums, k);
        System.out.println("Top " + k + " largest elements: " + Arrays.toString(result));
        sc.close();
    }
}
