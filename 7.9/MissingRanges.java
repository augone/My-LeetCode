import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		int[] arr = {-1};//{{1,1},{1,1},{1,3}};
		sop(findMissingRanges(arr, -2, -1));

	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
		if(nums == null||nums.length == 0||lower>upper||nums[nums.length-1]<lower||nums[0] > upper)
		{
			if(upper>=lower)
			{
				list.add(upper>lower?lower+"->"+upper:Integer.toString(lower));
			}
			return list;
		}
		if(lower == upper)
		{
		    for(int num : nums)
		    {
		        if(num == lower)
		            return list;
		    }
		    list.add(Integer.toString(lower));
		    return list;
		}
		int pre = lower;
		boolean flag = true;
		for(int num : nums)
		{
			if(num >= pre&&num <=upper)
			{
				if(flag) pre = pre == lower?pre-1:pre;
				flag = false;
				if(num - pre > 1)
				{
					if(num - pre == 2)
					{
						list.add(Integer.toString(pre+1));
					}
					else
					{
						list.add(Integer.toString(pre+1) + "->"+Integer.toString(num - 1));
					}
					
				}
				if(num > pre)
				{
					pre = num;
				}
			}
		}
		if(upper - pre > 0)
		{
			if(upper - pre == 1)
			{
				list.add(Integer.toString(upper));
			}
			else
			{
				list.add(Integer.toString(pre+1) + "->" + Integer.toString(upper));
			}
		}
		return list;
    }
}