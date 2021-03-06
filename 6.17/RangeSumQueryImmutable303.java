public class NumArray {
    long[] sums;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        sums = new long[nums.length];
        long sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            sums[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if(i!=0)
            return (int)(sums[j] - sums[i-1]);
        else 
            return (int)sums[j];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);