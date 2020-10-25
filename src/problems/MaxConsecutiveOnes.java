package problems;

/**
 *
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/max-consecutive-ones/">Max Consecutive Ones</a>
 *
 */
public class MaxConsecutiveOnes {

    public static void main(String... args) {

        int[] nums1 = new int[]{1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums1));

        int[] nums2 = new int[]{1, 1, 0, 0, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums2));

        int[] nums3 = new int[]{0, 1, 0, 0, 0, 1};
        System.out.println(findMaxConsecutiveOnes(nums3));

        int[] nums4 = new int[]{0, 0, 0, 0, 0, 0};
        System.out.println(findMaxConsecutiveOnes(nums4));
    }

    /**
     *
     * @param nums
     * @return
     *
     * We keep two variables - max and curr. curr will keep track of the latest consecutive ones, and max will keep track
     * of the maximum consecutive ones encountered till now.
     *
     * We iterate over the array, when value in the array is 0, we get the maximum value out max and curr. We store this value
     * in max. If we encounter 1, we increment curr by 1. This will keep updating the value of curr which is used to keep track of
     * the latest series of ones. Whenever we reach a breakpoint, i.e. encounter a 0, we compare this value of curr with the max value
     * we had encountered so far. We update max if curr is greater than the current value of max.
     *
     * NOTE: While returning the value, we should keep note that if curr value is largest at the end of the array, and the last element
     * is 1, then that value of curr gets updated, but the comparison with max is not done as the loop has ended. Therefore, while returning
     * the value, we should once again do a comparison with max and return the largest of the two values.
     *
     */
    private static int findMaxConsecutiveOnes(int[] nums) {

        if (nums.length == 0) return 0;

        int max = 0;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                max = Math.max(max, curr);
                curr = 0;
            } else {
                curr++;
            }
        }
        return Math.max(max, curr);
    }
}
