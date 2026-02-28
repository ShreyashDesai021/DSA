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
    //     // Array to store queue elements
    // int[] arr;
    // // Indices for start and end of the queue
    // int start, end;
    // // Current size and maximum size of the queue
    // int currSize, maxSize;

    // // Constructor
    // public QueueArray() {
    //     arr = new int[10];
    //     start = -1;
    //     end = -1;
    //     currSize = 0;
    //     maxSize = 10;
    // }

    // // Method to push an element into the queue
    // public void push(int x) {
    //     // Check if the queue is full
    //     if (currSize == maxSize) {
    //         System.out.println("Queue is full\nExiting...");
    //         System.exit(1);
    //     }

    //     // If the queue is empty, initialize start and end
    //     if (end == -1) {
    //         start = 0;
    //         end = 0;
    //     } 
    //     else {
    //         // Circular increment of end
    //         end = (end + 1) % maxSize;
    //     }

    //     arr[end] = x;
    //     currSize++;
    // }

    // // Method to pop an element from the queue
    // public int pop() {
    //     // Check if the queue is empty
    //     if (start == -1) {
    //         System.out.println("Queue Empty\nExiting...");
    //         System.exit(1);
    //     }
    //     int popped = arr[start];

    //     // If the queue has only one element, reset start and end
    //     if (currSize == 1) {
    //         start = -1;
    //         end = -1;
    //     } 
    //     else {
    //         // Circular increment of start
    //         start = (start + 1) % maxSize;
    //     }

    //     currSize--;
    //     return popped;
    // }

    // // Method to get the front element of the queue
    // public int peek() {
    //     // Check if the queue is empty
    //     if (start == -1) {
    //         System.out.println("Queue is Empty");
    //         System.exit(1);
    //     }
    //     return arr[start];
    // }

    // // Method to determine whether the queue is empty
    // public boolean isEmpty() {
    //     return (currSize == 0);
    // }


    int[] arr;

    int start,end;

    int currSize, maxSize;

    public QueueArray(){
        arr = new int[10];
        start = -1;
        end = -1;
        currSize = 0;
        maxSize = 10;
    }

    public boolean isEmpty() {
        return (currSize == 0);
    }

    public boolean isFull(){
        return (currSize == maxSize);
    }

    public void push(int x){

        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }

        if(isEmpty()){
            start = 0;
            end = 0;
        }

        else {
            end = (end + 1) % maxSize;
        }

        arr[end] = x;
        currSize++;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }

        int popped = arr[start];

        if(currSize == 1){
            start = -1;
            end = -1;
        }
        else{
            start = (start + 1) % maxSize;
        }

        currSize--;
        return popped;

    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[start];
    }

}

class Node{
    int val;
    Node next;
    public Node(int data){
        val = data;
        next = null;
    }
}


class StackLL{
    private Node head;
    private int size;

    public StackLL(){
        head = null;
        size = 0;
    }

    public void push(int x){
        Node element = new Node(x);

        element.next = head;
        head = element;

        size++;
    }

    public int pop(){
        if(head == null){
            System.out.println("Stack is Empty");
            return -1;
        }

        int value = head.val;
        Node temp = head;
        head = head.next;
        temp = null;
        size--;

        return value;
    }

    public int top(){
        if(head == null){
            System.out.println("Stack is Empty");
            return -1;
        }

        return head.val;
    }

    public boolean isEmpty(){
        return (size == 0);
    }
}

class QueueLL{
    private Node start;
    private Node end;
    private int size;

    public QueueLL(){
        start = end = null;
        size = 0;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void push(int x){
        Node element = new Node(x);

        if(isEmpty()){
            start = end = element;
        }else{
            end.next = element;
            end = element;
        }

        size++;

    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }

        int value = start.val;
        Node temp = start;
        start = start.next;
        temp = null;
        size--;

        return value;

    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }

        return start.val;
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

        // 5. Test Overflow 
        q.push(120); // Uncomment to test Overflow crash

        System.out.println("Queue size: " + q.currSize);
        
        // 6. Empty the queue
        System.out.print("Emptying queue: ");
        while(!q.isEmpty()) {
            System.out.print(q.pop() + " ");
        }

        StackLL stack2 = new StackLL();

        // 1. PUSH elements
        System.out.println("\nPushing: 10, 20, 30");
        stack2.push(10);
        stack2.push(20);
        stack2.push(30);

        // 2. TOP (Peek)
        System.out.println("Current Top: " + stack2.top()); // Should be 30

        // 3. POP elements
        System.out.println("Popped: " + stack2.pop()); // Removes 30
        System.out.println("New Top: " + stack2.top()); // Should be 20

        // 4. Check if Empty
        System.out.println("Is stack empty? " + stack2.isEmpty());

        // 5. Empty the stack
        stack2.pop(); // Removes 20
        stack2.pop(); // Removes 10

        // 6. Test Underflow
        System.out.print("Testing pop on empty stack: ");
        stack2.pop(); // Should print "Stack is Empty"

        QueueLL queue = new QueueLL();

        // 1. PUSH (Enqueue)
        System.out.println("Pushing: 10, 20, 30");
        queue.push(10);
        queue.push(20);
        queue.push(30);

        // 2. PEEK (Front of the line)
        System.out.println("Front element (peek): " + queue.peek()); // Should be 10

        // 3. POP (Dequeue)
        System.out.println("Popped: " + queue.pop()); // Removes 10
        System.out.println("New Front: " + queue.peek()); // Should be 20

        // 4. Check Size and Empty status
        System.out.println("Is queue empty? " + queue.isEmpty());

        // 5. Emptying the queue to test nulling start/end
        queue.pop(); // Removes 20
        queue.pop(); // Removes 30

        // 6. Test Underflow
        System.out.print("Testing pop on empty queue: ");
        queue.pop(); // Should print "Queue is Empty"
        
    }
}