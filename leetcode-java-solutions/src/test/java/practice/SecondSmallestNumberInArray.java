package practice;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SecondSmallestNumberInArray {
    @Test
    public void test() {
        // case 1
        assertThat(findSecondSmallest(new int[]{12, 13, 1, 10, 34, 1})).isEqualTo(10);
        // case 2
        assertThat(findSecondSmallest(new int[]{10, 10, 10, 1, 50, 50})).isEqualTo(10);
        // case 3
        assertThat(findSecondSmallest(new int[]{1, 2, 3, 10, 100, 200})).isEqualTo(2);
    }

    private Integer findSecondSmallest(int[] list) {
        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num: list) {
            if (num == firstSmallest) continue;
            if (num < firstSmallest) {
                secondSmallest = firstSmallest;
                firstSmallest = num;
            } else {
                if (num < secondSmallest) {
                    secondSmallest = num;
                }
            }
        }

        return secondSmallest;
    }
}
