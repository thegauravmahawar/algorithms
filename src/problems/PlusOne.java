package problems;

import java.util.Arrays;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/plus-one/">Plus One</a>
 */
public class PlusOne {

    public static void main(String... args) {

        int[] nums1 = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(plusOne(nums1)));

        int[] nums2 = new int[]{4, 3, 2, 1};
        System.out.println(Arrays.toString(plusOne(nums2)));

        int[] nums3 = new int[]{0};
        System.out.println(Arrays.toString(plusOne(nums3)));

        int[] nums4 = new int[]{9, 9};
        System.out.println(Arrays.toString(plusOne(nums4)));

        int[] nums5 = new int[]{9};
        System.out.println(Arrays.toString(plusOne(nums5)));

        int[] nums6 = new int[]{8, 0, 9};
        System.out.println(Arrays.toString(plusOne(nums6)));

        int[] nums7 = new int[]{7, 9};
        System.out.println(Arrays.toString(plusOne(nums7)));

        int[] nums8 = new int[]{9, 9, 9};
        System.out.println(Arrays.toString(plusOne(nums8)));
    }

    /**
     * @param digits
     * @return int[]
     * <p>
     * There are a three cases here:
     * 1. An array with values [2, 3] will update to [2, 4]
     * 2. An array with values [7, 9] will update to [8, 0], because of the carry 1.
     * 3. An array with values [9, 9] will update to [1, 0, 0]. In this case since the array is fixed [9, 9],
     * we will create a new array of length [digits.length + 1] if we find that the carry is 1 after all values are updated.
     * <p>
     * To achieve this, we will first update the last element (increment by 1) of the array and store the carry that is calculated.
     * Now we iterate from the second last index till the start index of the array, and keep updating the value at that index
     * with the (current value + carry), and also keep calculating the carry value.
     * <p>
     * If after all the elements are updated, we still have a carry remaining, it means that an elements needs to be added
     * at the start of the array. Now, since the current array size is fixed, we will create a new array and handle this case
     * separately.
     */
    private static int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0) return digits;

        //assumption as per problem - 0 <= digits[i] <= 9
        int len = digits.length;
        /**
         * 9 / 10 = 0
         * 3 / 10 = 0
         * 10 / 10 = 1
         */
        int carry = (digits[len - 1] + 1) / 10;
        /**
         * 9 % 10 = 9
         * 3 % 10 = 3
         * 10 % 10 = 0
         */
        digits[len - 1] = (digits[len - 1] + 1) % 10;

        int tmp;
        for (int i = digits.length - 2; i >= 0; i--) {
            tmp = digits[i] + carry;
            digits[i] = tmp % 10;
            carry = tmp / 10;
        }

        //an element needs to be added to the start of the array to achieve the desired output.
        if (carry == 1) {
            //create new array with size - len + 1.
            int[] newDigits = new int[len + 1];
            newDigits[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                newDigits[i + 1] = digits[i];
            }
            return newDigits;
        }
        return digits;
    }
}
