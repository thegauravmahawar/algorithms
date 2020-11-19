package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/length-of-last-word/">Length of Last Word</a>
 */
public class LengthOfLastWord {

    public static void main(String... args) {

        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord(" "));
        System.out.println(lengthOfLastWord("a"));
    }

    /**
     * @param s
     * @return int
     */
    private static int lengthOfLastWord(String s) {

        if (s == null || s.length() == 0) return 0;

        String[] words = s.split(" ");
        if (words.length == 0) return 0;
        return words[words.length - 1].length();
    }
}
