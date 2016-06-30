import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		int[] arr = {1,1};
		sop(permute(arr));
		//sop(str.substring(0,1));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	} 
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
		if(nums == null|| nums.length == 0)
			return list;
		dfs(nums,list,new ArrayList<Integer>());
		return list;
    }
	public static void dfs(int[] nums,List<List<Integer>> list,ArrayList<Integer> next)
	{
		if(next.size() == nums.length)
		{
			list.add(new ArrayList<Integer>(next));
			//next.clear();
		}
		for(int pos = 0;pos<nums.length;pos++)
		{
			if(!next.contains(nums[pos]))
			{
				next.add(nums[pos]);
				dfs(nums,list,next);
				next.remove(next.size()-1);
			}
		}
			
	}
}





/* public class Solution {  
    List<List<Integer>> ret = new ArrayList<List<Integer>>();  
      
    public List<List<Integer>> permute(int[] num) {  
        int len = num.length;  
        if (len == 0) return ret;  
          
        List<Integer> list = new ArrayList<Integer>();  
        run(list, num);  
        return ret;  
    }  
      
    public void run(List<Integer> list, int[] num) {  
        if (list.size() == num.length) {  
            //注意这里要重新new一个list，要不然后面会被修改  
            List<Integer> res = new ArrayList<Integer>();  
            res.addAll(list);  
            ret.add(res);  
            return;  
        }  
        for (int i = 0; i < num.length; i++) {  
            if (list.contains(num[i])) {  
                continue;  
            }  
            list.add(num[i]);  
            run(list, num);  
            list.remove(list.indexOf(num[i])); //不要忘记这一步  
        }  
    }  
}   */