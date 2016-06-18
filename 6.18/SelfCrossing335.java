/* case 1: if go up, it may intersect the last top or the 
second last bottom. the same goes for go left and go down 
and go right.You have to keep track the last 8 segments.

case 2: this is tricky. It only happens in the fifth step. 
Going up and go through the (0,0). */

import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		int[] test = {1,1,2,1,1};//{3,1,1,5,2};
		sop(isSelfCrossing(test));
		/* List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(4);
		list.add(3);
		list.add(7);
		list.add(3);
		list.add(7);
		sop(list);
		list.remove(0);
		sop(list);
		sop(list.get(0)); */
		
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	static class Pair
	{
		public int x, y;
		Pair(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	public static boolean check(Pair p1,Pair p2,Pair p3,Pair p4)
	{
		//sop(p1.x+"a"+p1.y+"||||||"+p2.x+"b"+p2.y+"||||||"+p3.x+"c"+p3.y+"||||||"+p4.x+"d"+p4.y);
		if(p1.x == p2.x)
		{
			if(p1.y>=p2.y)
			{
				
				if(p1.y>=p3.y&&p3.y>=p2.y)
				{
					if(p3.x>=p4.x)
					{
						if(p3.x>=p1.x&&p1.x>=p4.x)
							return true;
					}
					else{
						if(p4.x>=p1.x&&p1.x>=p3.x)
							return true;
					}
					
				}
			}
			else{
				if(p2.y>=p3.y&&p3.y>=p1.y)
				{
					if(p3.x>=p4.x)
					{
						if(p3.x>=p1.x&&p1.x>=p4.x)
							return true;
					}
					else{
						if(p4.x>=p1.x&&p1.x>=p3.x)
							return true;
					}
					
				}
			}
		}
		else{
			if(p1.x>=p2.x)
			{
				
				if(p1.x>=p3.x&&p3.x>=p2.x)
				{
					if(p3.y>=p4.y)
					{
						if(p3.y>=p1.y&&p1.y>=p4.y)
							return true;
					}
					else{
						if(p4.y>=p1.y&&p1.y>=p3.y)
							return true;
					}
					
				}
			}
			else{
				if(p2.x>=p3.x&&p3.x>=p1.x)
				{
					if(p3.y>=p4.y)
					{
						if(p3.y>=p1.y&&p1.y>=p4.y)
							return true;
					}
					else{
						if(p4.y>=p1.y&&p1.y>=p3.y)
							return true;
					}
					
				}
			}
		}
		return false;
	}
	public static boolean checkOnSameLine(Pair p1,Pair p2, Pair p3)
	{
		if(p1.x == p2.x)
		{
			if(p3.x == p2.x)
			{
				if(p1.y>=p2.y)
				{
					if(p1.y>=p3.y&&p3.y>=p2.y)
						return true;
				}
				else{
					if(p2.y>=p3.y&&p3.y>=p1.y)
					{
						return true;
					}
				}
			}
			
		}
		else{
			if(p3.y == p2.y)
			{
				if(p1.x>=p2.x)
				{
					if(p1.x>=p3.x&&p3.x>=p2.x)
						return true;
				}
				else{
					if(p2.x>=p3.x&&p3.x>=p1.x)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
    public static boolean isSelfCrossing(int[] x) {
        if(x.length<3)
			return false;
		List<Pair> list = new ArrayList<>();
		list.add(new Pair(0,0));
		int Len = x.length;
		if(Len<6)
		{
			for(int i = 0 ; i < Len; i++)
			{
				Pair p = getPair(x,i,list);
				/*  list.get(list.size()-1);
				switch(i%4)
				{
					case 0: p.y += x[i];break;
					case 1: p.x -= x[i];break;
					case 2: p.y -= x[i];break;
					case 3: p.x += x[i];break;
				} */
				if(list.size()>=4)
				{
				    if(i == 4&&checkOnSameLine(list.get(0),list.get(1),p))
							return true;
					//sop("before checking:"+list.get(0).x+" "+list.get(0).y);
					if(check(list.get(0),list.get(1),list.get(3),p))
					{
						//sop(check(list.get(0),list.get(1),list.get(3),p));
						return true;
					}
						
					else
					{
						
						list.add(p);
					}
						
					//list.remove(0);
					
				}
				else 
				{
					
					//for(int asdf = 0; asdf < list.size();asdf++)
						//sop("before adding: "+list.get(asdf).x+" "+list.get(asdf).y);
					list.add(p);
					
				}
				
			}
			return false;
			
		}
		for(int i = 0; i < Len; i++)
		{
			if(i<5)
			{
				list.add(getPair(x,i,list));
			}
			else{
				Pair p = getPair(x,i,list);
				if(check(list.get(0),list.get(1),list.get(5),p)||check(list.get(2),list.get(3),list.get(5),p))
				{
					//sop(check(list.get(0),list.get(1),list.get(5),p));
					//sop(check(list.get(2),list.get(3),list.get(5),p));

					return true;
				}
					
				else{
					list.remove(0);
					list.add(p);
				}
			}
		}
		//list.add(new Pair());
		return false;
    }
	public static Pair getPair(int[] x, int i, List<Pair> list)
	{
		Pair p1 = list.get(list.size()-1);
		Pair p = new Pair(p1.x,p1.y);
		//sop(p.x+""+p.y);
		switch(i%4)
		{
			case 0: p.y += x[i];break;
			case 1: p.x -= x[i];break;
			case 2: p.y -= x[i];break;
			case 3: p.x += x[i];break;
		}
		//sop(p.x+"getPair"+p.y);
		return p;
	}
}