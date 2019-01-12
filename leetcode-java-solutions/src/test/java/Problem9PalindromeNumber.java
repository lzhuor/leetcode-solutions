import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Problem9PalindromeNumber {
    @Test
    public void test() {
        assertTrue(isPalindrome(0));
        assertTrue(isPalindrome(121));
        assertTrue(isPalindrome(1212121));
        assertFalse(isPalindrome(10));
        assertFalse(isPalindrome(1000));
        assertFalse(isPalindrome(-121));
        assertFalse(isPalindrome(1000030001));
    }

    private boolean isPalindrome(int x) {
        if (x < 0) return false;

        String numString = Integer.toString(x);
        char[] numStringArr = numString.toCharArray();
        boolean isLengthEven = numStringArr.length % 2 == 0;

        for (int i = 0, j = numStringArr.length - 1; isLengthEven ? i + 1 <= j : i <= j; i++, j--) {
            if (numStringArr[i] != numStringArr[j]) {
                return false;
            }
        }

        if (numStringArr.length == 2) {
            return numStringArr[0] == numStringArr[1];
        }

        return true;
    }
}
