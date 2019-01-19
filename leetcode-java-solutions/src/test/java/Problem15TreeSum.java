import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Problem15TreeSum {
    @Test
    public void testThreeSum() {
        assertEquals(Arrays.asList(Arrays.asList(-1, 0, 1), Arrays.asList(-1, -1, 2)), threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        assertEquals(Arrays.asList(Arrays.asList(0, 0, 0)), threeSum(new int[]{0, 0, 0}));
        assertEquals(Arrays.asList(Arrays.asList(0, 0, 0)), threeSum(new int[]{0, 0, 0, 0}));
        assertEquals(Arrays.asList(
                Arrays.asList(-4, 1, 3),
                Arrays.asList(-4, 0, 4),
                Arrays.asList(-2, 1, 1),
                Arrays.asList(-2, -2, 4),
                Arrays.asList(-5, 1, 4),
                Arrays.asList(0, 0, 0)
        ), threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0}));
    }

    private List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int a = 0; a < nums.length; a ++) {
            for (int b = a + 1; b < nums.length; b++) {
               for (int c = b + 1; c < nums.length; c++) {
                   if (nums[a] + nums[b] + nums[c] == 0) {
                       boolean isDuplicate = false;
                       List<Integer> res = Arrays.asList(nums[a], nums[b], nums[c]);
                       res.sort(Integer::compareTo);

                       for (List<Integer> temp : result) {
                           if (res.equals(temp)) {
                                isDuplicate = true;
                                break;
                           }
                       }
                       if (!isDuplicate) result.add(res);
                   }
               }
            }
        }

        return result;
    }
}
