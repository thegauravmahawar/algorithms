package problems;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/two-sum">Two Sum</a>
 */
public class TwoSum {

    public static void main(String... args) {

        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    /**
     * @param nums
     * @param target
     * @return int[]
     * With each iteration find the difference between the target and the current element (target - nums[i]).
     * This difference will refer to the number that we are looking for. If this number is available in the array then
     * we have the pair otherwise we don't.
     * <p>
     * With each iteration we will store this difference and the current index (index of element which is one part of the pair).
     * <p>
     * For example: nums = [2, 7, 11, 15], target = 9
     * At index 0, element is 2. The difference between 9 - 2 is 7.
     * To complete the pair the array must contain 7, if we encounter 7, we will need the index of 2 as well, which we store with 7.
     * <p>
     * At index 1, element is 7. We check our hashtable for 7 (stored as difference from previous operation).
     * Since 7 is available, we return the index of the 2 (stored as value from previous operation) and the current index.
     */
    private static int[] twoSum(int[] nums, int target) {

        Hashtable<Integer, Integer> hashtable = new Hashtable<>(nums.length);
        int diff;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if (hashtable.containsKey(nums[i])) {
                return new int[]{
                        hashtable.get(nums[i]), i
                };
            }
            hashtable.put(diff, i);
        }
        return new int[]{};
    }
}
