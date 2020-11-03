package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/largest-number-at-least-twice-of-others/">Largest Number At Least Twice of Others</a>
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public static void main(String... args) {

        int nums1[] = new int[]{3, 6, 1, 0};
        System.out.println(dominantIndex(nums1));

        int nums2[] = new int[]{1, 2, 3, 4};
        System.out.println(dominantIndex(nums2));

        int nums3[] = new int[]{0, 2, 0, 1};
        System.out.println(dominantIndex(nums3));
    }

    /**
     *
     * @param nums
     * @return int
     *
     * First iterate over the array and find the max index (index at which the value is the largest).
     *
     * Again, iterate over the array ignoring the maxIndex, and if the element at the current index * 2 is greater than the
     * element at the max index, then assign the dominantIndex variable = -1.
     *
     */
    private static int dominantIndex(int[] nums) {

        if(nums == null || nums.length == 0) return -1;

        int maxIndex = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        int dominantIndex = maxIndex;
        for(int i = 0; i < nums.length; i++) {
            if (i == maxIndex) continue;
            if (nums[i] * 2 > max) return -1;
        }

        return dominantIndex;
    }
}
