import java.util.*;
//the following method is TLE;
class Solution {
	public static void main(String[] args )
	{
		int[][] arr = {{1,0},{1,2},{1,3}};
		sop(findMinHeightTrees(4,arr));
		//sop(maxCoins(arr));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
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
		//HashMap<Integer,List<Integer>> map = new HashMap<>();
		List<List<Integer>> lists = new ArrayList<>();
		for(int i = 0; i < n; i++)
		{
			lists.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < edges.length; i++)
		{
			int v1 = edges[i][0];
			int v2 = edges[i][1];
			sop("v1and v2"+v1+v2);
			lists.get(v1).add(v2);
			lists.get(v2).add(v1);
		}
		sop("List:"+lists);
		List<Integer> leaves = new ArrayList<>();
		for(int i = 0 ; i < n; i++)
		{
			if(lists.get(i).size() == 1)
				leaves.add(i);
		}
		while(leaves.size() > 2)
		{
			int count = leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for(int i =  0; i < count; i++)
			{
				sop("leaves.get(i)"+leaves.get(i));
				sop("lists.get(leaves.get(i)).get(0)"+lists.get(leaves.get(i)).get(0));
				int leaf = lists.get(leaves.get(i)).get(0);
				lists.get(leaf).remove((Integer)leaves.get(i));
				if(lists.get(leaf).size() == 1)
					newLeaves.add(leaf);
			}
			leaves = newLeaves;
			
		}
		return leaves;
    }

	
}