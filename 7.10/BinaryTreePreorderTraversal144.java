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
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root != null)
            list.add(root);
        else
            return res;
        while(list.size()>0)
        {
            root = list.pollFirst();
            while(root != null)
            {
                res.add(root.val);
                if(root.right != null)
                {
                    list.addFirst(root.right);
                }
                root = root.left;
            }
            
        }
        return res;
    }
}