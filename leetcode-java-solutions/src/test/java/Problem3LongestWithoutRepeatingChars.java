import java.util.HashSet;

import static org.junit.Assert.assertEquals;

class Problem3LongestWithoutRepeatingChars {
    public static void main(String args[]) {
        assertEquals(3, lengthOfLongestSubstring("abcabcbb")); // 3: "abc"
        assertEquals(1, lengthOfLongestSubstring("bbbbbb"));  // 1: "b"
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));  // 3: "wke"
        assertEquals(3, lengthOfLongestSubstring("dvdf"));  // 3: "vdf"
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s.equals("")) return 0;

        String[] strArr = s.split("");
        int longest = 0;
        int currentIdx = 0;
        int beginIdx = 0;
        HashSet<String> dict = new HashSet<>();

        while (currentIdx < strArr.length) {
            String str = strArr[currentIdx];

            if (!dict.contains(str)) {
                dict.add(str);
                currentIdx++;
                longest = Math.max(dict.size(), longest);
            } else {
                dict.remove(strArr[beginIdx]);
                beginIdx++;
            }
        }

        return longest;
    }
}
