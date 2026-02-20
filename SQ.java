import java.util.*;

class ArrayStack {
    private int[] stackArray;
    private int capacity;
    private int topIndex;

    public ArrayStack() {
        capacity = 1000;
        stackArray = new int[capacity];
        topIndex = -1;
    }

    public void push(int x) {
        if (topIndex == capacity - 1) {
            System.out.println("Stack overflow");
            return;
        }
        stackArray[++topIndex] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[topIndex--];
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[topIndex];
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }
}

// Implementation of Circular Queue using Arrays
class ArrayQueue {
    private int[] arr;
    private int start, end;
    private int currSize, maxSize;

    public ArrayQueue() {
        maxSize = 10;
        arr = new int[maxSize];
        start = -1;
        end = -1;
        currSize = 0;
    }

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

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[start];
    }

    public boolean isEmpty() {
        return currSize == 0;
    }
}

// Stack implementation using Queue
class QueueStack {
    // Queue
    Queue<Integer> q = new LinkedList<>();

    // Method to push element in the stack
    public void push(int x) {
        // Get size
        int s = q.size();
        // Add element
        q.add(x);

        // Move elements before new element to back
        for (int i = 0; i < s; i++) {
            q.add(q.poll());
        }
    }

    // Method to pop element from stack
    public int pop() {
        // Get front element
        int n = q.peek();
        // Remove front element
        q.poll();
        // Return removed element
        return n;
    }

    // Method to return the top of stack
    public int top() {
        // Return front element
        return q.peek();
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return q.isEmpty();
    }
}

public class SQ {
    public static void main(String[] args) {
        // --- Stack Operations ---
        System.out.println("--- Stack Testing ---");
        ArrayStack stack = new ArrayStack();
        stack.push(5);
        stack.push(10);

        System.out.println("Top element: " + stack.top());    // 10
        System.out.println("Popped: " + stack.pop());         // 10
        System.out.println("Top element: " + stack.top());    // 5
        System.out.println("Is empty? " + stack.isEmpty());   // false
        stack.pop();
        System.out.println("Is empty? " + stack.isEmpty());   // true

        System.out.println("\n--- Queue Testing ---");
        // --- Queue Operations ---
        ArrayQueue queue = new ArrayQueue();
        queue.push(5);
        queue.push(10);

        System.out.println("Front element: " + queue.peek()); // 5
        System.out.println("Popped: " + queue.pop());        // 5
        System.out.println("Front element: " + queue.peek()); // 10
        System.out.println("Is empty? " + queue.isEmpty());  // false
        queue.pop();
        System.out.println("Is empty? " + queue.isEmpty());  // true

        QueueStack st = new QueueStack();
        
        // Array of commands
        String[] commands = {"QueueStack", "push", "push", 
                             "pop", "top", "isEmpty"};
        int[][] inputs = {{}, {4}, {8}, {}, {}, {}};

        for (int i = 0; i < commands.length; ++i) {
            switch (commands[i]) {
                case "push":
                    st.push(inputs[i][0]);
                    System.out.print("null ");
                    break;
                case "pop":
                    System.out.print(st.pop() + " ");
                    break;
                case "top":
                    System.out.print(st.top() + " ");
                    break;
                case "isEmpty":
                    System.out.print(st.isEmpty() ? "true " : "false ");
                    break;
                case "QueueStack":
                    System.out.print("null ");
                    break;

    }
    }
}
}