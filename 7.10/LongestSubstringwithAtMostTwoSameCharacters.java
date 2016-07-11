import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		sop(lengthOfLongestSubstring("asdfaaasdfaasdaf"));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
		int maxSame = 2;
		int len = s.length();
		if(len < 2) return len;
		int res = 0;
		HashMap<Character, List<Integer>> map = new HashMap<>();
		for(int i = 0,j = 0; i < len; i++)
		{
			char curr = s.charAt(i);
			if(map.containsKey(curr))
			{
				List<Integer> temp = map.get(curr);
				if(temp.size() == maxSame)
				{
					while(temp.size()>0&&temp.get(0) < j)
					{
						temp.remove(0);
					}
					if(temp.size() == maxSame)
					{
						j = Math.max(j, temp.get(0)+1);
						temp.remove(0);
					}
				}
			}
			else
			{
				map.put(curr, new ArrayList<Integer>());
			}
			sop(map);
			List<Integer> next = map.get(curr);
			next.add(i);
			map.put(curr,next);
			res = Math.max(res, i - j + 1);
		}
		return res;
    }
}