import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem7ReverseInteger {
    @Test
    public void test() {
        assertEquals(1, reverseInteger(10));
        assertEquals(321, reverseInteger(123));
        assertEquals(-123, reverseInteger(-321));
        // overflow should return 0
        assertEquals(0, reverseInteger(Integer.MAX_VALUE));
    }

    private int reverseInteger(Integer number) {
        if (number.toString().length() == 1) return number;
        char[] numCharArr = number.toString().toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean isPaddingZero = true;
        for (int i = numCharArr.length - 1; i >= 0; i--) {
            char c = numCharArr[i];
            if(c == 0 && isPaddingZero) continue;
            if(c != 0 && !String.valueOf(c).equals("-")) {
                isPaddingZero = false;
                sb.append(String.valueOf(c));
            }
        }

        try {
            int reversed = Integer.parseInt(sb.toString());
            return number >= 0 ? reversed : reversed * -1;
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }
}
