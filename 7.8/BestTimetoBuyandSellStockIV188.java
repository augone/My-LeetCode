public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null ||prices.length < 2)
            return 0;
        int len = prices.length;
		if( k >= len/2)
			return justBuy(prices);
		int[][] dp = new int[k+1][len];
		for(int transcCount = 1; transcCount < k+1; transcCount++)
		{
			int tempMax = -prices[0];
			for(int day = 1; day < len; day++)
			{
				dp[transcCount][day] = Math.max(dp[transcCount][day - 1], tempMax + prices[day]);
				tempMax = Math.max(dp[transcCount-1][day - 1]- prices[day], tempMax);
			}
		}
		return dp[k][len - 1];
    }
	public int justBuy(int[] prices)
	{
		int max = 0;
		for(int i = 1 ; i < prices.length; i++)
		{
			if(prices[i] > prices[i-1]) max += prices[i] - prices[i-1];
		}
		return max;
		
	}
}