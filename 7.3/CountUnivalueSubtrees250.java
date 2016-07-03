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
    int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null)
            return 0;
        helper(root);
        return res;
        
    }
    public boolean helper(TreeNode root)
    {
        if(root == null)
            return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if((root.left != null && root.val != root.left.val)||(root.right != null && root.val != root.right.val))
            return false;
        if(left&&right)
            res++;
        return true;
        
    }
    
}