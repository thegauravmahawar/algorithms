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

    private static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1])
                nums[j++] = nums[i];
        }

        nums[j++] = nums[nums.length - 1];
        return j;
    }
}
