package problems;

import java.util.Arrays;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/sort-array-by-parity/">Sort Array By Parity</a>
 */
public class SortArrayByParity {

    public static void main(String... args) {

        int[] nums1 = new int[]{3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity(nums1)));
    }

    /**
     * @param A
     * @return int[]
     * <p>
     * Iterate over the array, and whenever we encounter an odd element, we look for an even element if the remaining array
     * and switch them.
     */
    private static int[] sortArrayByParity(int[] A) {

        if (A == null || A.length == 0) return A;

        for (int i = 0, j = i + 1; i < A.length && j < A.length; i++, j++) {
            //condition is met when element is odd
            if (A[i] % 2 != 0) {
                //look for an even element, increment j until element is odd and j is less than the array length - 1.
                while (A[j] % 2 != 0 && j < A.length - 1) {
                    j++;
                }
                //switch A[i] and A[j]
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }

        return A;
    }
}
