// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete at most two transactions.

// Note:
// You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<2){
            return 0;
        }

        int[] forwards = new int[len];

        int low = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i<len; i++){

            if(prices[i]<low){
                low = prices[i];
            }

            profit = Math.max(profit, prices[i]-low);

            forwards[i] = profit;

            // if(prices[i]>low){
            //  profit = Math.max(profit, prices[i]-low);
            // }else{
            //  low = prices[i];
            // }

            // forwards[i] = profit;
        }

        int[] backwards = new int[len];
        profit = 0;
        int high = prices[len-1];
        for(int i = len-2; i>=0; i--){
            if(high<prices[i]){
                high = prices[i];
            }
            profit = Math.max(profit, high-prices[i]);
            backwards[i] = profit;
        }

        int maxProfit = profit;
        for(int i = len-1; i>=1; i--){
            int tempProfit = backwards[i]+forwards[i-1];
            maxProfit = Math.max(maxProfit, tempProfit);
        }
       

        return maxProfit;
    }
}
