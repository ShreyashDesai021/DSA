import java.util.*;

public class SQ2{

    public static boolean balancedPara(String s){ // T = O(n) , S = O(n) for stack
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                st.push(s.charAt(i));  
            }
            else{
                if(st.isEmpty()) return false;

                char top = st.pop();

                if((s.charAt(i) == ')' && top == '(') ||
                   (s.charAt(i) == ']' && top == '[') ||
                   (s.charAt(i) == '}' && top == '{'))
                continue;
                else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    
    public static int[] nextGreaterEleStack(int[] arr){
        Stack<Integer> st = new Stack<>();

        int[] res = new int[arr.length];    

        for(int i = arr.length - 1;i >= 0;i--){

            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }

            /*
            if(st.peek() > arr[i]){
                res[i] = st.peek();
            }else{
                res[i] = -1;
            }
            */         // wrong becoz if stack is empty → peek() throws exception

            if(st.isEmpty()){
                res[i] =-1;
            }else{
                res[i] = st.peek();
            }

            st.push(arr[i]);
            
        }

        return res;

    }
    // Function to find next smaller element using stack
    public static int[] nextSmallerElement(int[] arr) {
        int n = arr.length;

        // Stack to keep potential next smaller elements
        Stack<Integer> st = new Stack<>();

        // Initialize result array with -1
        int[] ans = new int[n];
        Arrays.fill(ans, -1); // we can do if,else also as previous

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Pop elements from stack that are not smaller
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            // If stack not empty, top is the next smaller element
            if (!st.isEmpty()) {
                ans[i] = st.peek();
            }

            // Push current element to stack
            st.push(arr[i]);
        }

        // Return result
        return ans;
    }


    public static int trapPrefix(int[] height) { // T = O(3n) , S = O(2n) for prefix and suffix arrays
        int n = height.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = height[0];
        for(int i = 1; i < n; i++)
            prefix[i] = Math.max(prefix[i-1], height[i]);

        suffix[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--)
            suffix[i] = Math.max(suffix[i+1], height[i]);

        int water = 0;

        for(int i = 0; i < n; i++)
            water += Math.min(prefix[i], suffix[i]) - height[i];

        return water;
    }

    //two pointer approach for trapping rain water T = O(n) , S = O(1) is more effiecient will do it later
    public static int priority(char c){
        if(c == '^'){ 
            return 3;
        }
        else if(c == '/' || c == '*'){ 
            return 2;
        }
        else if(c == '+' || c == '-'){
            return 1;
        }else {
            return -1;
        }
    }

    public static String infixToPostfix(String s){

        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            // operand
            if(Character.isLetterOrDigit(c)){
                ans.append(c);
            }

            else if(c == '('){
                st.push(c);
            }

            else if(c == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    ans.append(st.pop());
                }
                st.pop(); // remove '('
            }

            else { // operator

                while(!st.isEmpty() && priority(c) <= priority(st.peek())){
                    ans.append(st.pop());
                }
                st.push(c);
            }
        }

        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        //String s = "()[{}()]";
        //String s = "()[{}(])";

        //System.out.println(balancedPara(s));

       // int[] arr = {1,3,2,4};

        //int[] res = nextGreaterEleStack(arr);

        //int[] res = nextSmallerElement(arr);

        //for(int i = 0; i < res.length;i++){
        //    System.out.print(res[i] + " ");
        //}

        //System.out.println("");

        int[] height = {4,2,0,3,2,5};

        //System.out.println(trapPrefix(height));

        String s = "a+b*(c^d-e)";

        String str = infixToPostfix(s);

        System.out.println(str);

    }
}