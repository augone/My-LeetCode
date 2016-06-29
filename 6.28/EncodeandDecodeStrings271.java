import java.util.*;

public class Codec {

    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        if(strs == null||strs.size() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for(String s: strs)
        {
            sb.append((char)(s.length()>>16)).append((char)(s.length())).append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        ArrayList<String> list = new ArrayList<>();
        if(s == "")
            return list;
        char[] arr = s.toCharArray();
        for(int i = 0, len = 0 ; i < arr.length; i += len)
        {
		    len = ((0+arr[i])<<16)+arr[++i];
		    list.add(new String(arr,++i,len));
        }
        return list;
    }
}

//The following method failed when meeting [""]
class Solution {
	public static void main(String[] args )
	{
		ArrayList<String> list = new ArrayList<>();
		list.add("");
		/* list.add("");
		list.add("");
		list.add(""); */
		decode(encode(list));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        if(strs == null||strs.size() == 0)
            return "";
        String delimiter1 = "LTX";
        String delimiter2 = "MXD";
        String res = "";
        for(String str: strs)
        {
			if(str.equals("\"\""))
				res += delimiter2+delimiter1;
			else
				res += str+delimiter1;
			sop(res);
        }
        return res;
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        ArrayList<String> list = new ArrayList<>();
        if(s == "")
            return list;
        String[] arr = s.split("LTX");
		sop(arr.length);
		//if()
        for(int i = 0 ; i < arr.length; i++)
        {
			if(arr[i].startsWith("MXD"))
				list.add("");
			else
				list.add(arr[i]);
        }
		sop(list);
        return list;
    }
}