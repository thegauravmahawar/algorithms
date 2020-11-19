package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/">Merge Sorted Array</a>
 */
public class MergeSortedArray {

    public static void main(String... args) {

        int[] arr1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] arr2 = new int[]{2, 5, 6};
        merge(arr1, 3, arr2, arr2.length);

        arr1 = new int[]{7, 0, 0, 0, 0, 0};
        arr2 = new int[]{2, 3, 5, 6, 9};
        merge(arr1, 1, arr2, arr2.length);

        arr1 = new int[]{5, 0, 0, 0, 0};
        arr2 = new int[]{1, 2, 3, 4};
        merge(arr1, 1, arr2, arr2.length);

        arr1 = new int[]{0};
        arr2 = new int[]{1};
        merge(arr1, 0, arr2, arr2.length);

        arr1 = new int[]{1, 2, 4, 5, 6, 0};
        arr2 = new int[]{3};
        merge(arr1, 5, arr2, arr2.length);

        arr1 = new int[]{-1, 0, 0, 3, 3, 3, 0, 0, 0};
        arr2 = new int[]{1, 2, 2};
        merge(arr1, 6, arr2, arr2.length);

        arr1 = new int[]{-1, 1, 2, 3, 4, 5, 6, 7, 8};
        arr2 = new int[]{};
        merge(arr1, 9, arr2, arr2.length);
    }

    /**
     * @param nums1
     * @param m
     * @param nums2
     * @param n     First we check that nums2 has elements. If not we return as nums1 is already sorted and nums2 will not impact the order.
     *              <p>
     *              NOTE: m is not the length of the array nums1, it is the number of elements that are present in the array (excluding 0's present at the end of the array).
     *              <p>
     *              To merge 2 sorted arrays, we first maintain a third array arr3 with size of m + n (to hold all values after merge).
     *              We iterate over nums1 from i to m (number of elements in nums1), and over nums2 from j to n (length of nums2).
     *              We compare 2 elements, one each from nums1[i]and nums2[j] respectively and add the smaller element to nums3[k] and incrementing the index
     *              of the array from which the smaller value is picked from (i++ or j++).
     *              <p>
     *              Once the loop has ended, we copy any remaining values in nums1 and nums2 to nums3.
     *              <p>
     *              Finally, we overwrite nums1 with the values in nums3.
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums2.length == 0) return;

        int[] nums3 = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) nums3[k++] = nums1[i++];
            else nums3[k++] = nums2[j++];
        }
        /**
         * In the condition, nums1[i] != 0 is used as the nums1 array has 0's at the end of the array denoting empty spaces.
         */
        while (i < m && nums1[i] != 0) nums3[k++] = nums1[i++];
        while (j < n) nums3[k++] = nums2[j++];
        for (int r = 0; r < nums1.length; r++) nums1[r] = nums3[r];
    }
}
