package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/search-insert-position/">Search Insert Position</a>
 */
public class SearchInsertPosition {

    public static void main(String... args) {

        int[] nums1 = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(nums1, 5));

        int[] nums2 = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(nums2, 2));

        int[] nums3 = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(nums3, 7));

        int[] nums4 = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(nums4, 0));

        int[] nums5 = new int[]{1};
        System.out.println(searchInsert(nums5, 0));
    }

    /**
     *
     * @param nums
     * @param target
     * @return int
     *
     * Perform binary search to look for index of the target.
     *
     * When target is greater than the current element, assign low to the index variable. When target is smaller than the current element,
     * assign high to the index variable.
     *
     */
    private static int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length;
        int mid;
        int index = 0;

        while (low < high) {

            mid = (low + high) / 2;
            if (nums[mid] == target) return mid;

            if (target > nums[mid]) {
                low = mid + 1;
                index = low;
            } else {
                high = mid;
                index = high;
            }
        }

        return index;
    }
}
