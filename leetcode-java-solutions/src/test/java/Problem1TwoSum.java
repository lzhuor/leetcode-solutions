import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.factory.Maps;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem1TwoSum {
    @Test
    public void FindTwoSumShouldReturnCorrectResult() {
        // Given k: target, v: numbers
        MutableMap<Integer, int[]> testCases = Maps.mutable.with(
                // case 1
                9, new int[]{2, 7, 11, 15},
                // case 2
                11, new int[]{2, 4, 7, 9, 15},
                // case 3
                100, new int[]{1, 2, 3, 4}
        );

        MutableMap<Integer, int[]> answers = Maps.mutable.with(
                // answer of case 1
                9, new int[]{2, 7},
                11, new int[]{4, 7},
                100, null
        );

        // Then
        testCases.forEachKeyValue((target, numbers) -> assertThat(findTwoSum(numbers, target)).isEqualTo(answers.get(target)));
    }

    private int[] findTwoSum(int[] numbers, int target) {
        MutableMap<Integer, Integer> remainingValuesTable = Maps.adapt(new HashMap<Integer, Integer>());
        List<Integer> numbersList = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        for (Integer num : numbersList) {
            if (num.equals(remainingValuesTable.get(target - num))) {
                return new int[]{target - num, num};
            } else {
                remainingValuesTable.put(num, target - num);
            }
        }

        return null;
    }
}
