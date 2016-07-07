import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		long a = 45;
		long b = 31;
		sop(a/b);
		/* PriorityQueue<Integer> queue = new PriorityQueue<>();//(new Comparator<Integer>(){
			/* public int compare(Integer a, Integer b)
			{
				sop(a+" Compare to:"+b);
				return -1;
			}
		}); */
		/* queue.offer(1);
		sop("");
		sop(queue);
		queue.offer(2);
				sop("");
		sop(queue);
		queue.offer(89);
		sop("");
		sop(queue);
		queue.offer(34);
		sop("");
		sop(queue);
		queue.offer(2);
				sop("");
		sop(queue);

		while(queue.size() > 0)
		{
			sop(queue.poll());
		} */
		//sop(str.substring(0,1)); */
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null||nums.length <=1||k < 1 || t < 0)
            return false;
        int base = Integer.MIN_VALUE;
        Map<Long, Long> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++)
        {
            long diff = (long)nums[i] - base;
            long multiple = diff/((long)t + 1);
            if(map.containsKey(multiple)||(map.containsKey(multiple - 1)&&diff - map.get(multiple-1) <= t)||(map.containsKey(multiple + 1)&&map.get(multiple+1) - diff <= t))
                return true;
            if(map.size() == k)
                map.remove((Long)((long)nums[i-k] - base)/((long)t + 1));
            map.put(multiple,diff);
        }
        return false;
    }

    
}
	