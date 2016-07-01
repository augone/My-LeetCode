
public class Solution {
    public int numWays(int n, int k) {
        int[] dp = new int[n];
        if(n == 0|| k == 0)
            return 0;
        if(n == 1)
            return k;
        if(k== 1&&n>2)
            return 0;
        dp[0] = k;
        dp[1] = k*k;
        for(int i = 2; i < n ; i++)
        {
            dp[i] = (k-1)*(dp[i-1]+dp[i - 2]);
        }
        return dp[n-1];
    }
}




/* public class Solution {
    public int numWays(int n, int k) {
        // 当n=0时返回0
        int dp[] = {0, k , k*k, 0};
        if(n <= 2){
            return dp[n];
        }
        for(int i = 2; i < n; i++){
            // 递推式：第三根柱子要么根第一个柱子不是一个颜色，要么跟第二根柱子不是一个颜色
            dp[3] = (k - 1) * (dp[1] + dp[2]);
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[3];
    }
} */