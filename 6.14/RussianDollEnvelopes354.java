import java.util.*;
class RussianDollEnvelopes
{
	public static void main(String[] args)
	{
		int[][] arrs = {{5,4},{6,4},{6,7},{2,3},{0,0},{50,50},{45,60}};
		sop(maxEnvelopes(arrs));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static int maxEnvelopes(int[][] envelopes) 
	{
        Arrays.sort(envelopes,new Comparator<int[]>(){
			public int compare(int[] a, int[] b)
			{
				return a[0] - b[0];
			}
		});
		int[] dp = new int[envelopes.length];
		int maxLen = 0;
		for(int i = 0; i < envelopes.length; i++)
		{
			dp[i] = 1;
			for(int j = 0; j < i; j++)
			{
				if(envelopes[j][0]<envelopes[i][0]&&envelopes[j][1]<envelopes[i][1])
				{
					dp[i] = Math.max(dp[j] + 1,dp[i]);
					
				}
				
			}
			maxLen = Math.max(maxLen,dp[i]);
		}
		return maxLen;
    }
}