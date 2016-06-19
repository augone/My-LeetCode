import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		PriorityQueue<String> queue =  new PriorityQueue<>();
		queue.add("acv");
		queue.add("dfv");
		queue.add("eds");
		queue.add("dss");
		queue.add("abc");
		while(queue.size()>0)
		{
			sop(queue.poll());
		}
		LinkedList<String> list = new LinkedList<>();
		list.add("a");
		list.add("d");
		list.add("b");
		sop(list);

	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> res = new LinkedList<>();
		Map<String,PriorityQueue<String>> map = new HashMap<String,PriorityQueue<String>>();
		Stack<String> stack = new Stack<>();
		for(int i = 0 ; i < tickets.length; i++)
		{
			String key = tickets[i][0];
			if(!map.containsKey(key))
				map.put(key,new PriorityQueue<String>());
			map.get(key).add(tickets[i][1]);
		}
		stack.push("JFK");
		while(!stack.empty())
		{
			String cur = stack.peek();
			if(map.containsKey(cur)&&map.get(cur).size()>0)
			{
				stack.push(map.get(cur).poll());
			}
			else
				res.addFirst(stack.pop());
		}
		return res;
    }
}