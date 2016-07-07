import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		int[][] arr = {{4,3},{0,1},{5,0},{1,5}};//{{1,1},{1,1},{1,3}};
		sop(canFinish(6,arr));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <2||prerequisites == null||prerequisites.length == 0)
            return true;
        int[] incomming = new int[numCourses];
		List<List<Integer>> list = new ArrayList<>();
		int len = numCourses;
		while(len-- > 0)
			list.add(new ArrayList<Integer>());
		boolean[] visited = new boolean[prerequisites.length];
		boolean[] visiting = new boolean[numCourses];
		for(int i = 0; i < prerequisites.length; i++)
		{
			if(!visited[i])
			{
				sop(list);
				visiting[prerequisites[i][1]] = true;
				if(constructTopo(i,list, prerequisites,incomming,visiting,visited))
					return false;
				visiting[prerequisites[i][1]] = false;	

			}
			else 
				continue;
		}
		return true;
			
    }
	private static boolean constructTopo(int curr, List<List<Integer>> list,int[][] prerequisites,int[] incomming,boolean[] visiting,boolean[] visited)
	{
		if(visiting[prerequisites[curr][0]])
			return true;
		visited[curr] = true;
		visiting[prerequisites[curr][0]] = true;
		incomming[prerequisites[curr][0]]++;
		if(list.get(prerequisites[curr][1]) == null)
		{
			List<Integer> temp = new ArrayList<>();
		}

		list.get(prerequisites[curr][1]).add(prerequisites[curr][0]);
		for(int i = 0; i < prerequisites.length;i++)
		{
			if(!visited[i]&&prerequisites[i][1] == prerequisites[curr][0])
			{
				sop("next"+prerequisites[i][1]);
				if(constructTopo(i,list, prerequisites,incomming,visiting,visited))
					return true;
			}
		}
		visiting[prerequisites[curr][0]] = false;
		return false;
	}

}

//A better method
public static boolean canFinish(int numCourses, int[][] prerequisites) {
	if (numCourses <= 0)
		return false;
	Queue<Integer> queue = new LinkedList<>();
	int[] inDegree = new int[numCourses];
	for (int i = 0; i < prerequisites.length; i++) {
		inDegree[prerequisites[i][1]]++;
	}
	for (int i = 0; i < inDegree.length; i++) {
		if (inDegree[i] == 0)
			queue.offer(i);
	}
	while (!queue.isEmpty()) {
		int x = queue.poll();
		for (int i = 0; i < prerequisites.length; i++) {
			if (x == prerequisites[i][0]) {
				inDegree[prerequisites[i][1]]--;
				if (inDegree[prerequisites[i][1]] == 0)
					queue.offer(prerequisites[i][1]);
			}
		}
	}
	for (int i = 0; i < inDegree.length; i++) {
		if (inDegree[i] != 0)
			return false;
	}
	return true;
}