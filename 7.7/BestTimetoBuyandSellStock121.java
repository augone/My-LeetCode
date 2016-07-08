public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2)
            return 0;
        int maxProfit = 0;
        int min = prices[0];
        for(int p: prices)
        {
            if(p > min)
                maxProfit = Math.max(maxProfit,p - min);
            else 
                min = p;
        }
        return maxProfit;
    }
}
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2)
        {
            return 0;
        }
        int min = prices[0];
        int max = prices[0];
        int difference = max - min;
        int result = difference;
        for(int i = 1; i < prices.length; i++)
        {
            max = Math.max(max,prices[i]);

            if(max != prices[i])
            {
                max = prices[i];
                min = Math.min(min,prices[i]);
                continue;
            }

            difference = max -min;
            result = Math.max(result,difference);
        }
        return result;
        
    }
}