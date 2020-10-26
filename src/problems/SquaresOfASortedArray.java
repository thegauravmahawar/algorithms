package problems;

import java.util.Arrays;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">Squares of a Sorted Array</a>
 */
public class SquaresOfASortedArray {

    public static void main(String... args) {

        int[] nums1 = new int[]{-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums1)));

        int[] nums2 = new int[]{-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(nums2)));
    }

    private static int[] sortedSquares(int[] A) {

        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
