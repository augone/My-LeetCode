public class Solution {
    public int integerBreak(int n) {
		int result = 1;
        if(n == 2)
			return 1;
		else if(n==3)
			return 2;
		else if(n == 4)
			return 4;
		while(n>4)
		{
			result *= 3;
			n -= 3;
		}
		return result*n;
    }
}