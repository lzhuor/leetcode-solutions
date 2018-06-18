import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Problem204CountPrime {
    @Test
    public void test() {
        assertEquals(4, countPrimes(10));
        assertEquals(2, countPrimes(5));
        assertTrue(isPrime(5));
        assertTrue(isPrime(191));
        assertTrue(!isPrime(8));
    }

    private int countPrimes(int n) {
        int counter = 0;
        
        for (int i = 2; i < n; i++) {
            counter += isPrime(i) ? 1 : 0;
        }
        
        return counter;
    }
    
    private boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        
        if (n % 2 == 0) {
            return false;
        }
            
        for (int i = 3; i * i <= n; i+=2) {
            if (n % i == 0) {
                return false;
            } 
        }
        
        return true;
    }
}
