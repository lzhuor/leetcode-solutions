package practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StaircasePermutation {
    @Test
    public void test() {
        // case 1
        assertEquals(7, hop(4));
        // case 2
        assertEquals(4, hop(3));
        // case 3
        assertEquals(0, hop(0));
        // case 4
        assertEquals(1, hop(1));
        // case 5
        assertEquals(2, hop(2));
    }

    private int hop(int stairs) {
//        if (stairs == 1) return 1;

        int numOfWays = 0;

        if (stairs - 1 >= 0) {
            numOfWays += stairs - 1 == 0 ? 1: hop(stairs - 1);
        }

        if (stairs - 2 >= 0) {
            numOfWays += stairs - 2 == 0 ? 1 : hop(stairs - 2);
        }

        if (stairs - 3 >= 0) {
            numOfWays += stairs - 3 == 0 ? 1 : hop(stairs - 3);
        }

        return numOfWays;
    }
}
