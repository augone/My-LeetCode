class Solution {
public static void main(String[] args )
	{
		String[] test = { "a",
		  "b",
		  "c",
		  "d",
		  "f"};
		sop(alienOrder(test));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	private static final int R = 26;
    public static String alienOrder(String[] words) {
        if(words == null||words.length == 0)
			return "";
		boolean[][] arr = new boolean[R][R+1];
		StringBuilder sb = new StringBuilder();
		constructGraph(words,arr);
		boolean[] visited = new boolean[R];
		boolean[] visiting = new boolean[R];
	
		return dfs(arr,sb,visited,visiting)?sb.reverse().toString():"";
    }
	public static void constructGraph(String[] words,boolean[][] arr)
	{
		String strPre = words[0];
		char[] preArr = strPre.toCharArray();
		for(char c : preArr)
		{
			arr[c - 'a'][0] = true;
		}
		for(int i = 1; i < words.length; i++)
		{
			String curr = words[i];
			char[] currArr = curr.toCharArray();
			int min = Math.min(preArr.length,currArr.length);
			int k = 0;
			for(; k < min; k++)
			{
				if(currArr[k] != preArr[k])
					break;
				
			}
			sop(k);
			if(k<min&&k < currArr.length)
			{
				arr[preArr[k] - 'a'][currArr[k] - 'a' + 1] = true;
				
			}
			for(;k < currArr.length; k++)
			{
				arr[currArr[k] - 'a'][0] = true;
			}
			strPre = curr;
			preArr = currArr;
				
		}
		for(boolean[] a: arr)
		{
			for(boolean b: a)
			{
				if(b)
					System.out.print("#" + " ");
					
				else
					System.out.print(" " + " ");
			}
				
			sop("");
		}
	}
	public static boolean dfs(boolean[][] arr,StringBuilder sb,boolean[] visited,boolean[] visiting)
	{
		for(int i = 0 ; i < R; i++)
		{
			
			if(arr[i][0]&&!visited[i])
			{
				sop((char)(i + 'a'));
				if(helper(arr,sb,visited,visiting,i))
				{
					return false;
				}
					
			}
				
		}
		return true;
	}
	public static boolean helper(boolean[][] arr,StringBuilder sb,boolean[] visited,boolean[] visiting, int current )
	{
		if(visiting[current])
			return true;
		visiting[current] = true;
		for(int i = 0 ; i < R;i++)
		{
			if(arr[current][i+1]&&!visited[i]&&arr[i][0])
			{
				sop((char)(current + 'a')+"-->"+(char)(i + 'a'));
				if(helper(arr,sb,visited,visiting,i))
				{
					sop((char)(current + 'a')+"-god->"+(char)(i + 'a'));
					return true;
				}
			}
				
					
		}
		sb.append((char)(current + 'a'));
		sop("append"+(char)(current + 'a'));
		
		visiting[current] = false;
		visited[current] = true;
		return false;
	}
}