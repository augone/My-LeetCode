import java.util.*;
class Solution {
	public static void main(String[] args)
	{

	}
	public static void sop(Object obj )
	{
		System.out.println(obj);
	}
    public int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();
		if(nums1 == null || nums2 == null)
			return new int[0];
		
		int len1 = nums1.length;
		int len2 = nums2.length;
		if(len1 == 0 || len2 == 0)
			return new int[0];
		
        Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		int count2 = 0;
		for(int i = 0; i < nums1.length; i++)
		{
			for(;count2<nums2.length;count2++)
			{
				if(nums2[count2]>nums1[i])
					break;

				if(nums1[i]==nums2[count2])
				{
					if(!list.contains(nums1[i]))
						list.add(nums1[i]);
					count2++;
					break;
				}
				
					
				
			}
			if(count2 == nums2.length)
				break;
		}
		int[] arr = new int[list.size()];
		for(int i = 0; i < list.size(); i++)
		{
			arr[i] = list.get(i);
		}
		return arr;
    }
}