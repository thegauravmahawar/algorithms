package problems;

import java.util.Arrays;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Two Sum II - Input array is sorted</a>
 */
public class TwoSum2 {

    public static void main(String... args) {

        int[] nums1 = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums1, 9)));
        int[] nums2 = new int[]{2, 3, 4};
        System.out.println(Arrays.toString(twoSum(nums2, 6)));
        int[] nums3 = new int[]{2, 3, 4};
        System.out.println(Arrays.toString(twoSum(nums3, 9)));
    }

    /**
     *
     * @param numbers
     * @param target
     * @return int[]
     *
     * Since the array is sorted, for each iteration, we will do a binary search for the diff (target - numbers[i]) in the
     * remaining array. If the diffIndex > i, then we return the two indexes (1-based by adding 1).
     *
     */
    private static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int diffIndex = binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
            if(diffIndex > i) return new int[]{i + 1, diffIndex + 1};
        }
        return new int[]{};
    }

    private static int binarySearch(int[] nums, int low, int high, int target) {

        int mid;
        int index = -1;

        while (low < high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) return mid;

            if (target > nums[mid]) low = mid + 1;
            else high = mid;
        }
        return index;
    }
}
