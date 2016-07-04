import java.util.*;
class Element
    {
        char[] arr = null;
        int Len = 0;
		String s ;
        Element(String str)
        {
			this.s = str;
            if(str != null)
            {
                if(str.length() != 0)
                {
                    arr = str.toCharArray();
					Len = arr.length;
					System.out.println(arr[0]);
                }
            }
                
        }
		//@override
        public int hashCode()
        {
            int hash = 0;
            if(arr == null)
                return hash - 1234;
            if(Len == 0)
                return hash - 1235;
            if(Len == 1)
                return hash - 1236;
            hash += Len*123;
            for(int i = 1,dup = 677; i < Len; i++,dup++)
            {
                int diff = arr[i] - arr[i-1];
                if(arr[i] < arr[i-1])
                    diff = 26 + diff;
                hash += dup*diff;
            }
			System.out.println(s+" and HashCode:"+hash);
            return hash;
        }
		//@Override
        public boolean equals(Object e)
        {
			//God damn it, you must you OBJECT but not ELEMENT directly.FUCK!!!!!!! Learn a lesson
			if(!(e instanceof Element))
				return false;
			Element ee = (Element)e;
			System.out.println(ee.s+"this:"+this.s);
			System.out.println("compare");
			System.out.println(this.hashCode() +"COMPARE HASH"+ ee.hashCode()+this.arr.length);
            return this.hashCode() == ee.hashCode();
        }
    }
class Solution {
	public static void main(String[] args )
	{
		/* Set<Element> set = new HashSet<>();
		Element a = new Element("a");
		Element b = new Element("a");
		set.add(new Element("a"));
		sop(a.equals(b) );
		set.add(new Element("a"));
		sop(set); */
		String[] str = {"a","b","c","ab","ac","xy","asdf"};
		sop(groupStrings(str));
		//sop(str.substring(0,1));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    
    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> list = new ArrayList<>();
        if(strings == null||strings.length == 0)
            return list;
        HashMap<Element,List<String>> map = new HashMap<>();
        for(int i = 0; i < strings.length; i++)
        {
			Set<Element> set = map.keySet();
			sop(set);
			
            Element e = new Element(strings[i]);
			sop("hashCode:"+e.hashCode());
            if(!set.contains(e))
            {
				sop("Add one");
                map.put(e,new ArrayList<String>());
            }
            List<String> temp = map.get(e);
            temp.add(strings[i]);
            map.put(e,temp);
        }
        Iterator it = map.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<Element, List<String>> me = (Map.Entry) it.next();
            list.add(me.getValue());
        }
        return list;
    }
}