package problems;

import java.util.Arrays;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Remove Duplicates from Sorted Array</a>
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String... args) {

        int[] nums1 = new int[]{1, 1, 2};
        System.out.println(removeDuplicates(nums1));

        int[] nums2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums2));

        int[] nums3 = new int[]{0, 1, 2, 3, 4};
        System.out.println(removeDuplicates(nums3));

        int[] nums4 = new int[]{3, 3};
        System.out.println(removeDuplicates(nums4));

        int[] nums5 = new int[]{1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums5));
    }

    /**
     * @param nums
     * @return int
     */
    private static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        /**
         * j is used to keep track of the index where the next unique element will be written.
         * j is initialized to 1 as that is the initial index where value will be written if there are duplicates, 0th index will be the smallest element.
         */
        int j = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            //whenever two adjacent elements are not matching, use the right sided element to be written at index j, and increment j.
            if (nums[i] != nums[i + 1])
                nums[j++] = nums[i + 1];
        }
        return j;
    }
}
