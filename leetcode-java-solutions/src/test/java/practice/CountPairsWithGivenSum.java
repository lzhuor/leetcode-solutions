package practice;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class CountPairsWithGivenSum {
    @Test
    public void test() {
        assertEquals(2, countPairsWithGivenSum(new int[]{1, 5, 7, -1}, 6));
        assertEquals(3, countPairsWithGivenSum(new int[]{1, 5, 7, -1, 5}, 6));
        assertEquals(6, countPairsWithGivenSum(new int[]{1, 1, 1, 1}, 2));
        assertEquals(9, countPairsWithGivenSum(new int[]{10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1}, 11));
    }

    private int countPairsWithGivenSum(int[] arr, int sum){
        int pairs = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int remaining = sum - num;
            int occurrences = map.getOrDefault(remaining, 0);
            // Each occurrence means a pair
            pairs += occurrences;
            // then ++ occurrence of current num
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return pairs;
    }
}
