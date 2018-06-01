package practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NthElementInFibonacci {
    @Test
    public void test() {
        assertEquals(0, fib(0));
        assertEquals(5, fib(5));
        assertEquals(34, fib(9));
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
}
