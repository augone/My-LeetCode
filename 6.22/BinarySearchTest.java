import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		//if (nums == null || nums.length == 0) return new ArrayList<>();
		int[] nums = {3,13,42,24,9};
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        int[] bit = new int[nums.length + 1];
        for (int i : nums) sop(Arrays.binarySearch(tmp, i));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}