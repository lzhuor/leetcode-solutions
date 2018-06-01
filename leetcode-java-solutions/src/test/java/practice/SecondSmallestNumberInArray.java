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
        int firstLargest = Integer.MAX_VALUE;
        int secondLargest = Integer.MAX_VALUE;

        for (int num: list) {
            if (num == firstLargest) continue;
            if (num < firstLargest) {
                secondLargest = firstLargest;
                firstLargest = num;
            } else {
                if (num < secondLargest) {
                    secondLargest = num;
                }
            }
        }

        return secondLargest;
    }
}
