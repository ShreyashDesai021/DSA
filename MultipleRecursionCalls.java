public class MultipleRecursionCalls { // TC = O(2^n) , SC = O(n) due to recursive stack space
                                             // Exponential time complexity because each function call 
                                             // results in two more calls
    
    public static int fibonacci(int n){
        if(n < 0){
            System.out.println("Please enter valid number");
            return -1;
        }
        
        if(n == 0){
            return 0;
        }
        
        if(n == 1){
            return 1;
        }
        
        return fibonacci(n-1) + fibonacci(n-2);

    }

    public static void main(String[] args) {
        int n = 5;        
        System.out.println(fibonacci(n));
        
    }
}