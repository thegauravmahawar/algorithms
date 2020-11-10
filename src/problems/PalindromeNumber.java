package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/palindrome-number/">Palindrome Number</a>
 */
public class PalindromeNumber {

    public static void main(String... args) {

        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-101));
    }

    private static boolean isPalindrome(int x) {

        if (x < 0) return false;

        int original = x;
        int reverse = 0;

        while (x > 0) {
            reverse = (reverse * 10) + (x % 10);
            x /= 10;
        }

        return original == reverse;
    }
}
