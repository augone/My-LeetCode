import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		List<String> res = new ArrayList<>();
		res = generateAbbreviations("word");
		for(int i = 0; i<res.size();i++)
		{
			sop(res.get(i));
		}
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
		dfs(res,"",0,word);
		return res;
    }
	public static void dfs(List<String> res, String curr, int start, String word)
	{
		res.add(curr+word.substring(start));
		if(start == word.length())
			return;
		int i = 0 ;
		if(start > 0)
		{
			i = start + 1;
		}
		for(;i<word.length();i++)
		{
			String prefix = curr+word.substring(start,i);
			for(int j = 1; j <= word.length() - i; j++)
			{
				dfs(res,prefix+j,j+i,word);
			}
		}
	}
}

/* 
这道题第一步一定要理解题意，首先要考虑的是会有多少种结果。仔细观察会
发现，最终会有Cn0 + Cn1 + Cn2 + ... + Cnn = 2^n种结果。
然后就很显然应该用DFS, 每次recursion存下当前结果，然后继续DFS。
要注意下一步DFS的起始位置要与当前结束位置隔一个，否则就会出现有
连续数字的结果，不希望出现连续数字的原因是因为连续数字可以合并成
一个数字，已经算进去了，比如ab111就是ab3, 我们要的结果是ab3。
public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(res, "", 0, word);
        return res;
    }
    
    public void dfs(List<String> res, String curr, int start, String s) {
        res.add(curr + s.substring(start));                   
        if (start == s.length()) 
            return;
                                                
        // 定义新的起始位置
        int i = 0;
        
        // 除了最开始，起始位置都要与之前结尾位置隔一个
        if (start > 0) {
            i = start + 1;
        }
        
        for (; i < s.length(); i++) {
            String prefix = curr + s.substring(start, i);               
            // 以ith字符开头，依次替换j个字母成数字。
            for (int j = 1; j <= s.length() - i; j++) {
                dfs(res,  prefix+ j, i + j, s);
            }
        }
    }
} */