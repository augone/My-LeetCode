/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
class Solution {
	public static void main(String[] args )
	{
		
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null)
			return res;
		int min = 0;
		int max = 0;
		List<Pair> hList = new ArrayList<>();
		hList.add(new Pair(root,0));
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		while(!hList.isEmpty())
		{
			List<Pair> tempList = hList;
			hList = new ArrayList<Pair>();
			for(Pair p:tempList)
			{
				if(map.get(p.level) == null)
					map.put(p.level,new ArrayList<Integer>());
				map.get(p.level).add(p.node.val);
				if(p.node.left!=null)
				{
					hList.add(new Pair(p.node.left,p.level-1));
					min = Math.min(min,p.level-1);
				}
				if(p.node.right != null)
				{
					hList.add(new Pair(p.node.right,p.level+1));
					max = Math.max(max,p.level+1);
				}
					
			}
		}
		for(int i = min; i <= max ; i++)
		{
			res.add(map.get(i));
		}
		return res;
		
    }
	static class Pair
	{
		TreeNode node;
		int level;
		Pair(TreeNode node, int level)
		{
			this.node = node;
			this.level = level;
		}
	}
}