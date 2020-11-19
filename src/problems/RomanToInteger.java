package problems;

import java.util.Hashtable;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/roman-to-integer/">Roman to Integer</a>
 */
public class RomanToInteger {

    public static void main(String... args) {

        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    /**
     * @param s
     * @return int
     * <p>
     * Get the value of the current and the next element from the hashtable. If the current value is less than the next element,
     * that means it is a subtraction condition, and we subtract next - curr and assign to current value of num, we also need to
     * increment i by 1 so that next is not considered twice in the calculation.
     * <p>
     * If current value is more than the next element, that means it is a addition condition, and we add curr to the the
     * current value of num.
     * <p>
     * ** Assigned -1 to next to convey that i is pointing to the last element, and i + 1 will return an exception. Added
     * specific condition to ignore next == -1.
     */
    private static int romanToInt(String s) {

        Hashtable<Character, Integer> table = new Hashtable<>(7) {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int len = s.length();
        int num = 0, curr, next;
        for (int i = 0; i < len; i++) {
            curr = table.get(s.charAt(i));
            next = (i + 1 >= len) ? -1 : table.get(s.charAt(i + 1));
            if (next != -1 && curr < next) {
                num += next - curr;
                i += 1;
            } else {
                num += curr;
            }
        }

        return num;
    }
}
