
package Project.Stack.MyStack;

public class MyStack {
    private final int dimension;
    private int[] stack;
    private int top = -1;

    public MyStack(int dimension){
        if(dimension <= 0){
            throw new IllegalArgumentException("Invalid dimension");
        }

        this.dimension = dimension;
        stack = new int[dimension];
    }

    public int getDimension() {
        return dimension;
    }


    public void push(int value) {

        if (top == stack.length - 1) {
            throw new IllegalStateException("Full Stack");
        }

        top++;
        stack[top] = value;
    }

    public int pop() {

        if (top == -1) {
            throw new IllegalStateException("Empty Stack");
        }

        int removed = stack[top];
        top--;

        return removed;
    }

    public int peek() {

        if (top == -1) {
            throw new IllegalStateException("Empty Stack");
        }

        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

}
