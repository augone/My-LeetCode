import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		String s = "I";
		String t = " ";
		sop(isOneEditDistance(s,t));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static boolean isOneEditDistance(String s, String t) {
        if(s == null&&t == null)
            return false;
        if((s == null && t.length()<2)||(t == null &&s.length()<2))
			return true;
		int lenS = s.length();
		int lenT = t.length();
		if(s.equals(t))
		    return false;
		if(Math.abs(lenS - lenT)>1)
			return false;
		if(lenS == lenT)
		{
			for(int i = 0; i<lenS; i++)
			{
				if(s.charAt(i) == t.charAt(i)) continue;
				return s.substring(i+1).compareTo(t.substring(i+1)) == 0;
			}
		}
		else if(lenS > lenT)
			return isEqual(s,t);
		return isEqual(t,s);
    }
	public static boolean isEqual(String s, String t)
	{
		for(int i = 0; i<t.length(); i++)
		{
			if(s.charAt(i) == t.charAt(i)) continue;
			return s.substring(i+1).compareTo(t.substring(i)) == 0;
		}
		return true;
	}
}