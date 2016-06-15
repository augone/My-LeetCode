class TicTacToe {

	int[][] board = null;
	int chessNum = 0;
	int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.board = new int[n][n];
		this.n = n;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0 ; j < n; j++)
			{
				board[i][j] = 0;
			}
		}
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        chessNum++;
		if(player == 1)
			board[row][col] = player;
		else 
			board[row][col] = -1;
		
		return goCheck(row,col);
		
    }
	public int goCheck(int row, int col)
	{
		
		int rowSum = sumRow(row);
		int colSum = sumCol(col);
		if(rowSum == n||colSum == n)
			return 1;
		else if (rowSum == -n||colSum == -n)
			return 2;
		if(onDiagnal( row,  col))
			return cheakDiagnal();
		return 0;
		
	}
	public int cheakDiagnal()
	{
		int sum1 = 0;
		int sum2 = 0;
		for(int i = 0 ; i < n ; i++)
		{
			sum1 += board[i][i];
		}
		for(int i = 0 ; i < n ; i++)
		{
			sum2 += board[i][n-i-1];
		}
		if(sum1 == n||sum2 == n)
			return 1;
		else if (sum1 == -n||sum2 == -n)
			return 2;
		return 0;
	}
	public boolean onDiagnal(int row, int col)
	{
		if(row == col||row == n-1-col)
			return true;
		else 
			return false;
	}
	public int sumRow(int row)
	{
		int sum = 0;
		for(int i = 0;i < n; i++)
		{
			if(board[row][i] == 0)
				return sum;
			sum += board[row][i];
		}
		return sum; 
	}
	public int sumCol(int col)
	{
		int sum = 0;
		for(int i = 0;i < n; i++)
		{
			if(board[i][col] == 0)
				return sum;
			sum += board[i][col];
		}
		return sum; 
	}
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */