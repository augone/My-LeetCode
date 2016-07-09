/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
class BSTIterator {
	LinkedList<Integer> stack = new LinkedList<>();
	//The following also works;
	//Stack<Integer> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        dfs(root);
    }
	public void dfs(TreeNode root)
	{
		if(root != null)
		{ 
			dfs(root.right);
			stack.push(root.val);
			dfs(root.left);
		}
	}

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() != 0;
    }

    /** @return the next smallest number */
    public int next() {
        return stack.pop();
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */