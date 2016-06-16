import java.util.*;
class MovingAverage {

	int size = 0;
	LinkedList<Integer> ll = new LinkedList<Integer>();
	double sum = 0;
	int tempSize = 0;
	public static void main(String[] args)
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(3);
		list.add(2);
		for(int i = 0; i < 5; i++)
			sop(list.pollLast());
		list.add(6);
		list.add(4);
		for(int i = 0; i < 5; i++)
			sop(list.pollLast());
		
	}
	public static void sop(Object obj )
	{
		System.out.println(obj);
	}
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
		this.tempSize = size;
    }
    
    public double next(int val) {
        

		if(ll == null)
		{
			ll.add(val);
			size--;
			sum += val;
			return sum;
		}
		if(size>0)
		{
			ll.add(val);
			size--;
			sum += val;
			return sum/ll.size();
		}
		else
		{
			ll.add(val);
			sum += val;
			sum -= ll.pollFirst();//not pollLast
			return sum/tempSize;
		}
			
			
			
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */