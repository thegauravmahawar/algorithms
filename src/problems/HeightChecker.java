package problems;

import java.util.Arrays;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/height-checker/">Height Checker</a>
 */
public class HeightChecker {

    public static void main(String... args) {

        int[] nums1 = new int[]{1, 1, 4, 2, 1, 3};
        System.out.println(heightChecker(nums1));
    }

    /**
     * @param heights
     * @return int
     * <p>
     * Create another array with the same set of values. Sort the new array, and compare each element in the old array
     * with the new array, at whichever point there is a difference in the value, we increment the count variable.
     */
    private static int heightChecker(int[] heights) {

        if (heights == null || heights.length == 0) return 0;

        int[] sortedHeights = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            sortedHeights[i] = heights[i];
        }

        Arrays.sort(sortedHeights);

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (sortedHeights[i] != heights[i]) count++;
        }

        return count;
    }
}
