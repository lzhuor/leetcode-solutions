
class Solution {
    public int countPrimes(int n) {
        int counter = 0;
        
        for (int i = 2; i < n; i++) {
            counter += isPrime(i) ? 1 : 0;
        }
        
        return counter;
    }
    
    public boolean isPrime(int n) {        
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
