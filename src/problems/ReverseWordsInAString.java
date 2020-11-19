package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string/">Reverse Words in a String</a>
 */
public class ReverseWordsInAString {

    public static void main(String... args) {

        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
        System.out.println(reverseWords("  Bob    Loves  Alice   "));
        System.out.println(reverseWords("Alice does not even like bob"));
    }

    /**
     *
     * @param s
     * @return String
     */
    private static String reverseWords(String s) {

        if(s == null || s.length() == 0) return s;

        s = s.trim().replaceAll("\\s+", " ");
        String[] strs = s.split(" ");

        int i = strs.length - 1;

        StringBuilder sb = new StringBuilder();
        while(i > 0) {
            sb.append(strs[i]).append(" ");
            i--;
        }
        sb.append(strs[i]);
        return sb.toString();
    }
}
