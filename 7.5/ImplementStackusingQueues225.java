class MyStack {
    LinkedList<Integer> stack;
    // Push element x onto stack.
    MyStack()
    {
        stack = new LinkedList<>();
    }

    // Removes the element on top of the stack.
    public void pop() {
        stack.pollFirst();
    }

    // Get the top element.
    public int top() {
        return stack.peekFirst();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return stack.size() == 0;
    }
}