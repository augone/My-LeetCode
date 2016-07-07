import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		int[][] arr = {};//{{1,1},{1,1},{1,3}};
		for(int i : findOrder(1,arr))
		{
			sop(i);
		}
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public class Solution {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses < 1)
			return new int[0];
		int[] incomming = new int[numCourses];
		int[] order = new int[numCourses];
		List<List<Integer>> list = new ArrayList<>();
		constructList(list,prerequisites,incomming);
		if(bfs(order,list,incomming))
			return order;
		return new int[0];
		
    }
	public static boolean bfs(int[] order,List<List<Integer>> list,int[] incomming)
	{
		Stack<Integer> stack = new Stack<>();
		int pos = 0;
		for(int i = 0; i < incomming.length; i++)
		{
			if(incomming[i] == 0)
			{
				order[pos++] = i;
				stack.push(i);
			}
		}
		while(!stack.empty())
		{
			int curr = stack.pop();
			for(int next : list.get(curr))
			{
				if(--incomming[next] == 0)
				{
					stack.push(next);
					order[pos++] = next;
					if(pos == incomming.length)
						return true;
				}
				
			}
		}
		if(pos == incomming.length)
			return true;
		return false;
		
	}
	public static void constructList(List<List<Integer>> list,int[][] prerequisites,int[] incomming)
	{
		int len = incomming.length;
		while(len-- > 0)
			list.add(new ArrayList<Integer>());
		for(int[] pair: prerequisites)
		{
			incomming[pair[0]]++;
			list.get(pair[1]).add(pair[0]);
		}
	}
}
    /* public static int[] findOrder(int numCourses, int[][] prerequisites) {
	
		if(numCourses < 2||prerequisites==null||prerequisites.length < numCourses - 1)
			return new int[0];
		int[] res = new int[numCourses];
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		constructTopo(prerequisites,map);
		sop(map);
		boolean[] visited = new boolean[numCourses];
		for(int i = 0; i < numCourses; i++)
		{
			if(topoSort(map,i,res,0,numCourses,visited))
				return res;
		}
		return new int[0];
		
    }
	public static boolean topoSort(HashMap<Integer, List<Integer>> map, int i, int[] res,int level, int numCourses,boolean[] visited)
	{
		if(visited[i])
			return false;
		res[level] = i;
		
		if(level == numCourses - 1) return true;
		if(map.get(i) == null)	
		{
			for(int pos = 0 ; pos < visited.length; pos++)
			{
				if(visited[pos])
				{
					if(map.get(pos).contains(i))
						
				}
			}
			return false;
		}
		visited[i] = true;
		for(int next : map.get(i))
		{
			sop("next:"+next);
			if(topoSort(map,next,res,level+1,numCourses,visited))
				return true;
		}
		visited[i] = false;
		return false;
	}
	public static void constructTopo(int[][] prerequisites, HashMap<Integer,List<Integer>> map)
	{
		for(int[] pair:prerequisites)
		{
			if(!map.containsKey(pair[1]))
			{
				map.put(pair[1],new ArrayList<Integer>());
			}
			List<Integer> follow = map.get(pair[1]);
			follow.add(pair[0]);
		}
		
	} */
}