package practice;

import org.junit.Test;

public class PrimeFactorization {
    @Test
    public void test() {
        findPrime(7);
        System.out.println("");
        findPrime(8);
        System.out.println("");
        findPrime(315);
    }

    private void findPrime(int num) {

        if (num % 2 == 0 && num / 2 == 1) {
            System.out.print(2 + " ");
            return;
        }

        if (num % 2 == 0) {
            System.out.print(2 + " ");
            findPrime(num / 2);
            return;
        }

        for (int i = 3; i < Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                System.out.print(i + " ");
                findPrime(num / i);
                return;
            }
        }

        System.out.print(num);
    }
}
