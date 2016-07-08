public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;
        int maxProfit = 0;
        int bought = prices[0];
        for(int p: prices)
        {
            if(p > bought) 
                maxProfit += p - bought;
            bought = p;
        }
        return maxProfit;
    }
}