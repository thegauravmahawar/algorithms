package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/maximum-subarray/">Maximum Subarray</a>
 */
public class MaximumSubArray {

    public static void main(String... args) {

        int[] nums1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums1));
        int[] nums2 = new int[]{1};
        System.out.println(maxSubArray(nums2));
        int[] nums3 = new int[]{0};
        System.out.println(maxSubArray(nums3));
        int[] nums4 = new int[]{-1};
        System.out.println(maxSubArray(nums4));
        int[] nums5 = new int[]{-2, 1};
        System.out.println(maxSubArray(nums5));
    }

    /**
     *
     * @param nums
     * @return int
     *
     * The idea that we have used here is that, if we look at [-2, 1] - the problem says maximum subarray can contain only
     * one element also. So, for the above mentioned array, there are 3 possibilities - -2, -2 + 1, 1, clearly 1 is the largest.
     *
     * The above idea is especially important when the following values are smaller, for example, [4, -1, 2, 1]. Initially the localSum
     * will be 4, but when the index reaches -1, the max value is taken from the comparison of -1 and 4 + (-1), which is 3, so localSum
     * becomes 3, which is correct, but since this is not greater than our final sum which is still 4, so it will stay the same until the
     * next element, which is 2 is added, and then finally 1 is added.
     *
     * So, we will use a variable (localSum) to keep track of the sum of all the previous elements before the current element, however,
     * when the current element is greater than the combined sum of all previous elements, we will use this current element as
     * the max sum found till now and assign it to localSum. We copy this value over to our final sum, which we want to
     * return if the localSum is greater than the final sum.
     *
     */
    private static int maxSubArray(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int sum = Integer.MIN_VALUE;
        int localSum = 0;

        for(int i = 0; i < nums.length; i++) {
            localSum = Math.max(nums[i], nums[i] + localSum);
            sum = Math.max(sum, localSum);
        }

        return sum;
    }
}
