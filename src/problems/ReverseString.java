package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/reverse-string/">Reverse String</a>
 */
public class ReverseString {

    public static void main(String... args) {

        char[] s1 = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(s1);
        System.out.println(s1);

        char[] s2 = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s2);
        System.out.println(s2);
    }

    /**
     * @param s We will use the two-pointer approach here. We will keep a pointer i starting with 0, and a pointer j starting
     *          with the end of the array (last element). We will swap the values of the element at the ith and jth index. We will
     *          repeat this until i < j (reaching mid point of the array).
     */
    private static void reverseString(char[] s) {

        if (s == null || s.length == 0) return;

        int i = 0, j = s.length - 1;

        char temp;
        while (i < j) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
