package practice;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PeterTest2 {
    @Test
    public void test() {
        assertEquals(0, findApples(new int[]{4900}));
        assertEquals(2, findApples(new int[]{4650, 150, 150, 150}));
        assertEquals(3, findApples(new int[]{4850, 100, 30, 30, 100, 50, 100}));
    }

   private int findApples (int[] arr) {
        int totalWeights = arr[0];

        if (arr.length == 1) {
            return 0;
        }

        int[] apples = Arrays.copyOfRange(arr, 1, arr.length);
        Arrays.sort(apples);

        int i = 0;
        while (totalWeights <= 5000 && i < apples.length) {
            if (totalWeights + apples[i] <= 5000) {
                totalWeights += apples[i];
                i++;
            } else {
                break;
            }
        }

        return i;
   }
}
