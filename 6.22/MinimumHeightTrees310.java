import java.util.*;
//the following method is TLE;
class Solution {
	public static void main(String[] args )
	{
		int[] arr = {3, 1, 5, 8};
		//sop(maxCoins(arr));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
		if(n == 0)
			return res;
		if(n<3)
		{
			for(int i = 0 ; i <n; i++)
			{
				res.add(i);
			}
			return res;
		} 
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		for(int i = 0; i < edges.length; i++)
		{
			if(map.get(edges[i][0]) == null)
				map.put(edges[i][0],new ArrayList<Integer>());
			if(map.get(edges[i][1]) == null)
				map.put(edges[i][1],new ArrayList<Integer>());
			map.get(edges[i][0]).add(edges[i][1]);
			map.get(edges[i][1]).add(edges[i][0]);
		}
		int[] depth = new int[n];
		int max = Integer.MAX_VALUE;
		List<Integer> showed = new ArrayList<>();
		for(int i = 0 ; i < n; i++)
		{
			//showed.add(i);
			depth[i] = dfs(i,showed, map, 0);
			if(depth[i] < max)
			{
				max = depth[i];
				res.clear();
				res.add(i);
			}
			else if(max == depth[i])
				res.add(i);
			showed.clear();
				
		}
		return res;
    }
	public static int dfs(int i, List<Integer> showed,HashMap<Integer, List<Integer>> map, int level)	
	{
		int max = 0;
		if(showed.contains(i))
			return level-1;
		showed.add(i);
		List<Integer> curr = map.get(i);
		int local = 0;
		for(int num:curr)
		{
			if(!showed.contains(num))
				local = dfs(num,showed, map, level+1);
			if(local > max) max = local;
			
			
		}
		showed.remove((Integer)i);
		return max==0?level:max;
	}
}