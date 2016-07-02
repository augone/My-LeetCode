/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //The following is a much better solution.
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
        if(root == null)
			return list;
		dfs(root,list,"");
		return list;
    }
	public void dfs(TreeNode root,List<String> list,String res )
	{
		if(root == null)
			return;
	    if(root.left == null&&root.right == null)
	    {
	        res += root.val;
	        list.add(res);
	    }
	    if(root.left != null)
	        dfs(root.left,list,res + root.val + "->");
	    if(root.right != null)
	        dfs(root.right,list,res + root.val + "->");
	}
}


public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
        if(root == null)
			return list;
		StringBuilder sb = new StringBuilder();
		sb.append(root.val);
		if(root.left == null&&root.right == null)
		{
		    list.add(sb.toString());
	        return list;
		}
	        
		dfs(root.left,list,new StringBuilder(sb) );
		dfs(root.right,list,new StringBuilder(sb));
		return list;
    }
	public void dfs(TreeNode root,List<String> list,StringBuilder sb )
	{
		if(root == null)
			return;
		sb.append("->").append(root.val);
	    if(root.left == null&&root.right == null)
	        list.add(sb.toString());
		dfs(root.left,list,new StringBuilder(sb) );
		dfs(root.right,list,new StringBuilder(sb));
	}
}