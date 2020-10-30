package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/valid-mountain-array/">Valid Mountain Array</a>
 */
public class ValidMountainArray {

    public static void main(String... args) {

        int[] nums1 = new int[]{2, 1};
        System.out.println(validMountainArray(nums1));

        int[] nums2 = new int[]{3, 5, 5};
        System.out.println(validMountainArray(nums2));

        int[] nums3 = new int[]{0, 3, 2, 1};
        System.out.println(validMountainArray(nums3));

        int[] nums4 = new int[]{5, 3, 2, 1};
        System.out.println(validMountainArray(nums4));

        int[] nums5 = new int[]{1, 2, 3, 4};
        System.out.println(validMountainArray(nums5));

        int[] nums6 = new int[]{0, 2, 3, 4, 5, 2, 1, 0};
        System.out.println(validMountainArray(nums6));

        int[] nums7 = new int[]{0, 2, 3, 3, 5, 2, 1, 0};
        System.out.println(validMountainArray(nums7));

        int[] nums8 = new int[]{1, 7, 9, 5, 4, 1, 2};
        System.out.println(validMountainArray(nums8));
    }

    /**
     * @param A
     * @return boolean
     *
     * Basic idea is to find the first tip index (the first index, after which the next value is smaller or equal).
     * If the tip index is the first or the last index, that means the tip is at start or the end, it will not make a valid mountain.
     *
     * Here, we have established that the tip index will lie from index 1 to 2nd last index.
     * Now, using the tip index as the initial index, check that out of any two adjacent values, the right sided value is
     * greater or equal to the left sided value, if so return false, as that means that even after the tip index, there are multiple tips
     * and the mountain is not a valid mountain due to multiple slopes.
     *
     */
    private static boolean validMountainArray(int[] A) {

        if (A == null || A.length <= 2) return false;

        int tipIndex = 0;
        for (int i = 0; i < A.length - 1; i++) {
            //if right sided index value is more than the left sided index value, assign tipIndex the value of right sided index.
            if (A[i] < A[i + 1]) {
                tipIndex = i + 1;
            } else {
                break;
            }
        }

        //if tipIndex is 0 or the last index, that means, the tip is at the start or the end, which does not fulfill the valid mountain definition.
        if (tipIndex == 0 || tipIndex == A.length - 1) return false;

        //using the tipIndex as the initial value, iterate over the array, and check if out of any two adjacent values, the right sided value
        //is greater than or equal to the left sided value, if so, return false.
        for (int i = tipIndex; i < A.length - 1; i++) {
            if (A[i + 1] >= A[i]) return false;
        }

        return true;
    }
}
