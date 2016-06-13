import java.util.*;
class LineReflection
{
	public static void main(String[] args)
	{
		int[][] input = {{0,0},{1,0},{3,0}};
		sop(isReflected(input));
	}
	public static boolean isReflected(int[][] points) {
        if(points == null||points.length == 0)
			return true;
		int pLen = points.length;
		if (pLen == 1)
			return true;
		int max = points[0][0];
		int min = points[0][0];
		for(int i = 0; i < pLen ; i++)
		{
			if(points[i][0]> max)
				max = points[i][0];
			if(points[i][0] < min)
				min = points[i][0];
		}
		final int Max = max;
		final int Min = min;
		sop(Max);
		sop(Min);
		Arrays.sort(points, new Comparator<int[]>(){
			public int compare(int[] pa, int[] pb)
			{
				if(pa[0] == pb[0]) 
				    return pa[0] - Min >= Max - pa[0]? pb[1] - pa[1]: pa[1] - pb[1];
				else 
				    return pa[0] - pb[0];
			}
		});
		for(int start = 0, tail = pLen - 1; tail >= start; start++, tail--)
		{
			sop("start"+start+" end "+ tail);
			if(tail == start)
			{
				sop("asdf");
				if(points[tail][0]*2 == Min+Max)
					return true;
				else 
					return false;
				
				
			}
			if(points[start][0] - Min != Max - points[tail][0])
				return false;
            else if((points[start][0] != points[tail][0])&&(points[start][1] != points[tail][1]))
                return false;
		}
		return true;
			
    }
	public static void sop(Object obj )
	{
		System.out.println(obj);
	}

}