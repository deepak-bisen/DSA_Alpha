//leetcode question no. 121 best time to buy and sell stocks
class BuyAndSellStocks {
    public int maxProfit(int[] prices) {
int buyPrice = Integer.MAX_VALUE;
int maxProfit = 0;
for(int i = 0; i < prices.length; i++){
   //profit
    if(buyPrice < prices[i]){
        //today's profit
        int profit = prices[i] - buyPrice;
        maxProfit = Math.max(maxProfit, profit);
    }else
        buyPrice = prices[i];
        
   }
   return maxProfit;
    }
}
