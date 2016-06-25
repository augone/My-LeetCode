/* The following method use bit */
public class NumMatrix {

    int[][] sum;
    int height;
    int width;
    public NumMatrix(int[][] matrix) {
        if(matrix == null|| matrix.length == 0||matrix[0].length == 0)
			return;
		height = matrix.length;
		width = matrix[0].length;
		sum = new int[height+1][width+1];
		int diff = 0;
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
			    //diff = matrix[i-1][j-1] - sum[i][j];
				//sum[i][j] += diff;
				update(i+1,j+1,matrix[i][j]);
			}
		}
    }

    public void update(int row, int col, int val)
    {
        for(int i = row; i <= height; i+=i&(-i) )
        {
            for(int j = col; j <= width; j+=j&(-j))
            {
                sum[i][j] += val;
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(sum == null||sum.length == 0 || sum[0].length == 0)
			return 0; 
		return calSum(row2+1,col2+1) - calSum(row1,col2+1) - calSum(row2+1,col1)+ calSum(row1,col1);
    }
	public int calSum(int row, int col)
	{
		if(row == 0|| col == 0)
			return 0;
		int s = 0;
		for(int i = row; i > 0; i -= i&(-i) )
		{
			for(int j = col; j > 0; j -= j&(-j))
			{
				s += sum[i][j];
			}
		}
		return s;
	}
}


/*This is method one; 
public class NumMatrix {

    int[][] sum;
    public NumMatrix(int[][] matrix) {
        if(matrix == null|| matrix.length == 0||matrix[0].length == 0)
			return;
		int height = matrix.length;
		int width = matrix[0].length;
		sum = new int[height+1][width+1];
		sum[1][1] = matrix[0][0];
		for(int i = 1; i<height; i++)
		{
			sum[i+1][1] = sum[i][1] + matrix[i][0];
		}
		for(int i = 1; i < width; i++)
		{
			sum[1][i+1] = sum[1][i] + matrix[0][i];
		}
		for(int i = 1; i < height; i++)
		{
			for(int j = 1; j < width; j++)
			{
				sum[i+1][j+1] = matrix[i][j] + sum[i][j+1] +sum[i+1][j]- sum[i][j];
			}
		}
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(sum == null||sum.length == 0 || sum[0].length == 0)
			return 0; 
		return sum[row2+1][col2+1] + sum[row1][col1] - sum[row1][col2+1] - sum[row2+1][col1];
    }
}
 */