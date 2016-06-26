/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /* A better solution */
 public class Solution {
    //int len = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null)
			return 0;
		TreeNode left = root.left;
		TreeNode right = root.right;
		return Math.max(dfs(left,1,root.val),dfs(right,1,root.val));
		
    }
	public int dfs(TreeNode node, int level, int val)
	{
		if(node == null)
			return level;		
		int next =  (node.val == val + 1? level +1:1);
		return Math.max(Math.max(dfs(node.left,next, node.val),dfs(node.right,next,node.val)),next);
	}
}
/* public class Solution {
    int len = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null)
			return 0;
		TreeNode left = root.left;
		TreeNode right = root.right;
		int l = 0;
		int r = 0;
		if(left != null)
		{
			if(root.val == left.val - 1)
			{
				dfs(left,1);
			}
			else
				dfs(left, 0);
		}
		if(right != null)
		{
			if(root.val == right.val - 1)
			{
				dfs(right,1);
			}
			else
				dfs(right, 0);
		}
		return len +1;
		
    }
	public void dfs(TreeNode node, int level)
	{
		if(node.left != null)
		{
			if(node.left.val == node.val+1)
				dfs(node.left,level+1);
			else 
			{
				len = Math.max(level,len);
				dfs(node.left,0);
			}
			
		}
		if(node.right != null)
		{
			if(node.right.val == node.val+1)
				dfs(node.right,level+1);
			else 
			{
				len = Math.max(level,len);
				dfs(node.right,0);
			}
		}
		if(node.left == null&&node.right == null)
		{
			len = Math.max(len,level);
		}
	}
} */