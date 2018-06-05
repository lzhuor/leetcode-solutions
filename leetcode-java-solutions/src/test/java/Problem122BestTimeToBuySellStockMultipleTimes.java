import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem122BestTimeToBuySellStockMultipleTimes {
    @Test
    public void test() {
        // This is when you can buy and sell at most once
        assertEquals(7, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(4, maxProfit(new int[]{1, 2, 3, 4, 5}));
        assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    private int maxProfit(int[] prices) {
        int total = 0;
        int lowestBuy = Integer.MAX_VALUE;
        int lastProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];

            if (price < lowestBuy) {
                lowestBuy = price;
            } else if (price > lowestBuy) {
                int profit = Math.max(lastProfit, price - lowestBuy);
                total += profit - lastProfit;
                lastProfit = profit;

                // above is the best deal (caught a bottom and top)
                if (i + 1 < prices.length && prices[i + 1] < price) {
                    lastProfit = 0;
                    lowestBuy = Integer.MAX_VALUE;
                }
            }
        }

        return total;
    }
}
