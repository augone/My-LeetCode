public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        int Len = words.length;
		Set<List<Integer>> set = new HashSet<>();
		HashMap<String,Integer> map = new HashMap<>();
		for(int i = 0; i < Len; i++)
		{
			map.put(words[i],i);
		}
		for(int i = 0; i < Len ; i++)
		{
			String temp = words[i];
			for(int j = 0; j <= temp.length();j++)
			{
				String seg1 = temp.substring(0,j);
				String seg2 = temp.substring(j);
				
				if(isPal(seg1)&&map.containsKey(reverse(seg2))&&
					map.get(reverse(seg2))!=i)
					{
						List<Integer> list = new ArrayList<>();
						
						list.add(map.get(reverse(seg2)));
						list.add(i);
						set.add(list);
					}
			}
		}
		for(int i = 0; i < Len ; i++)
		{
			String temp = words[i];
			for(int j = 0; j <= temp.length();j++)
			{
				String seg1 = temp.substring(0,j);
				String seg2 = temp.substring(j);
		
				if(isPal(seg2)&&map.containsKey(reverse(seg1))&&
					map.get(reverse(seg1))!=i)
					{
						List<Integer> list = new ArrayList<>();
						list.add(i);
						list.add(map.get(reverse(seg1)));
						
						set.add(list);
					}
			}
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(List l : set)
		{
			res.add(l);
		}
		return res;
    }
	public boolean isPal(String str)
	{
		for(int i=0,j=str.length()-1;i<j;i++,j--)
		{
			if(str.charAt(i)!=str.charAt(j))
				return false;
			
		}
		return true;
	}
	public String reverse(String str)
	{
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}
}