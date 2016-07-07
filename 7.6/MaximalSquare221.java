
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null||matrix.length == 0||matrix[0].length == 0)
            return 0;
        int height = matrix.length;
        int width = matrix[0].length;
           
        int[][] arr = new int[height][width];//create a new int[][] to translate char into int for later use
        for(int row = 0 ; row < height; row++)
        {
            for(int col = 0 ; col < width; col++)
            {
                arr[row][col] = matrix[row][col] - '0';
            }
        }
        int[][] dp = new int[height][width];
        boolean containsOne = false;
        for(int row = 0 ; row < height; row++)
        {
            if(arr[row][0] == 1) containsOne = true;
                dp[row][0] = arr[row][0];
        }
        for(int col = 0 ; col < width; col++)
        {
            if(arr[0][col] == 1) containsOne = true;
                dp[0][col] = arr[0][col];
        }
        if(height == 1 || width == 1)
            return containsOne? 1 : 0;
        int res = containsOne?1:0;

        for(int row = 1 ; row < height; row++)
        {
            for(int col = 1 ; col < width; col++)
            {
                if(arr[row][col] == 1)
                {
                    int minAdj = Math.min(dp[row-1][col-1],Math.min(dp[row ][col-1],dp[row-1][col]));
                    dp[row][col] = (int)Math.sqrt(minAdj)*2 + minAdj + 1;
                    res = Math.max(dp[row][col],res);
                    
                }
                
            }
        }
        return res;
    }
}
/* 
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null||matrix.length == 0||matrix[0].length == 0)
            return 0;
        int height = matrix.length;
        int width = matrix[0].length;
           

        int[][] dp = new int[height][width];
        boolean containsOne = false;
        for(int row = 0 ; row < height; row++)
        {
            if(matrix[row][0] == '1')
            {
                containsOne = true;
                dp[row][0] = 1;
            }
        }
        for(int col = 0 ; col < width; col++)
        {
            if(matrix[0][col] == '1')
            {
                containsOne = true;
                dp[0][col] = 1;
            }
                
        }
        if(height == 1 || width == 1)
            return containsOne? 1 : 0;
        int res = containsOne?1:0;

        for(int row = 1 ; row < height; row++)
        {
            for(int col = 1 ; col < width; col++)
            {
                if(matrix[row][col] == '1')
                {
                    int minAdj = Math.min(dp[row-1][col-1],Math.min(dp[row ][col-1],dp[row-1][col]));
                    dp[row][col] = (int)Math.sqrt(minAdj)*2 + minAdj + 1;
                    res = Math.max(dp[row][col],res);
                    
                }
                
            }
        }
        return res;
    }
} */