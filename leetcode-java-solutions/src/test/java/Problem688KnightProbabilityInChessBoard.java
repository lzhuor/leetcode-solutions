import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem688KnightProbabilityInChessBoard {
    @Test
    public void test() {
        double precision = 0.00001;
        assertEquals(0.0625, knightProbability(3, 2, 0, 0), precision);
    }

    /**
     *
     * @param N N * N chess board (0,0) -> (N-1, N-1)
     * @param K steps
     * @param r start row (from 0)
     * @param c start col (from 0)
     */
    private double knightProbability(int N, int K, int r, int c) {
        double[][] dp0 = new double[N][N];
        dp0[r][c] = 1.0;
        int[][] dirs = new int[][]{
                {1, 2},
                {-1, -2},
                {1, -2},
                {-1, 2},
                {2, 1},
                {-2, -1},
                {2, -1},
                {-2, 1}
        };

        for (int k = 0; k < K; k++) {
            double[][] dp1 = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int m = 0; m < 8; m++) {
                        int x = j + dirs[m][0];
                        int y = i + dirs[m][1];
                        if (x < 0 || y < 0 || x > (N-1) || y > (N-1)) continue;
                        dp1[i][j] += dp0[y][x];
                    }
                }
            }

            dp0 = dp1;
        }

        double total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                total += dp0[i][j];
            }
        }

        return total / Math.pow(8, K);
    }
}
