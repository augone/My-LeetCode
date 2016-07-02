//This is the real two pointer solution.

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3)
            return 0;
        int res = 0;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length-2; i++)
        {
            int left = i+1;
            int right = nums.length - 1;
            while(left < right)
            {
                while(left<right&&nums[i] + nums[left] + nums[right] >= target)
                    right--;
                int temp = right;
                while(left < right)
                {
                    res++;
                    right--;
                }
                right = temp;
                left++;
            }
        }
        return res;
    }
}







//The following method does not work for no good reason
/* import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		int[] test = {1,2,-2};// str = "123";
		sop(threeSumSmaller(test,1));
		//sop(str.substring(0,1));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	static int res = 0;
    public static int threeSumSmaller(int[] nums, int target) {
        if(nums == null||nums.length <3)
			return 0;
		Arrays.sort(nums);
		
		for(int i = 0 ; i< nums.length-2; i++)
		{
			sop("num1         :"+nums[i]);
			if(nums[i]>0&&nums[i]>=target)
				continue;
			dfs(nums[i],i+1,1,target,nums);
			
			sop(res);
		}
		return res;
    }
	public static void dfs(int sum, int pos, int level, int target, int[] nums)
	{
		//sop("level:"+level);
		if(level == 3)
		{
			if(sum < target)
			{
				res++;
			}
			return;
		}
		for(; pos < nums.length - (2-level); pos++)
		{
			if(level == 1)
				sop("num2         :"+nums[pos]);
			if(level == 2)
				sop("num3         :"+nums[pos]);
			if(nums[pos]<=0||(nums[pos]>0&&nums[pos] + sum < target))
				dfs(nums[pos] + sum,pos+1,level+1,target,nums);
			else 
				return;
		}
	}
} */