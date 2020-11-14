package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/sqrtx/">Sqrt(x)</a>
 */
public class Sqrt {

    public static void main(String... args) {

        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
    }

    /**
     *
     * @param x
     * @return int
     */
    private static int mySqrt(int x) {
        return (int) Math.pow(x, 0.5);
    }
}
