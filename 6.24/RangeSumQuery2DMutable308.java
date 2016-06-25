public class NumMatrix {

    int[][] bit;
	int height;
	int width;
	int[][] num;

    public NumMatrix(int[][] matrix) {
		if(matrix == null||matrix.length == 0||matrix[0].length == 0)
			return;
        height = matrix.length;
		width = matrix[0].length;
		//num = matrix;
		num = new int[height][width];
		bit = new int[height+1][width+1];
		for(int i = 0 ; i < height; i++)
			for(int j = 0; j < width; j++)
			{
				update(i,j,matrix[i][j]);
			}
    }

    public void update(int row, int col, int val) {
        
        if (height == 0 || width == 0) return;
		int diff = val - num[row][col];
		num[row][col] = val;
		
        for(int i = row+1; i <= height; i += i&(-i))
		{
			for(int j = col+1; j <= width; j += j&(-j))
				bit[i][j] += diff;
		}
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (height == 0 || width == 0) return 0;
        return sum(row2,col2)+sum(row1-1,col1-1)-sum(row2,col1-1)-sum(row1-1,col2);
    }
	public int sum(int row, int col)
	{
	    if (height == 0 || width == 0) return 0;
		int sum = 0 ;
		row = row +1; col = col +1;
		if(row <= 0|| col <= 0)
			return 0;
		for(int i = row; i >0; i -= i&(-i))
		{
			for(int j = col; j>0; j -= j&(-j))
			{
				sum += bit[i][j];
			}
		}
		return sum;
	}
}

/* public class NumMatrix {

    int[][] tree;
    int[][] nums;
    int m;
    int n;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        tree = new int[m+1][n+1];
        nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) return;
        int delta = val - nums[row][col];
        nums[row][col] = val;
        for (int i = row + 1; i <= m; i += i & (-i)) {
            for (int j = col + 1; j <= n; j += j & (-j)) {
                tree[i][j] += delta;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0) return 0;
        return sum(row2+1, col2+1) + sum(row1, col1) - sum(row1, col2+1) - sum(row2+1, col1);
    }

    public int sum(int row, int col) {
        int sum = 0;
        for (int i = row; i > 0; i -= i & (-i)) {
            for (int j = col; j > 0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }
        return sum;
    } */
}
// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);