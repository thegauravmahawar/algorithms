package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/duplicate-zeros/">Duplicate Zeros</a>
 */
public class DuplicateZeros {

    public static void main(String... args) {

        int[] nums1 = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(nums1);

        int[] nums2 = new int[]{1, 2, 3};
        duplicateZeros(nums2);
    }

    /**
     * @param arr Iterate over the array, when we encounter an element whose value is 0, we iterate again over the remaining array
     *            elements and move elements one place to the right with starting element being 0.
     *            <p>
     *            After the loop, we need to make sure that we are incrementing the index by 1 (keeping in mind that the value should not
     *            exceed the array length) so that again when the condition is checked for element value as 0, the condition should skip this
     *            element as we have already overwritten that value with 0. If we don't do this, all the values in the array after the first 0, will also become 0.
     */
    private static void duplicateZeros(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int temp = 0;
                for (int j = i + 1; j < arr.length; j++) {
                    int a = arr[j];
                    arr[j] = temp;
                    temp = a;
                }
                i = Math.min(arr.length - 1, i + 1); //important
            }
        }
    }
}
