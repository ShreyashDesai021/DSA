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
    }
}