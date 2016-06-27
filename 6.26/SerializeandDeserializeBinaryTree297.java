/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 import java.util.*;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x )
	{
		val = x;
	}
}

   
class Codec {

// Encodes a tree to a single string.
	public static void main(String[] args )
	{
		TreeNode head = new TreeNode(3);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(4);
		TreeNode node = new TreeNode(1);
		left.left = node;
		head.left = left;
		head.right = right;
		sop(serialize(head));
		sop(deserialize(serialize(head)).left.left.val);
		
		//sop(str.substring(0,1));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val) ;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root.left);
        list.add(root.right);
		while(list.size()>0)
		{
			TreeNode node = list.remove(0);
			if(node == null)
			{
				sb.append(",#");
			}
			else{
			    sb.append(",");
			    sb.append(node.val);
		
				list.add(node.left);
				list.add(node.right);
			}
		}
		return sb.toString();//helper(list,rtStr);
		
        
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data == null||data.length() == 0)
			return null;
		String delimiter = ",";
		String[] arr = data.split(delimiter);
		TreeNode head = new TreeNode(Integer.parseInt(arr[0]));
		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(head);

		int childPos = 1;
		while(list.size()>0)
		{

			TreeNode next = list.remove(0);
			if(next!= null)
			{
				if(!arr[childPos].equals("#")){
					
					next.left = new TreeNode(Integer.parseInt(arr[childPos]));
					list.add(next.left);
				}
				childPos++;
				if(!arr[childPos].equals("#"))
				{
					next.right = new TreeNode(Integer.parseInt(arr[childPos]));
					list.add(next.right);
				}
				childPos++;
			}
			
			
		}
		
		return head;
			
    }
}
 
 /* The following method is Time Limit Exceeded */
/* import java.util.*;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x )
	{
		val = x;
	}
}

class Codec {

   // Encodes a tree to a single string.
	public static void main(String[] args )
	{
		TreeNode head = new TreeNode(3);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(4);
		TreeNode node = new TreeNode(1);
		left.left = node;
		head.left = left;
		head.right = right;
		sop(serialize(head));
		sop(deserialize(serialize(head)).left.left.val);
		
		//sop(str.substring(0,1));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static String serialize(TreeNode root) {
        if(root == null)
            return "";
        String rtStr = "";
        rtStr += root.val;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root.left);
        list.add(root.right);
		return helper(list,rtStr);
		
        
    }
	public static String helper(LinkedList<TreeNode> list, String str)
	{
		if(list == null || list.size() == 0)
			return str;
		int size = list.size();
		String comma = ",";
		while(list.size()>0)
		{
		    size = list.size();
		    for(int i = 0; i < size; i++)
    		{
    			TreeNode node = list.pollFirst();
    			if(node != null)
    			{
    				str += comma+node.val;
    				list.add(node.left);
    				list.add(node.right);
    				
    			}
    			else
    			{
    				str += comma + "#";
    			}
    				
    			
    		}
		}
		
		return str;
	}

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data == null||data.length() == 0)
			return null;
		String delimiter = ",";
		String[] arr = data.split(delimiter);
		for(String str: arr)
		{
			sop(str);
		}
		int start = 1;
		TreeNode head = new TreeNode(Integer.parseInt(arr[0]));
		LinkedList<TreeNode> list = new LinkedList<>();
		if(arr[1].equals("#"))
			head.left = null;
		else{
			head.left = new TreeNode(Integer.parseInt(arr[1]));
			list.add(head.left);
		}
		if(arr[2].equals("#"))
			head.right = null;
		else{
			head.right = new TreeNode(Integer.parseInt(arr[2]));
			list.add(head.right);
		}
		int size = list.size();
		int childPos = 3;
		while(list.size()>0)
		{
			sop("size:"+list.size());
			size = list.size();
			for(int i = 0; i < size; i++)
			{
				TreeNode next = list.pollFirst();
				sop("inner size:"+ size);
				if(arr[childPos].equals("#"))
					next.left = null;
				else
				{
					next.left = new TreeNode(Integer.parseInt(arr[childPos]));
					list.add(next.left);
				}
				sop("childPos"+arr[childPos]);
				childPos++;
				if(arr[childPos].equals("#"))
					next.right = null;
				else
				{
					next.right = new TreeNode(Integer.parseInt(arr[childPos]));
					list.add(next.right);
				}
				sop("childPos"+arr[childPos]);
				childPos++;
				sop("inner size:"+ size);
				
			}
			//start = childPos - 1;
		}
		
		return head;
			
    }
} */

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));