class Solution {
	public static void main(String[] args)
	{
		int[] get = countBits(5);
		sop("-----------cut-----------");
		int[] get1 = countBits(8);
		sop("-----------cut-----------");
		int[] get2 = countBits(6);
		sop("-----------cut-----------");
		int[] get3 = countBits(256);
	}
	public static void sop(Object obj )
	{
		System.out.println(obj);
	}
    public static int[] countBits(int num) {
        int[] result = new int[num+1];
		result[0] = 0 ;
		if(num == 0) return result;
		int count = 1;
		sop(result[0]);
		for(int i = 0; i < count; i++)
		{
			
			if(count+i < num+1)
			{
				
				result[count+i] = result[i]+1;
				sop(result[count+i]);
			}
				
			else 
				break;
			if(i == count-1) 
			{
				i = -1;
				count *= 2;
			}
			
		}
		return result;
    }
}