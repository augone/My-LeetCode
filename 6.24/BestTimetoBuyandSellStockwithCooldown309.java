import java.util.*;
//the following method is TLE;
class Solution {
	public static void main(String[] args )
	{
	int[] prices = {1, 2, 3, 0, 2};
		sop(maxProfit(prices));
		//sop(maxCoins(arr));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static int maxProfit(int[] prices) {
		/* if (prices == null || prices.length < 2) return 0;
		int buy = -prices[0], sell = Integer.MIN_VALUE, rest = 0;
		for (int i = 1; i < prices.length; i++) {
			int tmp = buy;
			buy = Math.max(buy, rest - prices[i]);
			rest = Math.max(rest, sell);
			sell = tmp + prices[i];
		}
		return Math.max(buy, Math.max(sell, rest)); */
        if(prices == null||prices.length < 2)
			return 0;
		int Len = prices.length;
		int b0 = -prices[0];
		int b1 = b0;
		
		int s0 = 0;
		int s1 = 0;
		int s2 = 0;
		
		//int rest = 0;
		for(int i = 1; i < Len ; i++)
		{
			b0 = Math.max(s2 - prices[i], b1);
			s0 = Math.max(b1+prices[i],s1);
			s2 = s1; s1 = s0; b1 = b0;
			
			/* int temp = after_buy;
			rest = Math.max(after_sell,rest);
			after_buy = Math.max(rest - prices[i], after_buy);
			after_sell = temp + prices[i]; */
			
			
		}
		return s0;
    }
}