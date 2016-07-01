public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0)
        {
            return 0;
        }
        int houseNum = costs.length;
        int colorNum = costs[0].length;
        int[][] dp = new int[houseNum][colorNum];
        for(int i = 0; i < colorNum; i++)
        {
            dp[0][i] = costs[0][i];
        }
        for(int i = 1; i < houseNum;i++)
        {
            for(int j = 0; j < colorNum; j++)
            {
                dp[i][j] = costs[i][j] + findTheMinCost(i - 1, j , dp);
            }
        }
        return findTheMinCost(houseNum - 1, -1, dp);
    }
    public int findTheMinCost(int row, int col, int[][] dp)
    {
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < dp[0].length; i++)
        {
            if(col != i)
            {
                min = Math.min(min,dp[row][i]);
            }
        }
        return min;
    }
}