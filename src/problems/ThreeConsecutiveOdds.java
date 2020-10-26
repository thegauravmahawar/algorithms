package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/three-consecutive-odds/">Three Consecutive Odds</a>
 */
public class ThreeConsecutiveOdds {

    public static void main(String... args) {

        int[] nums1 = new int[]{2, 6, 4, 1};
        System.out.println(threeConsecutiveOdds(nums1));

        int[] nums2 = new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12};
        System.out.println(threeConsecutiveOdds(nums2));
    }

    /**
     * @param arr
     * @return For each iteration check three consecutive numbers at once and see if all three are odds. If they are return true.
     * To check three consecutive numbers at once, start iteration from index 2 till the end of the array, and keep track of the
     * previous 2 elements.
     */
    private static boolean threeConsecutiveOdds(int[] arr) {

        for (int i = 2; i < arr.length; i++) {
            if ((arr[i - 2] % 2 != 0) && (arr[i - 1] % 2 != 0) && (arr[i] % 2 != 0)) return true;
        }

        return false;
    }
}
