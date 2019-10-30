package practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PeterTest1 {
    @Test
    public void test() {
        assertEquals(1, findClosestFib(6));
        assertEquals(1, findClosestFib(12));
        assertEquals(2, findClosestFib(10));
    }

    private int findClosestFib(int num) {
        for (int i = 0; i < num; i ++) {
            int fibNum = optimise(i);
            int nextFibNum = optimise(i + 1);

            if (fibNum <= num && num <= nextFibNum) {
                int lowDelta = num - fibNum;
                int topDelta = nextFibNum - num;

                boolean isTopCloser = lowDelta - topDelta > 0;

                return isTopCloser ? topDelta : lowDelta;
            }
        }

        return 0;
    }

    private int optimise(int nth) {
        return fib(nth, new int[nth + 1]); // 0 occupies 1 slot
    }

    private int fib(int nth, int[] cache) {
        if (nth == 0 || nth == 1) return nth;

        if (cache[nth] == 0) cache[nth] = fib(nth - 1, cache) + fib(nth - 2, cache);

        return cache[nth];
    }
}
