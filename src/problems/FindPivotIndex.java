package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/find-pivot-index/">Find Pivot Index</a>
 */
public class FindPivotIndex {

    public static void main(String... args) {

        int[] nums1 = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums1));

        int[] nums2 = new int[]{1, 2, 3};
        System.out.println(pivotIndex(nums2));

        int[] nums3 = new int[]{-1, -1, -1, 0, 1, 1};
        System.out.println(pivotIndex(nums3));
    }

    /**
     * @param nums
     * @return int
     *
     * Use a variable to get the sum of all the elements in the array. Now, starting from the 0th index till the end,
     * calculate left sum = left sum + nums[i - 1], and right sum = total - left sum - current element. At any point if
     * left sum == right sum, return the index.
     *
     */
    private static int pivotIndex(int[] nums) {

        if (nums == null || nums.length == 0) return -1;

        int total = 0;
        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        long leftSum = 0;
        long rightSum = 0;
        for(int i = 0; i < nums.length; i++) {
            //check for i == 0 is done if the pivot index is 0 itself.
            leftSum += i == 0 ? 0 : nums[i - 1];
            //right sum will be total - left sum - current element.
            rightSum = total - leftSum - nums[i];
            if(leftSum == rightSum) return i;
        }

        return -1;
    }
}
