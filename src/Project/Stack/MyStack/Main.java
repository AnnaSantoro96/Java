package Project.Stack.MyStack;

public class Main {
    static void main() {
        MyStack stack = new MyStack(10);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        stack.push(40);
        IO.println(stack.peek());
        IO.println(stack.size());
    }
}
