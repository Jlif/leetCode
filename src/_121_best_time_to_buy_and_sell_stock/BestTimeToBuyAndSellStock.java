package _121_best_time_to_buy_and_sell_stock;

/**
 * @author jiangchen
 * @date 2021/06/09
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }


    public static void main(String[] args) {
        BestTimeToBuyAndSellStock demo = new BestTimeToBuyAndSellStock();
        System.out.println(demo.maxProfit(new int[]{7, 1, 5, 3, 6, 1, 9, 4}));
        System.out.println(demo.maxProfit(new int[]{7, 6, 4, 3, 2, 1}));
    }
}
