import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		int[] arr = {1,567,456,83,22,6,9};
		sop(maximumGap(arr));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static int maximumGap(int[] nums) {
        if(nums == null||nums.length < 2)
			return 0;
		int len = nums.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int num:nums)
		{
			min = Math.min(num,min);
			max = Math.max(num,max);
		}
		int[] lowerBound = new int[len - 1];
		int[] upperBound = new int[len - 1];
		
		Arrays.fill(lowerBound, Integer.MAX_VALUE);
		Arrays.fill(upperBound, Integer.MIN_VALUE);
		
		int gap = (int)Math.ceil((float)(max - min)/(len - 1));
		if(gap == 0)
		    return 0;
		
		for(int num:nums)//for(int i = 0; i < len ;i++)
		{
		    if(num == min||num == max) continue;
			int idx = (num - min)/gap;
			lowerBound[idx] = Math.min(lowerBound[idx],num);
			upperBound[idx] = Math.max(upperBound[idx],num);
		}
		int maxGap = Integer.MIN_VALUE;
		int pre = min;
		for(int i = 0 ; i < len-1 ; i++)
		{
			if(lowerBound[i] == Integer.MAX_VALUE&&upperBound[i] == Integer.MIN_VALUE)
				continue;
			maxGap = Math.max(maxGap,lowerBound[i] - pre);
			pre = upperBound[i];
			
		}
		return Math.max(maxGap,max - pre);
    }
}