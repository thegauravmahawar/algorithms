package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/find-numbers-with-even-number-of-digits/">Find Numbers with Even Number of Digits</a>
 */
public class FindNumbersWithEvenNumberOfDigits {

    public static void main(String... args) {

        int[] nums1 = new int[]{12, 345, 2, 6, 7896};
        System.out.println(findNumbers(nums1));

        int[] nums2 = new int[]{555, 901, 482, 1771};
        System.out.println(findNumbers(nums2));
    }

    /**
     * @param nums
     * @return int
     * Keep a counter to keep track of the number of even digit numbers in the array. Iterate over the array and check
     * that each number has even digits. If the number has even digits than increment the counter.
     * <p>
     * To check if a given number has even digits - keep a counter to keep track of the number of digits in the number.
     * Keep dividing the number by 10 and incrementing the value of the counter. Assign the value of division back to the number.
     */
    private static int findNumbers(int[] nums) {

        if (nums.length == 0) return 0;

        int count = 0;
        for (int num : nums) {
            if (hasEvenDigits(num)) count++;
        }

        return count;
    }

    private static boolean hasEvenDigits(int num) {
        int digits = 0;

        while (num > 0) {
            num = num / 10;
            digits++;
        }

        return digits % 2 == 0;
    }
}
