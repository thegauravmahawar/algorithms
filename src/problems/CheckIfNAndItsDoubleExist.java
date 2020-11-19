package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/check-if-n-and-its-double-exist/">Check If N and Its Double Exist</a>
 */
public class CheckIfNAndItsDoubleExist {

    public static void main(String... args) {

        int[] nums1 = new int[]{10, 2, 5, 3};
        System.out.println(checkIfExist(nums1));

        int[] nums2 = new int[]{7, 1, 14, 11};
        System.out.println(checkIfExist(nums2));

        int[] nums3 = new int[]{3, 1, 7, 11};
        System.out.println(checkIfExist(nums3));
    }

    /**
     * @param arr
     * @return boolean
     */
    private static boolean checkIfExist(int[] arr) {

        Set<Integer> set = new HashSet<>(arr.length * 2);

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) return true;

            if (arr[i] % 2 == 0) {
                set.add(arr[i] / 2);
            }
            set.add(arr[i] * 2);
        }
        return false;
    }
}
