package practice;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PeterTest5 {
    @Test
    public void test() {
        assertEquals(8, findConsecutiveSubstring("zzzyz"));
        assertEquals(1, findConsecutiveSubstring("k"));
        assertEquals(6, findConsecutiveSubstring("kkk"));
    }

   private int findConsecutiveSubstring (String s) {
        int baseCounter = s.length();

        for (int lower = 0; lower < s.length(); lower++) {
            String lowerLetter = Character.toString(s.charAt(lower));
            for (int upper = lower + 1; lower < upper && upper < s.length(); upper ++) {
                String upperLetter = Character.toString(s.charAt(upper));
                if (upperLetter.equals(lowerLetter)) {
                    baseCounter++;
                } else {
                    break;
                }
            }
        }

        return baseCounter;
   }
}
