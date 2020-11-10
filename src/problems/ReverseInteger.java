package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/reverse-integer/">Reverse Integer</a>
 */
public class ReverseInteger {

    public static void main(String... args) {

        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
        System.out.println(reverse(1534236469));
    }

    private static int reverse(int x) {
        boolean negative = x < 0;
        long y = 0;
        x = negative ? Math.abs(x) : x;
        while(x > 0) {
            y = (y * 10) + x % 10;
            x /= 10;
        }
        if(y > Math.pow(2, 31) - 1) return 0;
        return negative ? (int) (-1 * y) : (int) y;
    }
}
