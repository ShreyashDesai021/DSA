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

    public static void main(String[] args) {
        //String s = "()[{}()]";
        String s = "()[{}(])";

        System.out.println(balancedPara(s));

    }
}