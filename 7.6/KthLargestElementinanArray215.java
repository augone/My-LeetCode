import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
			public int compare(Integer a, Integer b)
			{
				return a - b;
			}
		});		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		sop(queue.poll());

	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
			public int compare(Integer a, Integer b)
			{
				return a - b;
			}
		});
		for(int i = 0 ; i < nums.length; i++)
		{
			if(queue.size() == k)
			{
			    if(queue.peek()< nums[i])
    				queue.poll();
    			else 
    			    continue;
			}
            queue.add(nums[i]);
		}
		return queue.poll();    
        
    }
}