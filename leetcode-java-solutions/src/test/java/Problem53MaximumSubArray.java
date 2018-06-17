import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem53MaximumSubArray {
    @Test
    public void test() {
        assertEquals(6, maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(-1, maxSubArray(new int[]{-1, -2, -6, -7, -8, -9, -10, -11, -12}));
        assertEquals(100, maxSubArray(new int[]{-2, -5, -6, -7, -8, -9, -10, -11, 100}));
        assertEquals(0, maxSubArray(new int[]{0}));
    }

    private int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int num : nums) {
            currentMax = Math.max(num, currentMax + num);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }
}
