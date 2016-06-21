import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		int[] arr = {1, -1, 5, -2, 3};
		sop(maxSubArrayLen(arr,3));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static int maxSubArrayLen(int[] nums, int k) {
        if(nums == null||nums.length == 0)
			return 0;
		int Len = nums.length;
		if(Len == 1)
			return nums[0] == k?1:0;
		int[] sums = new int[Len+1];
		sums[0] = 0;
		Map<Integer,Integer> map = new HashMap<>();
		map.put(0,0);
		int sum = 0;
		for(int i = 0; i < Len; i++)
		{
			sums[i+1] = sum+nums[i];
			sum += nums[i];
			map.put(sums[i+1],i+1);
			sop(sums[i+1]+"   "+i);
		}
		int maxLen = 0 ;
		for(int i = 0 ; i < Len+1 ; i++)
		{
			Integer in = map.get(sums[i]+k);
			if(in != null&&in.intValue() - i > maxLen)
			{
				if(in.intValue() == Len)
					return Len - i;
				else
					
					maxLen = in.intValue() - i;
			}
			
		}
		return maxLen;
    }
}