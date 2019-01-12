import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Problem14LongestCommonPrefix {
    @Test
    public void testLongestCommonPrefix() {
        assertEquals("fl", longestCommonPrefix(new String[]{"flow", "flower", "flight"}));
        assertEquals("", longestCommonPrefix(new String[]{"dog", "racear", "car"}));
        assertEquals("", longestCommonPrefix(new String[]{}));
        assertEquals("a", longestCommonPrefix(new String[]{"a"}));
        assertEquals("a", longestCommonPrefix(new String[]{"a", "a"}));
    }

    private String longestCommonPrefix(String[] words) {
        int minLength = Integer.MAX_VALUE;
        for (String word: words) {
            minLength = Math.min(minLength, word.length());
        }

        String common = "";

        if (minLength == Integer.MAX_VALUE) return common;

        for (int i = 1; i <= minLength; i++) {
            String prefix = words[0].substring(0, i);
            boolean allEqual = true;

            for (String word: words) {
                if (!word.substring(0, i).equals(prefix)) {
                    allEqual = false;
                    break;
                }
            }

            if (allEqual) common = prefix;
        }

        return common;
    }
}
