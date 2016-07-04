public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++)
        {
            if(tokens[i].length() == 1)
            {
                switch (tokens[i].charAt(0))
                {
                    case '+': calculate(stack,'+');break;
                    case '-': calculate(stack,'-');break;
                    case '*': calculate(stack,'*');break;
                    case '/': calculate(stack,'/');break;
                    default: stack.push(Integer.parseInt(tokens[i]));
                }
            }
            else
                stack.push(Integer.parseInt(tokens[i]));
            
        }
        return stack.pop();
    }
    public void calculate(Stack<Integer> stack, char op)
    {
        switch (op)
        {
            case '+': stack.push(stack.pop()+stack.pop());break;
            case '-': { int subtractor = stack.pop();
            stack.push(stack.pop() - subtractor);}break;
            case '*': stack.push(stack.pop()*stack.pop());break;
            case '/': { int divisor = stack.pop();
            stack.push(stack.pop()/divisor);}break;
        }
    }
}