import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Problem9PalindromeNumber {
    @Test
    public void test() {
        assertTrue(isPalindrome(0));
        assertTrue(isPalindrome(121));
        assertTrue(isPalindrome(1212121));
        assertFalse(isPalindrome(-121));
    }

    private boolean isPalindrome(int x) {
        if (x < 0) return false;

        String numString = Integer.toString(x);
        char[] numStringArr = numString.toCharArray();

        for (int i = 0, j = numStringArr.length - 1; i + 1 <= j - 1; i++, j--) {
            if (numStringArr[i] != numStringArr[j]) {
                return false;
            }
        }

        return true;
    }
}
