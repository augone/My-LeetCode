public class Solution {
    char[] ss;
    int len;
    public boolean canWin(String s) {
        len = s.length();
        ss= s.toCharArray();
        return canWin();
    }
    public boolean canWin()
    {
        for(int i = 0 ; i <= len - 2; i++)// < or <=
        {
            if(ss[i] == '+'&&ss[i+1] == '+')
            {
                ss[i] = '-';ss[i+1] = '-';
                boolean res = !canWin();
                ss[i] = '+';ss[i+1] = '+';
                if(res) 
                    return true;
                
            }
        }
        return false;
    }
    
}