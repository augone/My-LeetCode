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
    
    LinkedList<Integer> list = new LinkedList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root != null)
        {
            list.addFirst(root.val);
            postorderTraversal(root.right);
            postorderTraversal(root.left);
        }
            
        return list;
    }
}