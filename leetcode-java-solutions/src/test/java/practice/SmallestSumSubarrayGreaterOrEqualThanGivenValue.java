package practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmallestSumSubarrayGreaterOrEqualThanGivenValue {
    @Test
    public void test() {
        assertEquals(2, find(new int[]{1, 4, 45, 6, 0, 19}, 51));
        assertEquals(1, find(new int[]{1, 10, 5, 2, 7}, 9));
        assertEquals(4, find(new int[]{1, 11, 100, 1, 0, 200, 3, 2, 1, 250}, 280));
    }

    private int find(int[] array, int target) {
        int currentSum = 0;
        int leftIdx = 0;
        int rightIdx = 0;
        int minLength = array.length + 1;

        while (rightIdx < array.length) {
            while (currentSum < target && rightIdx < array.length) {
                currentSum += array[rightIdx++];
            }

            while (currentSum >= target && leftIdx <= rightIdx) {
                int delta = rightIdx - leftIdx;
                minLength = Math.min(delta, minLength);
                currentSum -= array[leftIdx++];
            }
        }

        return minLength;
    }
}
