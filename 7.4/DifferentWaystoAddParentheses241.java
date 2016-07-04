public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        if(input == null||input.length() == 0)
            return list;
        for(int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i) == '+'||input.charAt(i) == '*'||input.charAt(i) == '-')
            {
                List<Integer> part1 = diffWaysToCompute(input.substring(0,i));
                List<Integer> part2 = diffWaysToCompute(input.substring(i+1));
                for(int a:part1)
                {
                    for(int b: part2)
                    {
                        switch (input.charAt(i))
                        {
                            case '+':list.add(a + b);break;
                            case '-':list.add(a - b);break;
                            case '*':list.add(a * b);break;
                        }
                    }
                }
            }
            
        }
        if(list.size()==0)
            list.add(Integer.parseInt(input));
        return list;
    }
}