import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int element) {
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack2.push(element);
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        return stack2.pop();
    }

    public int top() {
        return stack2.peek();
    }
}
