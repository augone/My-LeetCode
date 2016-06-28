/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int c = divide(0,n-1);
        if(c == -1)
            return -1;
        else{
            for(int i = 0 ; i < n;i++)
            {
                if(i == c ) continue;
                if(knows(c,i))
                    return -1;
            }
            return c;
        }
    }
    public int divide(int low, int high)
    {
        if(high <= low)
            return low;
        int mid = (high + low)/2;
        return select(divide(low,mid),divide(mid+1,high));
    }
    public int select(int a, int b)
    {
        if(a == -1) return b;
        if(b == -1) return a;
        if(knows(a,b)) return b;
        if(knows(b,a)) return a;
        else return -1;
    }
}