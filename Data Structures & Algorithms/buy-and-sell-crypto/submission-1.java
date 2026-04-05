class Solution {
    public int maxProfit(int[] prices) {
        int profit = Integer.MIN_VALUE;
        int currentProfit = 0;
        int i = 0;
        int j = i+1;

        if(prices.length == 1){
            return currentProfit;
        }
        while(j < prices.length){
            currentProfit = prices[j] - prices[i];
            if(currentProfit < 0){
                i++;
                continue;
            }
            profit = currentProfit > profit ? currentProfit : profit;
            j++;
        }
        return profit;
    }
}
