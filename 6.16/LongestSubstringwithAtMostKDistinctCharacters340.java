public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] arr = new int[128];
		int l = 0;
		int r = 0;
		int uniK = 0;
		int maxLen = 0;
		while(r<s.length())
		{
			if(arr[s.charAt(r)] == 0)
			{
				uniK++;
				
				while(l<=r&&uniK>k)
				{
					arr[s.charAt(l)]--;
					if(arr[s.charAt(l)] == 0)
						uniK--;
				
					l++;
				}
				
			}
			arr[s.charAt(r)]++;
			r++;
			maxLen = Math.max(maxLen,r-l);
			
		}
		return maxLen;
    }
}