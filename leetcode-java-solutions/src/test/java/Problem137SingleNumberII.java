import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class Problem137SingleNumberII {
    @Test
    public void testSingleNumberII() {
        // Not using bitwise
        assertEquals(3, singleNumberNonBitwise(new int[]{ 2,2,3,2 }));
        assertEquals(99, singleNumberNonBitwise(new int[]{ 0,1,0,1,0,1,99 }));
    }

    private int singleNumberNonBitwise(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return recursiveSingleNumber(list);
    }

    private Integer recursiveSingleNumber(List<Integer> nums) {
        if (nums.size() % 3 != 0 && nums.size() == 1) return nums.get(0);

        int wall = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i : nums) {

            if (i < wall) {
                left.add(i);
            }

            if (i > wall) {
                right.add(i);
            }
        }

        if (nums.size() - left.size() - right.size() == 1) return wall;

        return recursiveSingleNumber(left.size() % 3 == 0 ? right : left);
    }
}
