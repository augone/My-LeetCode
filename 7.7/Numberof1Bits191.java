public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mask = 1;
        int res = 0;
        int count = 32;
        while(n != 0&&count > 0)
        {
            if((mask & n) == 1)
                res++;
            n >>= 1;
            count--;
        }
        return res;
    }
}