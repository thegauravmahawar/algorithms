package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String... args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("abcd"));
        System.out.println(lengthOfLongestSubstring("ababcdabc"));
        System.out.println(lengthOfLongestSubstring("ababcbabc"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("ababcde"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    /**
     * @param s
     * @return int
     * <p>
     * Use a set to keep track of the substring without repeating characters.
     * <p>
     * Whenever we encounter a duplicate character in the string, we remove the oldest character and increment j. This
     * approach has an issue that on encountering a duplicate character i is not incremented, and so until that character
     * is removed from the set we will be stuck. If the duplicate character is just before the current character, then the
     * entire set will become empty before moving ahead with finding the length of the substring without repeating characters.
     */
    private static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) return 0;

        int len = s.length();
        int i = 0, j = 0, max = 0;

        Set<Character> set = new HashSet<>(len);
        while (i < len) {
            if (set.add(s.charAt(i))) {
                max = Math.max(max, set.size());
                i++;
            } else {
                //remove oldest character from set.
                set.remove(s.charAt(j));
                j++;
            }
        }

        return max;
    }
}
