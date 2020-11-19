package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/third-maximum-number/">Third Maximum Number</a>
 */
public class ThirdMaximumNumber {

    public static void main(String... args) {

        int[] nums1 = new int[]{3, 2, 1};
        System.out.println(thirdMax(nums1));

        int[] nums2 = new int[]{2, 2, 3, 1};
        System.out.println(thirdMax(nums2));

        int[] nums3 = new int[]{1, 2};
        System.out.println(thirdMax(nums3));
    }

    /**
     * @param nums
     * @return int
     * <p>
     * We will be using the Integer wrapper class so as to not create a situation where we have assigned the variables the
     * Integer.MIN_VALUE and we do not encounter the Integer.MIN_VALUE. It will be difficult to discern whether there was
     * a number available in the array with the value equal to Integer.MIN_VALUE or the variable has its original value.
     * Alternatively we can use a boolean to check if we have encountered a Integer.MIN_VALUE in the array.
     * <p>
     * We use three variables to keep track of max1, max2, and max3. We return the value of max3 if available or max1 if max3
     * is not available.
     * <p>
     * We loop over the elements of the array and whenever we encounter a number greater than the max1, we assign max2 to max3,
     * max1 to max2, and update the max1 value with the new number.
     * <p>
     * Similarly, when we encounter a number greater than max2, we assign max2 to max3, and update the max2 value with the new number.
     * <p>
     * Same we will do with max3, but will just assign the number to max3 if the number is greater. We don't update max1 or max2.
     * <p>
     * We also use a condition at the beginning of our code that if the current number we are processing, is equal to any of max1,
     * max2 or max3 we continue to the next element without processing further. This is done so as to handle duplicate values.
     */
    private static int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Integer max1 = null, max2 = null, max3 = null;

        for (Integer num : nums) {
            //condition to handle duplicate values [2, 2, 3, 1], here if processing is
            //allowed to continue, max3 will have the value 2 instead of 1.
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) continue;

            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            } else if (max3 == null || num > max3) {
                max3 = num;
            }
        }
        return max3 == null ? max1 : max3;
    }
}
