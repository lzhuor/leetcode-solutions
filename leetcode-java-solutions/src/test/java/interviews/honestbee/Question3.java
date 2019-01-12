package interviews.honestbee;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Question3 {
    @Test
    public void test() {
        assertEquals(1, shortestPalindrome("abab"));
        assertEquals(0, shortestPalindrome("abacaba"));
    }

    private int shortestPalindrome(String s) {
        int i = 0, end = s.length() - 1, j = end;
        char[] arr = s.toCharArray();
        while (i < j) {
            if (arr[i] == arr[j]) {
                ++i; --j;
            } else {
                i = 0; --end; j = end;
            }
        }
        String result =  new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
        return result.length() - s.length();
    }
}
