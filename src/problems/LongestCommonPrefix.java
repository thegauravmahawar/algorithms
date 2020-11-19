package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/longest-common-prefix/">Longest Common Prefix</a>
 */
public class LongestCommonPrefix {

    public static void main(String... args) {

        String[] strs1 = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs1));

        String[] strs2 = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs2));

        String[] strs3 = new String[]{"acc", "aaa", "aaba"};
        System.out.println(longestCommonPrefix(strs3));

        String[] strs4 = new String[]{"baab", "bacb", "b", "cbc"};
        System.out.println(longestCommonPrefix(strs4));
    }

    /**
     * @param strs
     * @return String
     * <p>
     * We will use StringBuilder here so as to avoid String concatenation which adversely impacts the performance of the function.
     * <p>
     * First we will compare the first two Strings of the array and take out the longest common prefix out of them. We will use
     * this prefix as reference to work with the remaining Strings. The prefix will serve two purposes: Firstly, this will be our longest
     * prefix, so for the remaining Strings we need to process up to the length of this prefix. Secondly, we will compare all following
     * Strings against this prefix and see if the prefix that comes out of them is equal to or smaller than our reference prefix. If the
     * length is same so we continue to the next String, if not, we update the reference prefix with the smaller prefix.
     */
    private static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        /**
         * Work with the first two Strings to find out the longest prefix out of them.
         * If the prefix is available, use it as a reference to process the remaining Strings.
         * If not return that there is no prefix available.
         */
        StringBuilder longestPrefix = new StringBuilder();

        int i = 0, j = 0;
        int s0Len = strs[0].length(), s1Len = strs[1].length();

        //loop over the first two strings and compare both strings character by character. If characters are matching
        //append to the StringBuilder (to build the reference prefix).
        while (i < s0Len && j < s1Len) {
            if (strs[0].charAt(i) == strs[1].charAt(j)) longestPrefix.append(strs[0].charAt(i));
            else break;
            i++;
            j++;
        }

        if (longestPrefix.length() == 0) return longestPrefix.toString();

        StringBuilder prefix = new StringBuilder();

        for (int k = 2; k < strs.length; k++) {
            i = 0;
            s0Len = Math.min(strs[k].length(), longestPrefix.length());
            //compare the current String against the longest prefix
            while (i < s0Len) {
                if (strs[k].charAt(i) == longestPrefix.charAt(i)) prefix.append(strs[k].charAt(i));
                else break;
                i++;
            }
            if (prefix.length() == 0) return prefix.toString();
            //update the longest prefix with the value of prefix
            //(this can be a conditional operation - if length of prefix is smaller than longest prefix)
            longestPrefix.replace(0, longestPrefix.length(), prefix.toString());
            prefix.setLength(0); //reset prefix
        }

        return longestPrefix.toString();
    }
}
