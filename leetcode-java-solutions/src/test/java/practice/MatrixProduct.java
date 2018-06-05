package practice;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class MatrixProduct {
    @Test
    public void test() {
        int[][] matrixA = {
                {3,5,7},
                {9,17,12},
                {32,21,5}
        };
        int[][] matrixB = {
                {1,3,5},
                {7,9,11},
                {13,15,17}
        };

        int[][] result = {
                {129, 159, 189},
                {284, 360, 436},
                {244, 360, 476}
        };

        assertTrue(Arrays.deepEquals(result, product(matrixA, matrixB)));
    }

    private int[][] product(int[][] a, int[][] b) {
        int[][] result = new int[a.length][b[0].length];
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < b[0].length; col++) {
                for (int i = 0; i < b[row].length; i++) {
                    if (a[row][i] != 0) {
                        result[row][col] += a[row][i] * b[i][col];
                    }
                }
            }
        }

        return result;
    }
}
