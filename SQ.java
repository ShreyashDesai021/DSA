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

class ArrayQueue {
    int[] arr;
    int start, end;
    int currSize, maxSize;

    // Constructor
    public ArrayQueue() {
        maxSize = 10;
        arr = new int[maxSize];
        start = -1;
        end = -1;
        currSize = 0;
    }

    // Enqueue
    public void push(int x) {
        if (currSize == maxSize) {
            System.out.println("Queue is full");
            return;
        }

        if (start == -1) {
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % maxSize;
        }

        arr[end] = x;
        currSize++;
    }

    // Dequeue
    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int value = arr[start];

        if (currSize == 1) {
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % maxSize;
        }

        currSize--;
        return value;
    }

    // Front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[start];
    }

    // Empty check
    public boolean isEmpty() {
        return currSize == 0;
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

        ArrayQueue queue = new ArrayQueue();

        queue.push(5);
        queue.push(10);

        System.out.println(queue.peek());     // 5
        System.out.println(queue.pop());      // 5
        System.out.println(queue.peek());     // 10
        System.out.println(queue.isEmpty());  // false

        queue.pop();
        System.out.println(queue.isEmpty());  // true
    }
}
