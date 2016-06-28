
public class Solution {
    Map<Character, String> f = new HashMap<>();
    Map<String, Character> f_inverse = new HashMap<>();

    boolean solve(char[] p, int i, String s) {
        if (i >= p.length && s.length() == 0) return true;
        else if (i < p.length && s.length() == 0) return false;
        else if(i >= p.length && s.length() > 0) return false;

        for (; i < p.length; i++) {
            if (f.containsKey(p[i])) {
                String y = f.get(p[i]);
                if (s.length() < y.length())
                    return false;
                if (s.substring(0, y.length()).equals(y)) {
                    String nxt = s.substring(y.length());
                    return solve(p, i + 1, nxt);
                }
                return false;
            } else {
                for (int j = 1; j <= s.length(); j++) {
                    String nxt = s.substring(0, j);
                    if (f_inverse.containsKey(nxt))
                        continue;

                    f.put(p[i], nxt);
                    f_inverse.put(nxt, p[i]);

                    if (solve(p, i + 1, s.substring(j))) return true;

                    f.remove(p[i]);
                    f_inverse.remove(nxt);
                }
                return false;
            }
        }

        return false;
    }

    public boolean wordPatternMatch(String pattern, String str) {
        return solve(pattern.toCharArray(), 0, str);
    }
}


//The following method has some unknown problem when "b" "ef";

import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		String str1 = "d";
		String str2 = "ef";
		sop(wordPatternMatch(str1.trim(),str2.trim()));
		//sop(str.substring(0,1));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	static char[] token;
	static int tokenLen;
	static int strLen;
	static String copy;
	static HashMap<Character, String> poll = new HashMap<>();
	static HashMap<String , Character> reversePoll = new HashMap<>();
    public static boolean wordPatternMatch(String pattern, String str) {
		if(pattern == null||pattern.length() == 0)
			return str == null||str.length() == 0;
		if(str == null||str.length() == 0)
			return pattern == null||pattern.length() == 0;
		copy = str;
		token = pattern.toCharArray();
		tokenLen = pattern.length();
		strLen = str.length();
		return backTrack(0,0);
		
		//sop(str);
        //return true;
    }
	public static boolean backTrack(int tokenPos, int strPos)
	{
		sop("hello");
		if(tokenPos == tokenLen&&strPos == strLen)
			return true;
		else if(tokenPos == tokenLen)
			return false;
		for(;tokenPos<tokenLen;tokenPos++)
		{
			sop("token:"+token[tokenPos]);
			if(poll.containsKey(token[tokenPos]))
			{
				
				String sub = poll.get(token[tokenPos]);
				
				int subLen = sub.length();
				if(strPos + subLen > strLen)
					return false;
				else
				{
					sop("sub:"+sub);
					
					sop(copy.substring(strPos,strPos+subLen));
					if(!sub.equals(copy.substring(strPos,strPos+subLen)))
						return false;
					else{
						return backTrack(tokenPos + 1, strPos + subLen);
							
					}
				}
			}
			else{
				for(int i = strPos+1; i <= strLen; i++)
				{
					if(reversePoll.containsKey(copy.substring(strPos, i)))
						continue;
					poll.put(token[tokenPos],copy.substring(strPos, i));
					reversePoll.put(copy.substring(strPos, i),token[tokenPos]);
					if(backTrack(tokenPos + 1, i))
						return true;
					else 
					{
						poll.remove(token[tokenPos]);
						reversePoll.remove(copy.substring(strPos, i));
					}
						
				}
				return false;
			}
		}
		return false;
	}
}