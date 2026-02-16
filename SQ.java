class ArrayStack {
    private int[] stackArray;
    private int capacity;
    private int topIndex;

    // Constructor
    public ArrayStack() {
        capacity = 1000;
        stackArray = new int[capacity];
        topIndex = -1;
    }

    // Push element
    public void push(int x) {
        if (topIndex == capacity - 1) {
            System.out.println("Stack overflow");
            return;
        }
        stackArray[++topIndex] = x;
    }

    // Pop element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[topIndex--];
    }

    // Peek top element
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[topIndex];
    }

    // Check empty
    public boolean isEmpty() {
        return topIndex == -1;
    }
}

public class SQ {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();

        stack.push(5);
        stack.push(10);

        System.out.println(stack.top());     // 10
        System.out.println(stack.pop());     // 10
        System.out.println(stack.top());     // 5
        System.out.println(stack.isEmpty()); // false

        stack.pop();
        System.out.println(stack.isEmpty()); // true
    }
}
