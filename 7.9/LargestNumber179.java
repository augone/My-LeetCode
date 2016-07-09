import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		int[] arr = {121,12};//{3, 30, 34, 5, 9};
		sop(largestNumber(arr));
		
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static String largestNumber(int[] nums) {
		public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null||nums.length == 0)//Corner cases
			return "";
		
	String[] str = new String[nums.length];
	for(int i = 0; i < nums.length; i++)
	{
		str[i] = Integer.toString(nums[i]);//Transfer int into String for comparation
	}
	Arrays.sort(str, new Comparator<String>(){//This is the main part
	        public int compare(String s1, String s2)//compare two strings
		{
//There are three main types. len1 > len2, len2 > len1 and len1 = len2
			int len1 = s1.length();
			int len2 = s2.length();
			if(len1 > len2)
			{
/**If len1 > len2, like "1234" and "789", we just need to compare "123" and "789", right? 
the natural order of "789" is greater than "123" which corresponds to their int value order
So, put 789 in front of 123 is the right way.
*/
				int res = s1.substring(0,len2).compareTo(s2);
/**However, there is a special and tricky case that len1 > len2, and string1 startsWith string2
 eg "121" and "12", by comparing "12" and "12" we got a 0 which means equal.
So we need to keep comparing the substring of string1 to string2 recursively to get the right answer.
So, we compare "1"(which is s1.substring(len2)) to "12", and then compare"1" to "2", this sub case is actually included in len2>len1 case.
*/
				return res == 0? compare(s1.substring(len2),s2):-res;
			}
			if(len1 < len2)
			{
// This type is actually the same to type len1 > len2
				int res = s2.substring(0,len1).compareTo(s1);
				return res == 0? compare(s1,s2.substring(len1)):res;
			}
			else
//If they are the same length, return the result of comparing their natural order.
				return s2.compareTo(s1);
		       }
		});
	StringBuilder sb = new StringBuilder();
	for(String s: str)
	{
                //Another tricky case, we have to make sure our string does not start with "0"
		if(sb.length() == 0&&s.startsWith("0"))
		        continue;
		        
		sb.append(s);
	}
        // If sb.length is 0, it means all numbers are 0, so, return "0", else return the string
	return sb.length() == 0? "0":sb.toString();
    }
}
    }
}