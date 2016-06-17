/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.*;
public class NestedIterator implements Iterator<Integer> {
	Stack<Integer> stack = null;
	
	public void getAllIntegers(List<NestedInteger> nestedList)
	{
		for(int i = nestedList.size() - 1; i > 0; i--)
		{
			NestedInteger ni = nestedList.get(i);
			if(ni.isInteger())
				stack.push(ni.getInteger());
			else
				getAllIntegers(ni.getList());
		}
	}
    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
		getAllIntegers(nestedList);
		
    }

    @Override
    public Integer next() {
        return stack.pop();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */