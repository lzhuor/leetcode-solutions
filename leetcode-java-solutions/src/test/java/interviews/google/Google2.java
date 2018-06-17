package interviews.google;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Google2 {
    @Test
    public void test() {
//        assertEquals(-1, solution(new int[]{1, 4, 3, 2, 5}, 1, 3));
        assertEquals(6, solution(new int[]{1, 2, 7, 6, 4, 3, 5}, 2, 2));
//        assertEquals(3, solution(new int[]{1, 4, 3, 2, 5}, 1, 2));
    }

    public int solution(int[] A, int K, int M) {
        int totalBloom = Integer.MIN_VALUE;
        int day = 1;
        String[] filled = new String[A.length];
        Arrays.fill(filled, "n");

        for (int a : A) {
            filled[a - 1] = "y";
            int longGroups = getLongGroups(filled, K);
            if (longGroups == M) {
                totalBloom = day;
            }
            day++;
        }

        if (totalBloom == Integer.MIN_VALUE) return -1;

        return totalBloom;
    }

    public int getLongGroups(String[] result, int K) {
        String s = String.join("", result);
        String[] groups = s.split("n");

        int counter = 0;

        for (String group: groups) {
            if (group.isEmpty()) continue;
            if (group.length() >= K) {
                counter += 1;
            }
        }

        return counter;
    }
}
