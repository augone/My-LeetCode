import java.util.*;
class Solution {
    public static void main(String[] args )
	{
		sop("1000".compareTo("130"));
		sop(strobogrammaticInRange("0","100000000"));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
		
	}

    static char[][] pair = {{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
    static int count = 0;
    public static int strobogrammaticInRange(String low, String high) {
        if(low == null||low.length() == 0||high == null||high.length() == 0)
            return 0;
        int lenLow = low.length(), lenHigh = high.length();
        if(lenHigh - lenLow > 1&&lenHigh > 3)
        {
            int[] dp = new int[lenHigh+1];
            dp[0] = 0;
            dp[1] = 3;
            dp[2] = 4;
            dp[3] = 12;
            for(int i = 4; i <= lenHigh; i++)
            {
                if(i % 2 == 0)
                {
                    dp[i] = dp[i-2]*5;
                }
                else dp[i] = dp[ i - 1]*3;
            }
			for(int i = 0 ;i < dp.length; i++)
			{
				sop(dp[i]);
			}
            for(int i = lenLow+1; i <= lenHigh-1; i++)
            {
                count+=dp[i];
            }
            for(int i = lenLow; i<=lenHigh; i++)
            {
                if(i != lenLow)
                {
                    i = lenHigh;
                    dfs(i,low,high,new char[i],0,i-1);
                    break;
                }
                dfs(i,low,high,new char[i],0,i-1);
                   
            }
        }
        else
        {
            for(int i = lenLow; i<=lenHigh; i++)
            {
				sop("No way");
                dfs(i,low,high,new char[i],0,i-1);
                   
            }
        }
        
        return count;
    }
    public static void dfs(int len, String low, String high, char[] arr, int left, int right)
    {
        if(left > right)
        {
            
            String s = new String(arr);
            if(len == low.length()&&s.compareTo(low)<0 || len == high.length()&&s.compareTo(high)>0)
                return;
            count++;
            return;
        }
        for(char[] p:pair)
        {
            arr[left] = p[0];
            arr[right] = p[1];
            if(len != 1 && arr[0] =='0') continue;
            if(left<right||(left == right&&p[0] == p[1])) 
                dfs(len , low, high, arr, left+1, right-1);

        }
        
    }
}
