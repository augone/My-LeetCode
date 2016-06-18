class Solution {
	public static void main(String[] args )
	{
		int[] test1 = {1,2,2,2,2,2,2};
		int[] test2 = {6,3,5,2,1};
		sop(increasingTriplet(test1));
		sop(increasingTriplet(test2));

	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static boolean increasingTriplet(int[] nums) {
        if(nums.length < 3)
			return false;
		int Len = nums.length;
		int[] mark = new int[Len];
		mark[0] = 1;
		for(int i = 1;i<Len;i++)
		{
			int max = 0;
			for(int j = 0;j<i;j++)
			{
				
				if(nums[j]<nums[i])
				{
					max = Math.max(mark[j],max);
					if(max == 2)
						return true;
				}
			}
			if(max == 0)
				mark[i] = 1;
			else 
			{
				mark[i] = max+1;
			}
			sop("i:"+i+" and mark[i]:"+mark[i]);
				
		}
		return false;
    }
}


/* THIS IS ANOTHER SUPER FAST SOLUTION
public class Solution {
public boolean increasingTriplet(int[] nums) {
    if(nums == null || nums.length < 3){
        return false;
    }
    HashMap<Integer,Integer> map = new HashMap();
    int max = nums[nums.length - 1];
    for(int i = nums.length - 2; i >= 0; i-- ){

        map.put(i,max);
        max = Math.max(max,nums[i]);
    }

    int min = nums[0];
    for(int i = 1; i < nums.length -1; i++){
        if(nums[i]> min && nums[i]< map.get(i)){
            return true;
        }
        min = Math.min(min, nums[i]);
    }
    return false;
} */