public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> element = new ArrayList<>();
        helper(list,n,2,element,(int)Math.sqrt(n));
        return list;
    }
    public void helper(List<List<Integer>> list, int n, int start, List<Integer> element,int upper)
    {
        if(n == 1 &&element.size() > 1)
        {
            list.add(new ArrayList<Integer>(element));
            return;
        }
        for(int i = start; i <= n; i++)
        {
            if(i > upper)
            {
                i = n;
            }
            if(n %i == 0)
            {
                element.add(i);
                helper(list,n/i,i,element,(int)Math.sqrt(n/i));
                element.remove(element.size() - 1);
            }
        
        }
        
        
    }
}