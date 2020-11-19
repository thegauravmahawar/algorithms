package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/remove-element/">Remove Element</a>
 */
public class RemoveElement {

    public static void main(String... args) {

        int[] nums1 = new int[]{3, 2, 2, 3};
        System.out.println(removeElement(nums1, 3));

        int[] nums2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums2, 2));

        int[] nums3 = new int[]{1};
        System.out.println(removeElement(nums3, 1));

        int[] nums4 = new int[]{3, 3};
        System.out.println(removeElement(nums4, 3));

        int[] nums5 = new int[]{4, 5};
        System.out.println(removeElement(nums5, 4));

        int[] nums6 = new int[]{4, 5};
        System.out.println(removeElement(nums6, 5));

        int[] nums7 = new int[]{2, 2, 3};
        System.out.println(removeElement(nums7, 2));

        int[] nums8 = new int[]{2, 2, 3};
        System.out.println(removeElement(nums8, 7));
    }

    /**
     * @param nums
     * @param val
     * @return int
     * <p>
     * First maintain a count = 0, which keeps track of the number of matching elements. The final value will be capacity - count.
     * <p>
     * Apart from removing the element, for each removal we need to shift the "remaining" elements one index to the left.
     * <p>
     * To do this, we iterate over the array and whenever an element is encountered which is equal to the value that is to be removed, look
     * for an index where the value is different from the matching value.
     * <p>
     * If we are not able to find such a value (nums[i] == nums[j]), then, all elements have been switched and there are no remaining elements
     * to be removed, so, count will be nums.length - i.
     * <p>
     * If we do find an index where the value is different, then we switch the values and keep repeating this until all values are switched.
     */
    private static int removeElement(int[] nums, int val) {

        if (nums.length == 0) return 0;

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                int j = Math.min(i + 1, nums.length - 1); //so that index j doesn't go past the array capacity.

                //look for index where value is different from val.
                //loop until value is not equal to val and j is less than the max index.
                while (nums[j] == val && j < nums.length - 1) {
                    j++;
                }

                /**
                 * If the below condition is matching, all elements are switched and / or there are no elements remaining matching val.
                 * Here we set count = nums.length - i, nums.length is the capacity, and i will denote the index upto which all values are switched
                 * and no value is present that is to be removed. We break in this condition as we know that there are no elements remaining to be switched.
                 */
                if (nums[i] == nums[j]) {
                    count = nums.length - i;
                    break;
                }

                //switch element at nums[j] with element at nums[i].
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums.length - count;
    }
}
