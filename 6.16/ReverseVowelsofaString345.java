import java.util.*;
class Solution {
	public static void main(String[] args)
	{
		String str = "TingXuan I love You!";
		sop(str);
		/* char a = 'a';
		char b = 'b';
		char c = 'a';
		sop((a == b)+"  "+(a==c)); */
		sop(reverseVowels(str));
		
		/* StringBuilder SBD = new StringBuilder(str);
		sop(SBD);
		int len = SBD.length();
		char a = 'd';
		String tempStr = String.valueOf(a);
		SBD.insert(0,tempStr);
		SBD.deleteCharAt(1);
		sop(SBD.charAt(3));
		sop(SBD); */
		
	}
	public static StringBuilder swap(int pos1, int pos2, StringBuilder sb)
	{
		char a = sb.charAt(pos1);
		char b = sb.charAt(pos2);
		if(a != b)
		{
			String aStr = String.valueOf(a);
			String bStr = String.valueOf(b);
			sb.deleteCharAt(pos1);
			sb.insert(pos1,bStr);
			sb.deleteCharAt(pos2);
			sb.insert(pos2,aStr);

		}
		
		return sb;
		
	}
	public static void sop(Object obj )
	{
		System.out.println(obj);
	}
    public static String reverseVowels(String s) {
		
		if(s == null||s.length()==0)
			return s;
		StringBuilder sb = new StringBuilder(s);
		int left = 0 ;
		int right = s.length()-1;
		while(left < right)
		{
			for(;left<right;left++)
			{
				if(sb.charAt(left) == 'a'||sb.charAt(left) == 'e'||sb.charAt(left) == 'i'||
				sb.charAt(left) == 'o'||sb.charAt(left) == 'u')
				{
					
					break;
				}
					
			}
			for(;right>left;right--)
			{
				if(sb.charAt(right) == 'a'||sb.charAt(right) == 'e'||sb.charAt(right) == 'i'||
				sb.charAt(right) == 'o'||sb.charAt(right) == 'u')
				{
					
					break;
				}
			}
			if(right!=left)
			{
				sb = swap(left,right,sb);right--;left++;
			}
			sop(sb);
		}
		
		return sb.toString();
    }
}
/* This is a much better answer;


public static boolean isVowel(char a){
        switch(a){
             case ('a') : return true;
             case ('e') : return true;
             case ('i') : return true;
             case ('o') : return true;
             case ('u') : return true;
             case ('A') : return true;
             case ('E') : return true;
             case ('I') : return true;
             case ('O') : return true;
             case ('U') : return true;
             default : return false;
        }
    }

    public static String reverseVowels(String s) {
         if (s.length()<2) return s;

         char[] tab = s.toCharArray();
         int j = tab.length - 1;
         int i = 0;

         while( i < j ) {

        if (!isVowel(tab[i]))
            i++;    
        else {
            while (j!=i && !isVowel(tab[j]))
                j--;

            char temp = tab[i];
            tab[i] = tab[j];
            tab[j] = temp;
            i++;
            j--;
        }
    }
    return new String(tab);
} */