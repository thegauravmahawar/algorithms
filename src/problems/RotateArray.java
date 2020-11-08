package problems;

import java.util.Arrays;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/rotate-array/">Rotate Array</a>
 */
public class RotateArray {

    public static void main(String... args) {

        int[] nums1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums1, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = new int[]{-1, -100, 3, 99};
        rotate(nums2, 2);
        System.out.println(Arrays.toString(nums2));
    }

    /**
     *
     * @param nums
     * @param k
     *
     * Take out the last element in the array and starting from the second last position shift all the elements to the right.
     * Now place the last element at the 0th index.
     *
     * Time complexity - O(n * r); r is the number of rotations
     *
     */
    private static void rotate(int[] nums, int k) {

        if(nums == null || nums.length == 0) return;

        int len = nums.length;
        int last;
        while(k > 0) {
            last = nums[len - 1];
            for(int i = len - 2; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }
            nums[0] = last;
            k--;
        }
    }
}
