class TEST
{
	public static void main(String[] args )
	{
		int[] arr = {1 , 3 , 5 };
		NumArray na = new NumArray(arr);
		sop(na.sumRange(0,2));
		
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
class NumArray {
	

	public void sop(Object obj)
	{
		System.out.println(obj);
	}
    int[] bit;
	int[] copy;
    int Len ;
	public NumArray(int[] nums) {
        if(nums == null || nums.length == 0)
			return ;
		Len = nums.length;
		bit = new int[Len + 1];
		copy = new int[Len];
		for(int i = 0 ; i < Len ; i++)
		{	
			update(i,nums[i]);
		}
    }

    void update(int i, int val) {
        if(Len == 0)
			return;
		int diff = val - copy[i];
		copy[i] = val;
		for(int pos = i + 1; pos <=Len; pos += pos&(-pos))
		{
			bit[pos] += diff;
		}
    }

    public int sumRange(int i, int j) {
        if(Len == 0)
			return 0;
		return sum(j) - sum(i-1);
    }
    public int sum(int pos )
    {
        int sum = 0 ;
        for(int i = pos+1; i >0; i -= i&(-i))
        {
            sum += bit[i];
			sop(sum);
        }
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);