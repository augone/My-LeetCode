class Solution {
	public static void main(String[] args)
	{
		sop(isPowerOfFour(2));
		sop(isPowerOfFour(4));
		sop(isPowerOfFour(5));
		sop(isPowerOfFour(15));
		sop(isPowerOfFour(256));	
		sop(isPowerOfFour(255));
		sop(isPowerOfFour(256*256*256));
	}
	public static void sop(Object obj )
	{
		System.out.println(obj);
	}
    public static boolean isPowerOfFour(int num) {
        if(num<=0)
			return false;
		if(num == 1)
			return true;
		int count0 = 0;
		int mask = num&1;
		while((mask^0) == 0)
		{
			num = num>>1;
			mask = num&1;
			//sop("oh:"+num);
			count0++;
		}
		if(num!=1)
			return false;
		if(count0%2==0)
			return true;
		return false;
    }
}