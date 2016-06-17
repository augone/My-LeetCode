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
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
		int sum = 0;
        for(int i = 0; i<nestedList.size(); i++)
		{
			NestedInteger item = nestedList.get(i);
			sum += doTheCalculation(item,1);
		}
		return sum;
    }
	public int doTheCalculation(NestedInteger ni, int level)
	{
		int sum = 0;
		if(ni.isInteger())
			return ni.getInteger()*level;
		else 
		{
			for(int i = 0; i<ni.getList().size(); i++)
			{
				NestedInteger item = ni.getList().get(i);
				sum += doTheCalculation(item,level+1);
			}
			return sum;
		}

	}
}