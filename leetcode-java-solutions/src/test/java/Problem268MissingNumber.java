import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem268MissingNumber {
    @Test
    public void testMissingNumber() {
        assertEquals(8, missingNumber(new int[]{ 9,6,4,2,3,5,7,0,1 }));
        assertEquals(2, missingNumber(new int[]{ 3,0,1 }));
    }

    private int missingNumber(int nums[]) {
        int actualSum = 0;
        int lastNum = nums.length;
        for (int i : nums) {
            actualSum += i;
        }
        int expectedSum = lastNum * (nums.length + 1) / 2;
        return expectedSum - actualSum;
    }
}
