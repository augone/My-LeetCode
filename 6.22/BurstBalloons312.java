/* This is the kind of problem we use dynamic programming. WHY? 
it's very challenging to figure out what's the pattern of optimal 
burst order. In fact, there's no clear rule that makes sense. Shall 
we burst the balloon with maximum coins? Or shall we burst the one 
with least. This is the time we introduce Dynamic Programming, as we 
want to solve the big problem from small subproblem. It is clear that 
the amount of coins you gain relies on your previous steps. This is a 
clear signal of using DP.

The hard part is to define the subproblem. Think out what is clear 
in this problem? Let's scale this problem down. What is the fact you 
know for sure? Say if the array has only 1 balloon. The maximum coin 
would be the coin inside this ballon. This is the starting point! So 
let's move on to array with 2 balloons. Here, we have 2 cases, which 
of the balloon is the last one. The last one times the coins in 
boundary is the gain we get in the end. That is to say, last balloon 
is the key. Since we don't know the pattern of optimal. We just blindly 
iterate each balloon and check what's total gain if it's the last ballon.


Let's use dp[i][j] to denote maximum gain from balloon range i to j. 
We try out each balloon as last burst in this range. Then the 
subproblem relation would be:

foreach k in i to j: dp[j][i] = max(array[j-1]array[k]array[i+1] + 
dp[j][k-1] + dp[k+1][i], dp[j][i]); */


import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		int[] arr = {3, 1, 5, 8};
		sop(maxCoins(arr));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static int maxCoins(int[] nums) {
        if(nums == null||nums.length == 0)
			return 0;
		int Len = nums.length;
		if(Len == 1)
			return nums[0];
		int[] rep = new int[Len + 2];
		rep[0] = rep[Len+1] = 1;
		for(int i = 1;i<Len+1;i++)
			rep[i] = nums[i-1];
		int[][] dp = new int[Len+2][Len+2];
		for(int r = 1; r < Len+1;r++)
		{
			for(int l = r; l>=1;l--)
			{
				for(int k = l; k <= r; k++)
				{
					//sop("dp["+l+"]["+r+"]:"+dp[l][r]);
					dp[l][r] = Math.max(dp[l][r],rep[l-1]*rep[k]*rep[r+1]+dp[k+1][r]+dp[l][k-1]);
					//sop("after : dp["+l+"]["+r+"]:"+dp[l][r]);
				}
			}
		}
		return dp[1][Len];
    }
}