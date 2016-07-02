import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static boolean validTree(int n, int[][] edges) {
        if(n <= 0 )
			return true;
		if(edges.length < n - 1)
		{
			return false;
		}
		int[] unionFind = new int[n];
		int[] size = new int[n];
		Arrays.fill(size,1);
		for(int i = 0; i < n ; i++)
		{
			unionFind[i] = i;
		}
		int maxSize = 1;
		for(int i = 0 ; i < edges.length; i++)
		{
			int num1 = edges[i][0];
			int num2 = edges[i][1];
			if(connected(num1,num2,unionFind))
				return false;
			maxSize = unionMax(num1,num2,unionFind,size,maxSize);
			
		}
		return maxSize == n? true: false;
    }
	public static boolean connected(int num1, int num2, int[] unionFind)
	{
		int parent1 = (num1 == unionFind[num1]? num1:findParent(num1,unionFind));
		int parent2 = (num2 == unionFind[num2]? num2:findParent(num2,unionFind));
		return parent1 == parent2? true: false;
	}
	public static int findParent(int num, int[] unionFind)
	{
		if(num == unionFind[num])
			return num;
		unionFind[num] = findParent(unionFind[num],unionFind);
		return unionFind[num];
	}
	public static int unionMax(int num1, int num2, int[] unionFind, int[] size, int maxSize)
	{
		int parent1 = (num1 == unionFind[num1]? num1:findParent(num1,unionFind));
		int parent2 = (num2 == unionFind[num2]? num2:findParent(num2,unionFind));
		if(size[parent1] >= size[parent2])
		{
			unionFind[parent2] = parent1;
			size[parent1] += size[parent2];
			maxSize = size[parent1]>maxSize?size[parent1]:maxSize;
		}
		else
		{
			unionFind[parent1] = parent2;
			size[parent2] += size[parent1];
			maxSize = size[parent2]>maxSize?size[parent2]:maxSize;
		}
		return maxSize;
	}
}
/* A concise version of the code above
public class Solution {
    public static boolean validTree(int n, int[][] edges) {
        if(n <= 0 )
			return true;
		if(edges.length < n - 1)
		{
			return false;
		}
		int[] unionFind = new int[n];
		for(int i = 0; i < n ; i++)
		{
			unionFind[i] = i;
		}
		for(int i = 0 ; i < edges.length; i++)
		{
			if(connected(edges[i][0],edges[i][1],unionFind))
				return false;
			union(edges[i][0],edges[i][1],unionFind);
		}
		return true;
    }
	public static boolean connected(int num1, int num2, int[] unionFind)
	{
		int parent1 = findParent(num1,unionFind);
		int parent2 = findParent(num2,unionFind);
		return parent1 == parent2? true: false;
	}
	public static int findParent(int num, int[] unionFind)
	{
		if(num == unionFind[num])
			return num;
		unionFind[num] = findParent(unionFind[num],unionFind);
		return unionFind[num];
	}
	public static void union(int num1, int num2, int[] unionFind)
	{
		int parent1 = findParent(num1,unionFind);
		int parent2 = findParent(num2,unionFind);

		unionFind[parent1] = parent2;

	}
} 
 */





//The following method works, but too slow.
/* public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n<=0)
            return true;
        boolean[] visited = new boolean[n];
        boolean[] visiting = new boolean[n];
        if(edges.length < n-1 ||((edges.length == 0||edges[0].length == 0)&&n>1))
            return false;
        for(int i = 0 ; i < n; i++)
        {
            if(!visited[i])
                if(containsLoop(visited,edges,i,visiting,-1))
                    return false;
        }
        return true;
        
    }
    public boolean containsLoop(boolean[] visited, int[][] edges, int i,boolean[] visiting, int pre)
    {
        for(int element : getConnected(i,pre,edges))
        {
            if(visiting[element])
                return true;
            visiting[element] = true;
            if(containsLoop(visited,edges,element,visiting,i))
                return true;
            visiting[element] = false;
            visited[element] = true;
        }
        visited[i] = true;
        return false;
    }
    public List<Integer> getConnected(int i, int pre, int[][] edges)
    {
        List<Integer> list = new ArrayList<>();
        for(int[] pair:edges)
        {
            if(pair[0] == i)
            {
                if(pair[1] != pre)
                {
                    list.add(pair[1]);
                }
            }
            else if(pair[1] == i)
            {
                if(pair[0] != pre)
                {
                    list.add(pair[0]);
                }
            }
        }
        return list;
    }
} */