import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	static class Node{
		int col;
		int val;
		Node(int col, int val)
		{
			this.col = col;
			this.val = val;
		}
	}
    public static int[][] multiply(int[][] A, int[][] B) {
        if(A==null||A.length == 0)
			return new int[0][0];
		int aHeight = A.length;
		int aWidth = A[0].length;
		int bHeight = B.length;
		int bWidth = B[0].length;
		int[][] res = new int[aHeight][bWidth];
		HashMap<Integer,List<Node>> map = new HashMap<>();
		for(int i = 0; i < bHeight; i++)
		{
			map.put(i,new ArrayList<Node>());
			for(int j = 0 ; j < bWidth; j++)
			{
				if(B[i][j]!=0)
				{
					map.get(i).add(new Node(j,B[i][j]));
				}
			}
		}
		for(int i = 0; i < aHeight; i++)
		{
			for(int j = 0; j < aWidth; j++)
			{
				if(A[i][j]!=0)
				{
					if(map.get(j).size() != 0)
					{
						for(Node n:map.get(j))
						{
							res[i][n.col] += A[i][j]*n.val;
						}
					}
				}
			}
		}
		return res;
    }
}