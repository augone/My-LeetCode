import java.util.*;
class Solution {
	public static void main(String[] args)
	{
		String str = "";
		sop(reverseString(str));
		
	}
	public static void sop(Object obj )
	{
		System.out.println(obj);
	}
    public static String reverseString(String s) {
		if(s==null||s.length()<2)
			return s;
		char[] arr = s.toCharArray();
		for(int i = 0; i < s.length()/2 ; i++)
		{
			char temp = arr[i];
			arr[i] = arr[s.length()-1-i];
			arr[s.length()-1-i] = temp;
		}
		return new String(arr);
        
    }
}