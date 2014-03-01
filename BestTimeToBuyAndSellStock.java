// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.


// Later elements as sell, earlier elements as buy. Forward searching: update low. Backwards searching: update high.
public class Solution {
    public int maxProfit(int[] prices) {
    	int len = prices.length;
    	if(len<2){
    		return 0;
    	}

    	int max = prices[len-1];
    	int profit = 0;

    	for(int i = len-1; i>=0; i--){
    		if(max<prices[i]){
    			max = prices[i];
    		}
    		profit = Math.max(max-prices[i], profit);
    	}
    	return profit;
    }
}