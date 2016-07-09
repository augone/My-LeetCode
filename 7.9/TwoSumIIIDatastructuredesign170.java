public class TwoSum {
    Set<Integer> original = new HashSet<>();
    Set<Integer> twoSum = new HashSet<>();

    // Add the number to an internal data structure.
	public void add(int number) {
	    if(original.contains(number))
	    {
	        twoSum.add(number*2);
            return;
	    }
	    
	    Iterator<Integer> it = original.iterator();
	    while(it.hasNext())
	    {
	        twoSum.add(number+it.next());
	    }
	    original.add(number);
	    

	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    return twoSum.contains(value);
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);

public class TwoSum {
    
    HashMap<Integer, Integer> map = new HashMap<>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    map.put(number,map.containsKey(number)?map.get(number)+1:1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(Map.Entry<Integer, Integer> me : map.entrySet())
	    {
	        int key = me.getKey();
	        int remainder = value - key;
	        if((remainder == key&&me.getValue() > 1)||(remainder != key&&map.containsKey(remainder)))
	            return true;
	       
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);