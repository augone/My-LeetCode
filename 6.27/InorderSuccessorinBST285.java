//This is my solution 

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
    LinkedList<Boolean> list = new LinkedList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode copy = root;
        if(p.right != null)
        {
            TreeNode rt = p.right;
            p = p.right;
            while(p.right!=null||p.left!=null)
            {
                if(p.left != null)
                {
                    rt = p.left;
                    p = p.left;
                }
                else 
                    p = p.right;
            }
            return rt;
        }
        helper(root, p);
        while(list.size()>0)
        {
            boolean temp = list.pollLast();
            if(!temp)
                continue;
            for(int i = 0; i < list.size(); )
            {
                if(list.pollFirst())
                {
                    root = root.left;
                }
                else
                    root = root.right;
            }
            return root;

        }
        return null;
            
    }
    public void helper(TreeNode root, TreeNode p)
    {
        if(root.val == p.val)
            return;
        if(root.val>p.val)
        {
            list.add(true);
            helper(root.left, p);
        }
        if(root.val<p.val)
        {
            list.add(false);
            helper(root.right, p);
        }
    }
}
//This is an even better solution!!!!!!!!!!!!

public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

    if (p == null || root == null) {
        return null;
    }

    TreeNode inorderSuccessor = null;
    if (root.val <= p.val){
        inorderSuccessor = inorderSuccessor(root.right, p);
    } else {
        inorderSuccessor = inorderSuccessor(root.left, p);
    }

    return (inorderSuccessor == null && root.val > p.val) ? root : inorderSuccessor;
}