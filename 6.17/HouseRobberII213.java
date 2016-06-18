
class Solution {
	public static void main(String[] args)
	{
		int[] house = {1,7,9,2};
		sop(rob(house));
	}
	public static void sop(Object obj )
	{
		System.out.println(obj);
	}
    public static int rob(int[] nums) {
		int Len = nums.length;
		
        if(Len == 0)
			return 0;
		if(Len == 1)
			return nums[0];
		int[] max1 = new int[Len];
		max1[0] = 0;
		max1[1] = nums[1];
		int[] max2 = new int[Len];
		max2[0] = nums[0];
		max2[1] = nums[0];
		boolean[] robbed1 = new boolean[Len];
		robbed1[0] = false;
		robbed1[1] = true;
		boolean[] robbed2 = new boolean[Len];
		robbed2[0] = true;
		robbed2[1] = false;
		
		for(int i = 2 ; i < Len; i++)
		{
			if(!robbed1[i-1])
			{
				max1[i] = max1[i-1] + nums[i];
				robbed1[i] = true;
			}
			else
			{
				if(max1[i-1]<max1[i-2]+nums[i])
					robbed1[i] = true;
				max1[i] = Math.max(max1[i-1],max1[i-2]+nums[i]);
			}
		}
		sop(max1[Len-1]);
		for(int i = 2 ; i < Len; i++)
		{
			if(!robbed2[i-1])
			{
				max2[i] = max2[i-1] + nums[i];
				robbed2[i] = true;
			}
			else
			{
				if(max2[i-1]<max2[i-2]+nums[i])
					robbed2[i] = true;
				max2[i] = Math.max(max2[i-1],max2[i-2]+nums[i]);
			}
		}
		sop(max2[Len-2]);
		return Math.max(max1[Len-1],max2[Len-2]);
		
	}
}