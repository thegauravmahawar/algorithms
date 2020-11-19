package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/implement-strstr/">Implement strStr()</a>
 */
public class ImplementStrStr {

    public static void main(String... args) {

        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("hello", "e"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("", ""));
        System.out.println(strStr("aaa", "a"));
        System.out.println(strStr("mississippi", "issip"));
        System.out.println(strStr("mississippi", "issipi"));
        System.out.println(strStr("mississippi", "sipp"));
        System.out.println(strStr("a", "a"));
    }

    /**
     * @param haystack
     * @param needle
     * @return int
     */
    private static int strStr(String haystack, String needle) {

        if (needle == null || needle.isEmpty()) return 0;
        if (haystack == null || haystack.isEmpty()) return -1;

        char[] hArr = haystack.toCharArray();
        char[] nArr = needle.toCharArray();
        int hlen = hArr.length;
        int nlen = nArr.length;

        if (nlen > hlen) return -1;

        char nc = nArr[0];
        boolean needleExists = false;
        int needleIndex = -1;

        for (int i = 0; i < hlen; i++) {
            //when the first character of the needle array matches the current element in the haystack array.
            if (nc == hArr[i]) {
                int k = i; //variable to compare haystack array elements with needle array elements
                /**
                 *
                 * We will first have a condition that will check that there are enough elements available in haystack
                 * to compare against the needle array. If suppose we are at the end of the haystack (last element matches the nc),
                 * and we reach this condition, there will be only one comparison (which will already be true and not expected).
                 * So, we have a condition before starting comparison - (k + nlen - 1) which checks that starting from the current
                 * element k, there are nlen - 1 characters available (< hlen). If not, we know that the needle will not be
                 * found in the haystack.
                 *
                 * Once we reach the for loop, we compare each element of the needle against each element of the haystack,
                 * starting from the kth position. If all elements match, that means needleExists variable will stay true, otherwise
                 * it will become false.
                 *
                 * After the loop, if needleExists variable is true, we know that the needle exists in the haystack, and we assign
                 * i to the needleIndex (first occurrence of the needle in the haystack). Also, we break out of the loop if this
                 * condition is met as we need to find the first occurrence.
                 *
                 */
                if (k + nlen - 1 < hlen)
                    for (int j = 0; j < nlen; j++, k++) if (!(needleExists = nArr[j] == hArr[k])) break;
                if (needleExists) {
                    needleIndex = i;
                    break;
                }
            }
        }

        return needleIndex;
    }
}
