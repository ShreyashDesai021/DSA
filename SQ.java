class StackArray{
    int[] arr;
    int capacity;
    int top;

    StackArray(int size){
        capacity = size;
        arr = new int[capacity];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == capacity - 1;
    }

    public void push(int x){
        if(isFull()){
            System.out.println("StackOverflow");
            return;
        }
        arr[++top] = x;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top--];
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top];
    }

    public void display(){
        for(int i = top; i >= 0; i--){   
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class QueueArray{
        // Array to store queue elements
    int[] arr;
    // Indices for start and end of the queue
    int start, end;
    // Current size and maximum size of the queue
    int currSize, maxSize;

    // Constructor
    public QueueArray() {
        arr = new int[10];
        start = -1;
        end = -1;
        currSize = 0;
        maxSize = 10;
    }

    // Method to push an element into the queue
    public void push(int x) {
        // Check if the queue is full
        if (currSize == maxSize) {
            System.out.println("Queue is full\nExiting...");
            System.exit(1);
        }

        // If the queue is empty, initialize start and end
        if (end == -1) {
            start = 0;
            end = 0;
        } 
        else {
            // Circular increment of end
            end = (end + 1) % maxSize;
        }

        arr[end] = x;
        currSize++;
    }

    // Method to pop an element from the queue
    public int pop() {
        // Check if the queue is empty
        if (start == -1) {
            System.out.println("Queue Empty\nExiting...");
            System.exit(1);
        }
        int popped = arr[start];

        // If the queue has only one element, reset start and end
        if (currSize == 1) {
            start = -1;
            end = -1;
        } 
        else {
            // Circular increment of start
            start = (start + 1) % maxSize;
        }

        currSize--;
        return popped;
    }

    // Method to get the front element of the queue
    public int peek() {
        // Check if the queue is empty
        if (start == -1) {
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        return arr[start];
    }

    // Method to determine whether the queue is empty
    public boolean isEmpty() {
        return (currSize == 0);
    }
}

public class SQ {

    public static void main(String[] args) {

        // create stack of size 5
        StackArray stack = new StackArray(5);

        // PUSH operations
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.print("Stack after pushes: ");
        stack.display();

        // PEEK
        System.out.println("Top element (peek): " + stack.peek());

        // POP
        System.out.println("Popped element: " + stack.pop());

        System.out.print("Stack after pop: ");
        stack.display();

        // Edge case testing
        stack.pop();
        stack.pop();
        stack.pop();   // underflow case

        // Overflow testing
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90); // overflow case

        QueueArray q = new QueueArray();

        // 1. ENQUEUE (Push) operations
        System.out.println("Pushing elements: 10, 20, 30");
        q.push(10);
        q.push(20);
        q.push(30);

        // 2. PEEK
        System.out.println("Front element (peek): " + q.peek());

        // 3. DEQUEUE (Pop) - Should be 10 (FIFO)
        System.out.println("Popped element: " + q.pop());
        System.out.println("New front element after pop: " + q.peek());

        // 4. Fill the queue to test Circular Logic
        System.out.println("\nFilling the queue to capacity...");
        q.push(40);
        q.push(50);
        q.push(60);
        q.push(70);
        q.push(80);
        q.push(90);
        q.push(100);
        q.push(110); // Queue should be full now (Size 10)

        // 5. Test Overflow (Triggering the System.exit)
        // q.push(120); // Uncomment to test Overflow crash

        System.out.println("Queue size: " + q.currSize);
        
        // 6. Empty the queue
        System.out.print("Emptying queue: ");
        while(!q.isEmpty()) {
            System.out.print(q.pop() + " ");
        }
        
    }
}