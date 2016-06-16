import java.util.*;
class Solution {
	
	public static void main(String[] args)
	{
		int[] test = {1,1,1,2,2,3};
		sop(topKFrequent(test,1));
	}
	public static void sop(Object obj )
	{
		System.out.println(obj);
	}
    public static List<Integer> topKFrequent(int[] nums, int k) {
        /* Arrays.sort(nums); */
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++)
		{
			map.put(nums[i],map.getOrDefault(nums[i],0)+1);
		}
		sop(map);
		List<Integer>[] arr = new List[nums.length + 1];
		for(int key: map.keySet())
		{
			if(arr[map.get(key)]==null)
			
				arr[map.get(key)] = new LinkedList<Integer>();
				
			
			arr[map.get(key)].add(key);
		}
		LinkedList<Integer> res = new LinkedList<>();
		
		for(int num = arr.length-1; num>=0 && k > 0; num--)
		{
			if(arr[num]!=null)
			{
				res.addAll(arr[num]);
				k -= arr[num].size();
			}
				
			
		}
		/* for(int i = 0; i < nums.length; i++)
		{
			if(map.containsKey(nums[i]))
			{
				map.put(nums[i],map.getOrDefault(nums[i])+1);
			}
			else
			{
				map.put(nums[i],1);
			}
		} */
		return res;
    }
}