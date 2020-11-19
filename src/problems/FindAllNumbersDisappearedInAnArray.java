package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/">Find All Numbers Disappeared in an Array</a>
 */
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String... args) {

        int[] nums1 = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums1));

        int[] nums2 = new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7};
        System.out.println(findDisappearedNumbers(nums2));
    }

    /**
     * @param nums
     * @return List
     * <p>
     * Maintain a set and add all numbers in the array to the set. Set, by its property will only keep unique elements.
     * Now we only add those elements to the disappearedNumbers list which are not in the set. Using (i + 1) to check in the
     * set and to add to the disappearedNumbers list is that we know that the numbers will be in the range of 1 to N, N being the
     * size of the array.
     */
    private static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> disappearedNumbers = new ArrayList<>(nums.length);
        Set<Integer> uniqueNumbers = new HashSet<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            uniqueNumbers.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!uniqueNumbers.contains(i + 1)) {
                disappearedNumbers.add(i + 1);
            }
        }

        return disappearedNumbers;
    }
}
