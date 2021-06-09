package _122_best_time_to_buy_and_sell_stock;

/**
 * @author jiangchen
 * @date 2021/06/09
 */
public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, tmp - price);
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 demo = new BestTimeToBuyAndSellStock2();
        System.out.println(demo.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

}
