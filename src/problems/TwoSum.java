package problems;

import java.util.Arrays;
import java.util.Hashtable;

public class TwoSum {

    public static void main(String... args) {

        int[] nums1 = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums1, 9)));
    }

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
        System.out.println(hashtable);

        return new int[]{};
    }
}
