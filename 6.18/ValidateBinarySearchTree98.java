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
	TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
			return true;
		if(!(isValidBST(root.left))) return false;
		if(pre!=null&&root.val<=pre.val) return false;
		pre = root;
		return isValidBST(root.right);
    }
}


/**This is another method, a little bit slower
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
	    boolean isNull;
		int max;
		int min;
		boolean b;
		
	}
	
    public boolean isValidBST(TreeNode root) {
        Info info = goCheck(root);
		return info.b;
    }
	public Info goCheck(TreeNode root)
	{
		Info info = new Info();
		if(root == null)
		{
		    info.isNull = true;
			info.min = Integer.MAX_VALUE;
			info.max = Integer.MIN_VALUE;
			info.b = true;
			return info;
		}
		info.isNull = false;
		Info l = goCheck(root.left);
		if(l.b==false)
		{
			info.b = false;
			return info;
		}
		Info r = goCheck(root.right);
		if(r.b==false)
		{
			info.b = false;
			return info;
		}
		if(root.val == Integer.MAX_VALUE)
		{
		    if(l.isNull)
		    {
		        if(!r.isNull)
		        {
	                info.b = false;
	                return info;
		        }
		        
		    }
		    else
		    {
		        if(l.max == root.val||!r.isNull)
		        {
		            info.b = false;
		            return info;
		        }
		    }
		    info.b = true;
	        info.min = Math.min(l.min,root.val);
	        info.max = root.val;
	        return info;
		}
		else if(root.val == Integer.MIN_VALUE)
		{
		    if(l.isNull)
		    {
		        if(!r.isNull)
		        {
		            if(r.min == root.val)
		            {
		                info.b = false;
		                return info;
		            }
		            
		        }
		        
		    }
		    else
		    {
		        
		            info.b = false;
		            return info;
		        
		    }
		    info.b =true;
	        info.min = root.val;
	        info.max = r.max;
	        return info;
		}
		else if(root.val<=l.max||root.val>=r.min)
		{
			info.b =false;
			return info;
		}
			
		info.b = true;
		info.min = Math.min(l.min,root.val);
		info.max = Math.max(r.max,root.val);
		return info;
	}
}