import java.util.*;
class MyQueue {
	public static void main(String[] args )
	{
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		sop(list.getFirst());
		sop(list.getLast());
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        output.pop();
    }

    // Get the front element.
    public int peek() {
        if(!output.empty())
            return output.peek();
        while(!input.empty())
        {
            output.push(input.pop());
        }
        return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return input.empty()&&output.empty();
    }
}
   /*  LinkedList<Integer> stack = new LinkedList<>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack.addFirst(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pollLast();
    }

    // Get the front element.
    public int peek() {
        return stack.peekLast();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.size() == 0;
    } */
}