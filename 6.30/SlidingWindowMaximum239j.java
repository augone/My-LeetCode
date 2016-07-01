import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		int[] arr = {4,8,6,9,2,4,6,0,8,2,9};
		int[] res = maxSlidingWindow(arr,4);
		for(int x:res)
		{
			sop(x);
		}
		//sop();
		//sop(str.substring(0,1));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
			public int compare(Integer a, Integer b)
			{
				return b - a;
			}
				
		});
		for(int i = 0; i < k; i++)
		{
			queue.add(nums[i]);
		}
		
		if(k == 0 )
		    return new int[0];
		int Len = nums.length - k + 1;
		int[] res = new int[Len];
		res[0] = queue.peek();
		sop(res[0]);
		for(int i = k; i < nums.length; i++)
		{
			sop("queue:"+queue);
			queue.remove((Integer)nums[i-k]);
			queue.add(nums[i]);
			res[i - k + 1] = queue.peek();
		}
		return res;
    }
}