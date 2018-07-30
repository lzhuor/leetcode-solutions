import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class Problem8StringToIntegerAtoi {
    @Test
    public void test() {
        assertEquals(42, myAtoi("42"));
        assertEquals(42, myAtoi("    42"));
        assertEquals(-42, myAtoi("-42"));
        assertEquals(4193, myAtoi("4193 with words"));
        assertEquals(0, myAtoi("words and 987"));
        assertEquals(Integer.MIN_VALUE, myAtoi("-91283472332"));
        assertEquals(Integer.MAX_VALUE, myAtoi("31283472332"));
        assertEquals(3, myAtoi("3.14"));
        assertEquals(12, myAtoi("  -0012a42"));
    }

    private int myAtoi(String str) {
        String first = getFirstNonEmptyElement(str);
        int result = 0;

        try {
            result = Integer.parseInt(first);
        } catch (NumberFormatException nfe) {
            try {
                if (first.contains(".")) {
                    String[] s = first.split("\\.");
                    result = Integer.parseInt(s[0]);
                } else {
                    new BigDecimal(first);

                    if (first.substring(0, 1).equals("-")) {
                        result = Integer.MIN_VALUE;
                    } else {
                        result = Integer.MAX_VALUE;
                    }
                }
            } catch (NumberFormatException nfe2) {
                // do nothing
            }
        }

        return result;
    }

    private String getFirstNonEmptyElement(String str) {
        String[] sArr = str.split(" ");
        int index = 0;

        while(index < sArr.length) {
            String s = sArr[index];
            if (!s.isEmpty() && !s.equals(" ")) return s;
            index++;
        }

        return "";
    }
}
