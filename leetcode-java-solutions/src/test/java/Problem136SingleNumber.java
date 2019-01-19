import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Problem136SingleNumber {
    @Test
    public void testSingleNumber() {
        assertEquals(1, singleNumber(new int[]{2, 2, 1}));
        assertEquals(4, singleNumber(new int[]{4, 1, 2, 1, 2}));
        // Using bitwise
        assertEquals(1, singleNumberBitwise(new int[]{ 2, 2, 1 }));
        assertEquals(4, singleNumberBitwise(new int[]{4, 1, 2, 1, 2}));
    }

    private int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        List<Integer> res = new ArrayList<>(set);

        return res.get(0);
    }

    private int singleNumberBitwise(int[] nums) {
        int num = 0;

        for (int i : nums) {
            num = num ^ i;
        }

        return num;
    }
}
