import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.factory.Maps;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class Problem5LongestPalindromicSubstring {
    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        // Given
        MutableMap<String, String> testCases =
                Maps.mutable.with("abbbbbc", "bbbbb", "aaaaaa", "aaaaaa", "asdabvbaaa", "abvba");
        // Then
        testCases.forEachKeyValue((key, val) -> assertThat(longestPalindrome(key)).isEqualTo(val));
    }

    private String longestPalindrome(String s) {
        String currentLongestString = "";
        for (int i = 0; i < s.length(); i++) {
            String oddStringExtend = extendPalindrome(s, i, i);
            String evenStringExtend = extendPalindrome(s, i, i + 1);
            String longestString = oddStringExtend.length() > evenStringExtend.length() ? oddStringExtend : evenStringExtend;

            currentLongestString = longestString.length() > currentLongestString.length() ? longestString : currentLongestString;
        }

        return currentLongestString;
    }

    private String extendPalindrome(String s, int lower, int upper) {
        for (int i = 0; lower >= 0 && upper < s.length(); lower--, upper++) {
            if (s.charAt(lower) != s.charAt(upper)) break;
        }

        return s.substring(lower + 1, upper);
    }
}
