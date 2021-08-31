package leetcode.editor.cn;

//Java：买卖股票的最佳时机 II
public class BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution_122 solution = new Solution_122();
        // TO TEST
        int prices[] = new int[]{7, 1, 5, 3, 6, 4};
        int i = solution.maxProfit(prices);
        System.out.println(i);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_122 {
    public int maxProfit(int[] prices) {
        int lastPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > lastPrice) {
                maxProfit += prices[i] - lastPrice;
            }
            lastPrice = prices[i];
        }
        return maxProfit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
