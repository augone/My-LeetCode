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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<TreeNode> queue = new PriorityQueue<>(new Comparator<TreeNode>(){
            public int compare(TreeNode node1,TreeNode node2)
            {
                return (Math.abs(node1.val - target ) - Math.abs(node2.val - target) )>0?1:-1;
            }
        });
        addNode(root, queue);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < k ; i++)
        {
            list.add(queue.poll().val);
        }
        return list;
        
    }
    public void addNode(TreeNode root,PriorityQueue<TreeNode> queue )
    {
        if(root == null)
            return;
        addNode(root.left,queue);
        queue.add(root);
        addNode(root.right,queue);
        
    }
}