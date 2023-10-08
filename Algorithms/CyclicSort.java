public class CyclicSort {
    public static void cyclicSort(int[] nums) {
        int n = nums.length;
        int i = 0;

        while (i < n) {
            if (nums[i] != i + 1) {
                // Swap the current element with the element at its correct position
                int correctPos = nums[i] - 1;
                if (correctPos >= 0 && correctPos < n) {
                    int temp = nums[i];
                    nums[i] = nums[correctPos];
                    nums[correctPos] = temp;
                }
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 4};
        cyclicSort(nums);

        // Print the sorted array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
