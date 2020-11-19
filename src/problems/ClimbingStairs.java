package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/climbing-stairs/">Climbing Stairs</a>
 */
public class ClimbingStairs {

    public static void main(String... args) {

        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
    }

    /**
     * @param n
     * @return int
     */
    private static int climbStairs(int n) {

        if (n <= 0) return 0;
        if (n == 1) return 1;

        int[] steps = new int[n + 1];
        steps[1] = 1;
        steps[2] = 2;

        for (int i = 3; i <= n; i++) {
            steps[i] = steps[i - 2] + steps[i - 1];
        }

        return steps[n];
    }
}
