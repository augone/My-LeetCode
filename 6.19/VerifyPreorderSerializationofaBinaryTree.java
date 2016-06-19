import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		String test = "#,#";
		sop(isValidSerialization(test));

	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static boolean isValidSerialization(String preorder) {
        LinkedList<String> queue = new LinkedList<>();
		if(preorder == null&&preorder.length() == 0)
			return true;
		String[] arr = preorder.split(",");
		queue.add(arr[0]);
		sop(arr.length);
		int size = queue.size();
		if(arr.length == 1&& !arr[0].equals("#"))
			return false;
		for(int k = 1 ; !(size == 0&&k==arr.length); )
		{
			sop("new loop");
			for(int i = 0; i < size; i++)
			{
				String cur = queue.pollFirst();
				sop("cur:"+cur);
				if(!cur.equals("#"))
				{
					if(k<arr.length)
						queue.add(arr[k]);
					else 
						return false;
					if(++k<arr.length)
					{
						queue.add(arr[k]);
						k++;
					}
					else
						return false;
						
					
					sop(k);
				}
				
					
			}
			size = queue.size();
			if(size == 0&&k<arr.length)
				return false;
		}
		return true;
		
		/* for(String s: arr)
		{
			queue.add(s);
		}
		sop(queue.pollFirst());
		sop(queue.pollLast());
		for(String s: arr)
		{
			sop(s+s.equals("4"));
		}
		return true; */
    }
}