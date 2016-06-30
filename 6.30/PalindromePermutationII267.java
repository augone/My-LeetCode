import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		String str = "aabbcc";
		sop(generatePalindromes(str));
		//sop(str.substring(0,1));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	} 
    static int Len;
	static char charCenter; 
	static final int R = 128;
    public static List<String> generatePalindromes(String s) {
		
        List<String> list = new ArrayList<>();
        if(s == null || s.length() == 0)
            return list;
		StringBuilder sb1 = countPalindrome(s);
		if(sb1 == null)
			return list;
		s = sb1.toString();
		sop("THIS IS S "+s);
        char[] charArr = s.toCharArray();
        Len = charArr.length;
        //int[] replace = new int[Len];
        boolean[] visited = new boolean[Len];
        Arrays.sort(charArr);
        StringBuilder sb2 = new StringBuilder();
        backtrack(charArr,list,visited,sb2);
        //list.remove(s);
        return list;
    }
	public static StringBuilder countPalindrome(String s)
	{
		//26 could be 256 if includes all letters.
		
		int[] count = new int[R];
		char[] charArr = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		Arrays.sort(charArr);
		int single = 0;
		for(int i = 0 ; i < charArr.length; i++)
		{
			int index = charArr[i];
			count[index] += 1;
			single++;
			if(count[index] == 2)
			{
				count[index] = 0;
				single -= 2;
				sb.append(charArr[i]);
				
			}
		}
		if(single > 1) return null;
		else if(single == 1)
		{
			for(int i = 0; i < R; i++)
			{
				if(count[i] == 1)
				{
					charCenter = (char)(i);
				}
			}
		}
		else 
			charCenter = '0';
		
		return sb;
		
	}
    public static void  backtrack(char[] charArr, List<String> list, boolean[] visited, StringBuilder sb)
    {
        if(sb.length() == Len )
        {
            list.add(sb.toString()+(charCenter == '0'?"":charCenter)+sb.reverse().toString());
			sb.reverse();
        }
        for(int i = 0 ; i < Len ; i++)
        {
            if(visited[i]||(i>0&&!visited[i-1]&&charArr[i] == charArr[i-1]))
                continue;
            visited[i] = true;
            sb.append(charArr[i]);
            backtrack(charArr,list,visited,sb);
            visited[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}