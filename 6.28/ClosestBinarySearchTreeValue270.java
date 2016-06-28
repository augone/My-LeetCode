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
    int closest = Integer.MAX_VALUE;
    double diff = 0;
    boolean first = true;
    public int closestValue(TreeNode root, double target) {
        if(root == null) return closest;
        if(first) 
        {
            first = false;
            diff = Math.abs(target - root.val);
            closest = root.val;
        }
        else if(Math.abs(target - root.val) < diff)
        {
            diff = Math.abs(target - root.val);
            closest = root.val;
        }
       
        return target>root.val?closestValue(root.right,target):closestValue(root.left,target);
    }
}