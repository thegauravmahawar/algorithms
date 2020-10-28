package problems;

import java.util.Arrays;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/remove-element/">Remove Element</a>
 */
public class RemoveElement {

    public static void main(String... args) {

        int[] nums1 = new int[]{3, 2, 2, 3};
        System.out.println(removeElement(nums1, 3));

        int[] nums2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums2, 2));

        int[] nums3 = new int[]{1};
        System.out.println(removeElement(nums3, 1));

        int[] nums4 = new int[]{3, 3};
        System.out.println(removeElement(nums4, 3));

        int[] nums5 = new int[]{4, 5};
        System.out.println(removeElement(nums5, 4));

        int[] nums6 = new int[]{4, 5};
        System.out.println(removeElement(nums6, 5));

        int[] nums7 = new int[]{2, 2, 3};
        System.out.println(removeElement(nums7, 2));

        int[] nums8 = new int[]{2, 2, 3};
        System.out.println(removeElement(nums8, 7));
    }

    /**
     * @param nums
     * @param val
     * @return int
     */
    private static int removeElement(int[] nums, int val) {

        if (nums.length == 0) return 0;

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                int j = Math.min(i + 1, nums.length - 1);
                while (nums[j] == val && j < nums.length - 1) {
                    j++;
                }
                if (nums[i] == nums[j]) {
                    count = nums.length - i;
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums.length - count;
    }
}
