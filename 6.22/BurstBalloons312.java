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
					sop("dp["+l+"]["+r+"]:"+dp[l][r]);
					dp[l][r] = Math.max(dp[l][r],rep[l-1]*rep[k]*rep[r+1]+dp[k+1][r]+dp[l][k-1]);
					sop("after : dp["+l+"]["+r+"]:"+dp[l][r]);
				}
			}
		}
		return dp[1][Len];
    }
}