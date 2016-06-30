import java.util.*;

class Solution {
	public static void main(String[] args )
	{
		int[] arr = {1,1,2,5,6,2,7,8,9,9
		,5,8,6,9,8,5,85,5,5,8,55,8,5,78,8,38
		/* ,5,8,6,9,8,5,85,5,5,8,55,8,5,78,8,38
		,5,8,6,9,8,5,85,5,5,8,55,8,5,78,8,38
		,5,8,6,9,8,5,85,5,5,8,55,8,5,78,8,38 */
		};//{3,3,1,2,3,2,3,1};
		long startTime=System.currentTimeMillis();   //获取开始时间
		//伪代码
		sop(permuteUnique(arr));
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		//sop(list);
		//sop(str.substring(0,1));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	/* public static List<List<Integer>> permuteUnique(int[] nums) {
		boolean[] visited = new boolean[nums.length];
		Arrays.sort(nums);
		List<List<Integer>> ret = new ArrayList<>();
		dfs(nums, visited, new ArrayList<>(), ret);
		return ret;
	}

	private static  void dfs(int[] nums, boolean[] visited, List<Integer> path, List<List<Integer>> ret) {
		if (path.size() == nums.length) {
			ret.add(path);
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1])) {
				continue;   // remove duplicates
			}
			List<Integer> p = new ArrayList<>(path);
			p.add(nums[i]);
			visited[i] = true;
			dfs(nums, visited, p, ret);
			visited[i] = false;  // recover
		}
	}	 */
	//The following is my Solution, not good bu works;
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
		if(nums==null||nums.length==0)
			return list;
		Arrays.sort(nums);
		boolean[] index = new boolean[nums.length];
		List<Integer> next = new ArrayList<>();
		HashSet<List<Integer>> set = new HashSet<>();
		backtrack(list,index,nums,next);
        //list.addAll(set);
		return list;
    }
	public static void backtrack(List<List<Integer>> list ,boolean[] index,int[] nums,List<Integer> next)
	{
		if(next.size() == nums.length)
		{
			list.add(new ArrayList<Integer>(next));
		}
		for(int pos = 0 ; pos < nums.length; pos++)
		{
			if(index[pos]||(pos > 0&&nums[pos] == nums[pos-1]&&!index[pos-1]))
				continue;

			index[pos] = true;
			next.add(nums[pos]);
			backtrack(list,index,nums,next);
			index[pos] = false;
			next.remove(next.size()- 1);
			
		}
	}

}









/* public class Solution {  
    List<List<Integer>> ans = new ArrayList<List<Integer>>();  
      
    public List<List<Integer>> permuteUnique(int[] num) {  
        Arrays.sort(num);  
          
        //首先得把原始数组添加到结果集  
        List<Integer> list = new ArrayList<Integer>();  
        for (int x : num) {  
            list.add(x);  
        }  
        ans.add(list);  
          
        //逐个添加下一个解  
        for (int i = 1; i < factorial(num.length); i++) {  
            nextPermutation(num);  
        }  
          
        return ans;  
    }  
      
    public void nextPermutation(int[] num) {  
        //找到最后一个正序  
        int i = num.length - 1;  
        while (i > 0 && num[i] <= num[i - 1]) {  
            i--;  
        }  
        if (i <= 0) return;  
          
        //找到最后一个比num[i-1]大的数  
        int j = num.length - 1;  
        while (j >= i && num[j] <= num[i - 1]) {  
            j--;  
        }  
          
        //交换  
        int tmp = num[i - 1];  
        num[i - 1] = num[j];  
        num[j] = tmp;  
          
        //逆排i-1之后的数  
        int l = i, r = num.length - 1;  
        while (l < r) {  
            tmp = num[l];  
            num[l] = num[r];  
            num[r] = tmp;  
            l++;  
            r--;  
        }  
          
        //添加到结果集  
        List<Integer> list = new ArrayList<Integer>();  
        for (int x : num) {  
            list.add(x);  
        }  
        ans.add(list);  
    }  
      
    public int factorial(int n) {  
        return n == 0 ? 1 : n * factorial(n - 1);  
    }  
}  */