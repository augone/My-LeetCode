import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		int[][] arr = {};//{{1,1},{1,1},{1,3}};
		for(int i : findOrder(1,arr))
		{
			sop(i);
		}
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
		int len = s.length();
		if(len < 2) return len;
		int res = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0,j = 0; i < len; i++)
		{
			char curr = s.charAt(i);
			if(map.containsKey(curr))
			{
				j = Math.max(j, map.get(curr)+1);
			}
			map.put(curr,i);
			res = Math.max(res, i - j + 1);
		}
		return res;
    }
}



/* public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) return 0;
		int len = s.length();
		int start = 0;
		int longestLen = 0;
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i = 0; i < len; i++)
		{
			char ch = s.charAt(i);
			if(map.containsKey(ch))
			{
				int count = map.get(ch);
				if(count==0)
				{
					map.put(ch,1);
					if(i == len-1)
				{
					if(i-start+1>longestLen)
					{
						longestLen = i-start+1;
					}
				}
				}
				else
				{
					if(i-start>longestLen)
					{
						longestLen = i-start;
					}
					String temp = s.substring(start,i);
					int pos = temp.indexOf(ch);
					for(int j = start; j < start + pos; j++)
					{
						map.put(s.charAt(j),0);
					}
					start += pos + 1;
				}
					
			}
			else 
			{
				map.put(ch,1);
				if(i == len-1)
				{
					if(i-start+1>longestLen)
					{
						longestLen = i-start+1;
					}
				}
			}
		}
		return longestLen;
    }
} */