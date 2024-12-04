public class LargestElements {

    public static int[] findTop(int[] nums, int k) {
       
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    // Swap nums[i] and nums[j]
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 10, 2, 8, 6, 7};
        int k = 3;

        int[] result = findTop(nums, k);

        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
