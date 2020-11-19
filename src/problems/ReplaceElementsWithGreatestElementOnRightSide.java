package problems;

import java.util.Arrays;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/">Replace Elements with Greatest Element on Right Side</a>
 */
public class ReplaceElementsWithGreatestElementOnRightSide {

    public static void main(String... args) {

        int[] nums1 = new int[]{17, 18, 5, 4, 6, 1};
        System.out.println(Arrays.toString(replaceElements(nums1)));

        int[] nums2 = new int[]{};
        System.out.println(Arrays.toString(replaceElements(nums2)));

        int[] nums3 = new int[]{1};
        System.out.println(Arrays.toString(replaceElements(nums3)));

        int[] nums4 = new int[]{5, 3, 2, 1};
        System.out.println(Arrays.toString(replaceElements(nums4)));

        int[] nums5 = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(replaceElements(nums5)));
    }

    /**
     * @param arr
     * @return int[]
     * <p>
     * Since we have to do this in-place and the elements will be updated during comparison, so we will use separate variables
     * to keep track of max and min values.
     * <p>
     * Start with max = last element. Iterate from the end of the array till the start of the array and compare the max value
     * to the next element. Note here that we don't have to compare adjacent values, but the max that is encountered till now.
     * <p>
     * If max is greater than the next element, then update the value at the index with the max value. If the next element is
     * greater then:
     * 1. Store the current max value in the min variable. This is important because we have to write the current max value
     * to the next element even though it is larger. But use the next element from now on as the max value.
     * 2. Update the max value to the current element.
     * 3. Update the current element with the min variable.
     */
    private static int[] replaceElements(int[] arr) {
        if (arr == null || arr.length == 0) return arr;

        int max = arr[arr.length - 1];
        int min;
        for (int i = arr.length - 1; i > 0; i--) {
            if (max > arr[i - 1]) {
                arr[i - 1] = max;
            } else {
                min = max;
                max = arr[i - 1];
                arr[i - 1] = min;
            }
        }

        arr[arr.length - 1] = -1;
        return arr;
    }
}
