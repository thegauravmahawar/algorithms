package problems;

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

    private static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        StringBuilder sb = new StringBuilder();

        int i = 0, j = 0;
        int s0Len = strs[0].length(), s1Len = strs[1].length();

        while(i < s0Len && j < s1Len) {
            if(strs[0].charAt(i) == strs[1].charAt(j)) sb.append(strs[0].charAt(i));
            else break;
            i++;
            j++;
        }

        if (sb.length() == 0) return sb.toString();

        StringBuilder sb1 = new StringBuilder();

        for (int k = 1; k < strs.length - 1; k++) {
            i = 0; j = 0;
            s0Len = Math.min(strs[k].length(), sb.length());
            s1Len = Math.min(strs[k + 1].length(), sb.length());
            while(i < s0Len && j < s1Len) {
                if(strs[k].charAt(i) == strs[k + 1].charAt(j) && strs[k].charAt(i) == sb.charAt(i)) sb1.append(strs[k].charAt(i));
                else break;
                i++;
                j++;
            }
            if (sb1.length() == 0) return sb1.toString();
            sb.replace(0, sb.length(), sb1.toString());
            sb1.setLength(0);
        }

        return sb.toString();
    }
}
