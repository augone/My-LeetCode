/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    class Info
	{
		boolean b;
		int max;
		int min;
		int count;
	}
    public int largestBSTSubtree(TreeNode root) {
        Info info = goCheck(root);
		return info.count;
    }
	public Info goCheck(TreeNode root)
	{
		Info info = new Info();
		if(root == null)
		{
			info.b = true;
			info.max = Integer.MIN_VALUE;
			info.min = Integer.MAX_VALUE;
			info.count = 0;
			return info;
		}
		Info l = goCheck(root.left);
		Info r = goCheck(root.right);
		if(l.b&&r.b&&root.val>l.max&&root.val<r.min)
		{
			info.min = Math.min(l.min,root.val);
			info.max = Math.max(r.max,root.val);
			info.count = l.count+r.count+1;
			info.b = true;
			return info;
		}
		else
		{

			info.count = Math.max(l.count,r.count);
			info.b = false;
		}
		return info;
	}
}