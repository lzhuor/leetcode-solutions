package practice;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckPowerOfTen {
    @Test
    public void test() {
        // Approach 1
        assertTrue(checkPowerOfTen(100.0));
        assertTrue(checkPowerOfTen(10.0));
        assertTrue(checkPowerOfTen(0.1));
        assertTrue(checkPowerOfTen(0.01));
        assertFalse(checkPowerOfTen(11));
        assertFalse(checkPowerOfTen(0.2));
        assertFalse(checkPowerOfTen(200));

        // Approach 2
        assertTrue(checkPowerOfTen2(100.0));
        assertTrue(checkPowerOfTen2(10.0));
        assertTrue(checkPowerOfTen2(0.1));
        assertTrue(checkPowerOfTen2(0.01));
        assertFalse(checkPowerOfTen2(11));
        assertFalse(checkPowerOfTen2(0.2));
        assertFalse(checkPowerOfTen2(200));
    }

    private boolean checkPowerOfTen(double number) {
        if (number < 0) return false;
        if (number == 1) return true;

        if (number > 1) {
            for (int counter = 1; Math.pow(10.0, counter) <= number; counter ++) {
                if (Math.pow(10, counter) == number) return true;
            }
        }

        if (number < 1) {
            for (int counter = 1; Math.pow(10, -counter) >= number; counter ++) {
                if (Math.pow(10, -counter) == number) return true;
            }
        }

        return false;
    }

    private boolean checkPowerOfTen2(double number) {
        int roundResult = (int) Math.round(Math.log(number) / Math.log(10));
        BigDecimal result = BigDecimal.valueOf(Math.log(number) / Math.log(10)).setScale(2, BigDecimal.ROUND_UP);

        return result.doubleValue() == roundResult;
    }
}
