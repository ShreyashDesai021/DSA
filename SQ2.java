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


    public static void main(String[] args) {
        //String s = "()[{}()]";
        //String s = "()[{}(])";

        //System.out.println(balancedPara(s));

        int[] arr = {1,3,2,4};

        int[] res = nextGreaterEleStack(arr);

        for(int i = 0; i < res.length;i++){
            System.out.print(res[i] + " ");
        }

        System.out.println("");

    }
}