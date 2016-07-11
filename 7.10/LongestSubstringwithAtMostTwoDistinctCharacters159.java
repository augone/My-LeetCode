import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		sop(lengthOfLongestSubstring("adaavaadaaf"));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
		int maxDistinct = 2;
		int len = s.length();
		if(len <= maxDistinct) return len;
		int res = 0;
		HashMap<Character,Integer> map = new HashMap<>();
		ArrayList<Character> character = new ArrayList<>();
		int min = 0;
		int nextMin = Integer.MAX_VALUE;
		for(int i = 0,j = 0; i < len; i++)
		{
			char curr = s.charAt(i);
			if(character.contains(curr))
			{
				character.remove((Character)curr);
			}
			else
			{
				if(character.size() == maxDistinct)
				{
					int index = map.get(character.get(0));
					character.remove(0);
					j = index+1;
				}				
			}
			character.add(curr);
			map.put(curr, i);
			sop(map);
			sop(character);
			res = Math.max(res, i - j + 1);
		}
		return res;
    }
}