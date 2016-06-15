class Solution {
	private boolean[] valid = new boolean[9];
	
    public int numberOfPatterns(int m, int n) {
		int result = 0 ;
        for(int len = m; len <=n; len++)
		{
			result += goCount(-1,len);
			for(int i = 0; i < 9; i++)
			{
				valid[i] = false;
			}
		}
		return result;
    }
	public boolean testValidation(int last, int next)
	{
		if(valid[next]) return false;
		if(last == -1)
			return true;
		if((last + next)%2 == 1)
			return true;
		int mid = (last + next)/2;
		if(mid == 4)
			return valid[4];
		if(last/3!=next/3&&last%3!=next%3)
			return true;
		return valid[mid];
		
	}
	public int goCount(int last, int len)
	{
		if (len == 0)
			return 1;
		int sum = 0;
		for(int i = 0 ; i < 9; i++)
		{
			if(testValidation(last,i))
			{
				valid[i] = true;
				sum += goCount(i,len-1);
				valid[i] = false;
			}
			
		}
		return sum;
	}
}