import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		int[] arr = {9,7,8,4,5};
		sop(countSmaller(arr));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static List<Integer> countSmaller(int[] nums) {
        if(nums == null||nums.length == 0)
			return new ArrayList<Integer>();
		int Len = nums.length;
		ArrayList<Integer> list = new ArrayList<>();
		int[] temp = nums.clone();
		Arrays.sort(temp);
		int[] bit = new int[Len + 1];
		for(int i = 0 ; i < Len; i++)
		{
			addValue(bit,Arrays.binarySearch(temp,nums[i]),1);
			sop("1");
		}
		for(int i = 0; i < Len; i++)
		{
			int idx = Arrays.binarySearch(temp,nums[i]);
			addValue(bit,idx,-1);
			list.add(getValue(bit,idx-1));
			sop("2");
		}
		return list;
    }
	public static void addValue(int[] bit,int idx, int val)
	{
		for(int i = idx+1; i < bit.length; i += i&-i)
			bit[i] += val;
	}
	public static int getValue(int[] bit, int idx)
	{
		int sum = 0;
		for(int i = idx+1; i >0; i -= i & -i)
			sum += bit[i];
		return sum;
	}
}


/* public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        int[] bit = new int[nums.length + 1];
        for (int i : nums) addVal(bit, Arrays.binarySearch(tmp, i), 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Arrays.binarySearch(tmp, nums[i]);
            addVal(bit, idx, -1);
            res.add(query(bit, idx - 1));
        }
        return res;
    }

    // add val to the ith element, O(logN)
    public void addVal(int[] bit, int i, int val) {
        for (i += 1; i < bit.length; i += i & -i) bit[i] += val;
    }

    // query the range sum of [0, i], O(logN)
    public int query(int[] bit, int i) {
        int res = 0;
        for (i += 1; i > 0; i -= i & -i) res += bit[i];
        return res;
    }
}
 */


/*
THIS BINARY SEGMENT TREE SOLUTION. 
public class Solution {
    //Segment tree based solution, map distinct elements in nums in order to [0,1, ..., N-1] for better memory utlization; 
    //add and count elements of nums from right to left: at iteration i, count sum of all elements smaller than nums[i] using 
	//Segment.getSum, then add 1 to the count of nums[i] in segment using update

    public List<Integer> countSmaller(int[] nums) {
        //map distinct elements in nums in order to [0,1,...N-1] , e.g. [5,2,6,5,1] ---> [2,1,3,2,0]
        int[] numsSorted = Arrays.copyOf(nums, nums.length);        //fist sort nums [5,2,6,5,1] ---> [1,2,5,5,6]
        Arrays.sort(numsSorted);
                                                                    //then create map [1,2,5,5,6] ---> [0,1,2,2,3]
        HashMap<Integer, Integer> nums2Idx = new HashMap<Integer, Integer>();
        int stIdx = 0;         
        for(int i = 0; i < numsSorted.length; i++)
            if(!nums2Idx.containsKey(numsSorted[i]))       
				nums2Idx.put(numsSorted[i], stIdx++);

        //create segment tree while count smaller elements from right to left
        SegmentTree st = new SegmentTree(stIdx);
        Integer[] res = new Integer[nums.length];
        for(int i = nums.length-1; i >= 0; i--){
            res[i] = st.getSum(0, nums2Idx.get(nums[i])-1);          //sum of all added nums smaller than nums[i]
            st.increment(nums2Idx.get(nums[i]), 1);                  //add 1 count for nums[i]
        }
        return Arrays.asList(res);
    }
}
class SegmentTree{
    private int[] st;
    private final int N;

    public SegmentTree(int n){
        this.N = n;
        if(N == 0)  return;
        int height = (int) Math.ceil( Math.log(n) / Math.log(2));
        int maxSize = 2 * (int) Math.pow(2, height) - 1;
        st = new int[maxSize];
    }

    public int getSum(int i, int j){
        if(i > j)   return 0;
        return getSumUtil(0, N-1, i, j, 0);    
    }

    private int getSumUtil(int ss, int se, int qs, int qe, int si){
        if(qe < ss || se < qs)      return 0;
        if(qs <= ss && se <= qe)    return st[si];
        int mid = getMid(ss, se);
        return getSumUtil(ss, mid, qs, qe, 2*si+1) + getSumUtil(mid+1, se, qs, qe, 2*si+2);
    }

    public void increment(int idx, int val){
        incrementUtil(0, N-1, idx, val, 0);
    }

    private void incrementUtil(int ss, int se, int idx, int val, int si){
        if(ss > idx || se < idx)    return;
        st[si] += val;
        if(ss < se){
            int mid = getMid(ss, se);
            incrementUtil(ss, mid, idx, val, 2*si+1);
            incrementUtil(mid+1, se, idx, val, 2*si+2);
        }
    }

    private int getMid(int s, int e){
        return s + (e - s)/2;
    }
} */