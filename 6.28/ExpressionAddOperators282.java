import java.util.*;
/* This problem has a lot of edge cases to be considered:

    overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
    0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
    a little trick is that we should save the value that is to be multiplied in the next recursion.
 */
class Solution {
	public static void main(String[] args )
	{
		String str = "123";
		sop(addOperators(str,6));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static List<String> addOperators(String num, int target) {
		ArrayList<String> list = new ArrayList<>();
		if(num == null || num.length() == 0)
				return list;
        
		
		dfs(list,num,target,"",0,0,0);
		return list;
    }

	
	public static void dfs(ArrayList<String> list, String num, int target, String local, long soFar, int pos, long multed)
	{
		if(pos ==  num.length())
		{
			if(soFar == target)
			{
				list.add(local);
			}
			return;
			
		}
		
		for(int i = pos; i < num.length();i++)
		{
			if(i!= pos&&num.charAt(pos)=='0') break;
			String sub = num.substring(pos, i + 1);
			long temp = Long.parseLong(sub);
			if(pos == 0)
			{
				dfs(list,num,target,sub,temp,i+1,temp);
			}
			else
			{
				dfs(list,num,target,local+"+"+sub,temp+soFar,i+1,temp);
				dfs(list,num,target,local+"-"+sub,soFar - temp,i+1,-temp);
				dfs(list,num,target,local+"*"+sub,soFar - multed + multed*temp,i+1,temp*multed);

			}
		}
	}
		
		
		
		
		
}