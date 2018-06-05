package practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NthElementInFibonacci {
    @Test
    public void test() {
        // O(1.6^n) solution
        long startTime = System.nanoTime();
        assertEquals(0, fib(0));
        assertEquals(5, fib(5));
        assertEquals(34, fib(9));
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

        // O(n) solution
        startTime = System.nanoTime();
        assertEquals(0, optimise(0));
        assertEquals(5, optimise(5));
        assertEquals(34, optimise(9));
        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println(totalTime);
    }

    private int fib(int nth) {
        if (nth == 0) {
            return 0;
        }

        if (nth == 1) {
            return 1;
        }

        if (nth > 1) {
            return fib(nth - 1) + fib(nth - 2);
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
