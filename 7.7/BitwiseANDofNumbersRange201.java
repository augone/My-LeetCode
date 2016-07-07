public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 1;
        
        while(m!=n)
        {
            m>>=1;
            n>>=1;
            i<<=1;
        }
        return m*i;
    }
}