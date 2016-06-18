/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	class Pair{
		int node;
		int child;
		public Pair(int node, int child)
		{
			this.node = node;
			this.child = child;
		}
	}
    public  int rob(TreeNode root) {
        Pair res = inOrder(root);
		return res.node;
    }
	public  Pair inOrder(TreeNode root)
	{
		if(root == null)
			return new Pair(0,0);
		if(root.right == null&&root.left == null)
			return new Pair(root.val,0);
		Pair left = null, right = null;
		int Max_self = 0, Max_child = 0;
		Max_self += root.val;

		if(root.left!=null)
		{
			left = inOrder(root.left);
			Max_self += left.child;
			Max_child += left.node;
 		}
		if(root.right != null)
		{
			right = inOrder(root.right);
			Max_self += right.child;
			Max_child += right.node;
		}
		return new Pair(Math.max(Max_self,Max_child),Max_child);
		
	}
}