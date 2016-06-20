/**
The following solution is Memory Limit Exceeded when n = Integer.MAX_VALUE;
*/

/* import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		int[] test = {1,2,3,10};
		sop(minPatches(test,30));
		

	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	static int[] arr;
    public static int minPatches(int[] nums, int n) {
		arr = new int[n];
        int res = 0;
		int next = 0;
		
		Arrays.sort(nums);
		initializeArr(nums,n);
		
		for(int i = 0 ; i < n; i++)
		{
			if(arr[i]!= i+1)
			{
				res++;
				goPatch(i);
				for(int num:arr)
				{
					System.out.print(num);
				}
				sop(""+i);
			}
			
				
		}
		return res;
		
    }
	public static void goPatch(int pos)
	{
		int extend = pos+1;
		//arr[pos] = extend;
		for(int i = pos;i<arr.length;i++)
		{
			
			while(i<arr.length&&arr[i]>0)
			{
				i++;
			}
			if(i == arr.length)
				break;
			for(int count = 0;i+count<arr.length&& count < extend;count++)
			{
				arr[i+count] = i+count+1;
			}
			i += extend;
			while(i<arr.length&&arr[i]==0)
			{
				i++;
			}
			if(i == arr.length)
				break;
			
		}
			
	}
	public static void initializeArr(int[] nums, int n)
	{
		boolean flag = false;
		for(int i = 0 ; i < nums.length; i++)
		{
			if(nums[i]>=n) continue;
			if(arr[nums[i]-1] == nums[i])
				flag = true;
			else 
				arr[nums[i]-1] = nums[i];
			for(int j = 0 ; j < nums[i]-(flag?0:1); j++)
			{
				if(arr[j]>0&&(j+nums[i])<n)
					arr[j+nums[i]] = nums[i]+arr[j];
			}
			flag =false;
		}
		for(int i: arr)
		{
			sop(i);
		}
	}
} */


//The following is a better solution.
import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		int[] test = {1,3};//{1,2,31,33};

	sop(minPatches(test,6));//2147483647));
		

	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	
    public static int minPatches(int[] nums, int n) {
		
        int res = 0;
		int next = 0;
		Arrays.sort(nums);
		int count = 0;
		for(int i = 1;i <= n;)
		{
			/* if(i!=1)
				i--; */
			if(count<nums.length&&nums[count]<=i)
			{
				//sop("up"+i);
				//sop(count+" "  +nums[count]+"  "+  i);
				if(i>=Integer.MAX_VALUE/2)
					return res;
				i = (nums[count]==i?2*nums[count]:i+nums[count]);
				//sop(nums[count]);
				
				count++;
				//sop(count+"   "+  i);
			}
			else{
				res++;
				//sop(i);
				if(i>=Integer.MAX_VALUE/2)
					return res;
				i = 2*i;
			}
			//i--;
		}
		return res;
		
		
    }
	
}

/**A supper good solution
public class Solution {
    public int minPatches(int[] nums, int n) {
        int cnt;
        int patches = 0;
        long nextToMaxSum = 1;

        for(cnt = 0; cnt<nums.length && nextToMaxSum-1<n; ){
            if(nextToMaxSum < nums[ cnt ]){ 
                nextToMaxSum = nextToMaxSum << 1;
                patches++;
            } else {
                nextToMaxSum += nums[ cnt++ ];
            }
        }

        while(nextToMaxSum-1 < n){
            nextToMaxSum = nextToMaxSum << 1;
            patches++;
        }

        return patches;
    }
}

*/