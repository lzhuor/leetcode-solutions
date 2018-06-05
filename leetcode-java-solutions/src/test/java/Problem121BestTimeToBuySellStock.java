import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem121BestTimeToBuySellStock {
    @Test
    public void test() {
        // This is when you can buy and sell at most once
        assertEquals(5, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(1, maxProfit(new int[]{2, 1, 2, 0, 1}));
        assertEquals(0, maxProfit(new int[]{7, 6, 4, 3}));
    }

    private int maxProfit(int[] prices) {
        int max = 0;
        int lowestBuy = Integer.MAX_VALUE;
        int lowestBuyIdx = 0;
        int index = 0;

        for (int price : prices) {
            if (lowestBuy != price && price < lowestBuy) {
                // if buy
                lowestBuy = price;
                lowestBuyIdx = index;
            }

            // if sell
            if (lowestBuyIdx < index && lowestBuy != Integer.MIN_VALUE) {
                max = Math.max(price - lowestBuy, max);
            }

            index++;
        }

        return max;
    }
}
