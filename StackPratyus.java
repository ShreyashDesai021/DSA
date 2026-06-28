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

    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0;i < arr.length;i++){
            
            while(!st.isEmpty() && st.peek() >= arr[i]){
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

    public static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        
        ArrayList<Integer> list = new ArrayList<>();
        
        
        for(int i = arr.length - 1;i >= 0;i--){
            
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            
            if(st.isEmpty()){
                list.add(-1);
            }else{
                list.add(st.peek());
            }
            
            st.push(arr[i]);
        }
        
        Collections.reverse(list);
        return list;
    }

    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        
        ArrayList<Integer> list = new ArrayList<>();
        
        
        for(int i = arr.length - 1;i >= 0;i--){
            
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            
            if(st.isEmpty()){
                list.add(-1);
            }else{
                list.add(st.peek());
            }
            
            st.push(arr[i]);
        }
        
        Collections.reverse(list);
        return list;
    }


    public static int[] nextGreaterElementsCir(int[] nums) {
        Deque<Integer> st = new ArrayDeque<Integer>();

        int[] arr = new int[nums.length];

        for(int i = nums.length - 1;i >= 0;i--){
            st.push(nums[i]);
        }

        for(int i = nums.length-1;i >= 0;i--){

            while(!st.isEmpty() && nums[i] >= st.peek()){
                st.pop();
            }

            if(st.isEmpty()){
                arr[i] = -1;
            }else{
                arr[i] = st.peek();
            }

            st.push(nums[i]);

        }

        return arr;

    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 4};
        ArrayList<Integer> result = preGreaterEle(arr);
        System.out.println(result); // Output: [-1, -1, 3, -1]

        ArrayList<Integer> result2 = prevSmaller(arr);
        System.out.println(result2); // Output: [-1, 1, 1, 2]

        ArrayList<Integer> result3 = nextSmallerEle(arr);
        System.out.println(result3); // Output: [-1, 2, -1, -1]

        ArrayList<Integer> result4 = nextLargerElement(arr);
        System.out.println(result4); // Output: [3, 4, 4, -1]

        int[] result5 = nextGreaterElementsCir(arr);
        System.out.println(Arrays.toString(result5)); // Output: [3, 4, 4, -1]
    }
}