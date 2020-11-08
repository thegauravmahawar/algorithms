package problems;

import java.util.Arrays;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/move-zeroes/">Move Zeroes</a>
 */
public class MoveZeroes {

    public static void main(String... args) {

        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = new int[]{1, 3, 12};
        moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = new int[]{1, 0};
        moveZeroes(nums3);
        System.out.println(Arrays.toString(nums3));

        int[] nums4 = new int[]{0, 1};
        moveZeroes(nums4);
        System.out.println(Arrays.toString(nums4));

        int[] nums5 = new int[]{0, 0};
        moveZeroes(nums5);
        System.out.println(Arrays.toString(nums5));

        int[] nums6 = new int[]{0};
        moveZeroes(nums6);
        System.out.println(Arrays.toString(nums6));
    }

    /**
     *
     * @param nums
     *
     * Use two-pointer technique to achieve this. We will keep track of the current element, and j will be used to find the index
     * with a non-zero value.
     *
     * Iterate over the array and if nums[i] == 0, then iterate over the rest of the array to find a index which has a non-zero value.
     * Now assign the value at nums[j] to nums[i], and assign nums[j] = 0.
     *
     */
    private static void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) return;

        for(int i = 0, j = 0; i < nums.length && j < nums.length; i++, j++) {
            if(nums[i] == 0) {
                while (nums[j] == 0 && j < nums.length - 1) {
                    j++;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }

    }
}
