/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //A more concise version
 public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return root;

          TreeNode newRoot = upsideDownBinaryTree(root.left);
          
          root.left.left = root.right;
          root.left.right = root;
          
          root.left = null;
          root.right = null;
              
          return newRoot;
    }
}
 
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root != null)
		{
			if(root.left != null)
			{
				TreeNode left = upsideDownBinaryTree(root.left);
				if(left != null)
				{
					addLeft(root.right,left);
					addRight(root, left);
					root.left = null;
					root.right = null;
					return left;
				}
				else if(root.right != null)
				{
				    TreeNode head = root.right;
					head.right = root;
					root.right = null;
					return head;
					
				}
				return root;
			}		
		}
		return root;
    }
	public void addLeft(TreeNode leftChild, TreeNode root)
	{
		while(root.right != null)
		{
			root = root.right;
		}
		root.left = leftChild;
	}
	
	public void addRight(TreeNode rightChild, TreeNode root)
	{
		while(root.right != null)
		{
			root = root.right;
		}
		root.right = rightChild;
	}
}