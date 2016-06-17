
class Solution {
	public static void main(String[] args)
	{
		int[] house = {3,0,0,0,0,0,7};
		sop(rob(house));
	}
	public static void sop(Object obj )
	{
		System.out.println(obj);
	}
    public static int rob(int[] nums) {
        if(nums == null||nums.length<1) return 0;
		int Len = nums.length;
		
		int[] dp = new int[Len];
		dp[0] = nums[0];
		if(Len != 1) 
		{
			int max = nums[0];
			dp[1] = Math.max(max,nums[1]);

			for(int i = 2; i < Len ; i++)
			{
				dp[i] = nums[i]+(i-3>=0?Math.max(dp[i-3],dp[i-2]):dp[i-2]);
				
			}
			return Math.max(dp[Len-1],dp[Len-2]);
		}
		else
			return dp[Len - 1];
    }
}