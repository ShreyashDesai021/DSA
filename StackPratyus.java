import java.util.*;

class StackPratyus {
    public static ArrayList<Integer> preGreaterEle(int[] arr) {
        // code here
        java.util.Stack<Integer> st = new java.util.Stack<>();
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0;i < arr.length;i++){
            
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                list.add(-1);
            }else{
                list.add(st.peek());
            }
            
            st.push(arr[i]);
        }
        
        
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 4};
        ArrayList<Integer> result = preGreaterEle(arr);
        System.out.println(result); // Output: [-1, -1, 3, -1]
    }
}