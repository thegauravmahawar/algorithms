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
    }

    /**
     *
     * @param nums
     * @return int
     *
     *
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
