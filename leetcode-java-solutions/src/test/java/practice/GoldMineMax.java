package practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoldMineMax {
    @Test
    public void test() {
        int gold[][]= {
            {1, 3, 1, 5},
            {2, 2, 4, 1},
            {5, 0, 2, 3},
            {0, 6, 1, 2}
        };

        // Time: O(m * n), rows * cols
        // Space: O(m * n)
        // Backtrace
        assertEquals(16, findMax(gold, gold.length, gold[0].length));
    }

    private int findMax(int[][] gold, int rows, int cols) {
        int[][] goldTable = new int[rows][cols];

        for (int col = cols - 1; col >= 0; col--) {
            for (int row = 0; row < rows; row++) {
                int right = col == cols - 1 ? 0 : goldTable[row][col + 1];
                int rightUp = (row == 0 || col == cols - 1) ? 0 : goldTable[row - 1][col + 1];
                int rightDown = (row == rows -1 || col == cols - 1) ? 0 : goldTable[row + 1][col + 1];

                goldTable[row][col] = gold[row][col] + Math.max(right, Math.max(rightUp, rightDown));
            }
        }

        int max = 0;

        for (int i = 0; i < rows; i ++) {
            max = Math.max(max, goldTable[i][0]);
        }

        return max;
    }
}
