public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null||costs.length == 0||costs[0].length == 0)
            return 0;
        int houseNum = costs.length;
        int colorNum = costs[0].length;
        int[][] dp = new int[houseNum][colorNum];
        for(int i = 0; i < colorNum; i++)
        {
            dp[0][i] = costs[0][i];
        }
        for(int i = 1 ; i < houseNum; i++)
        {
            for(int j = 0; j < colorNum; j++)
            {
                dp[i][j] = costs[i][j]+findMinCost(i-1,j,dp);
            }
        }
        return findMinCost(houseNum - 1, -1, dp);
    }
    public int findMinCost(int row, int col, int[][] dp)
    {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < dp[0].length; i++)
        {
            if(col != i)
            {
                min = Math.min(dp[row][i],min);
            }
                
        }
        return min;
    }
}