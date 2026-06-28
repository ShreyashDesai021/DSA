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

    //Q. Remove duplicate characters in a string if they appear k times consecutively

    static class Pair{
    char ch;
    int count;

    Pair(char ch,int count){
        this.ch = ch;
        this.count = count;
    }
    }
    
    public static String removeDuplicates(String s, int k) {
        
        Stack<Pair> st = new Stack<>();

        for(int i = 0;i < s.length();i++){

            char c = s.charAt(i);

            if(!st.isEmpty() && st.peek().ch == c){
                st.peek().count++;

                if(st.peek().count == k){
                    st.pop();
                }
            }else{
                st.push(new Pair(c,1));
            }
        }

        StringBuilder ans = new StringBuilder();

        for(int i = 0;i < st.size();i++){

            Pair p = st.get(i);

            for(int j = 0;j < p.count;j++){
                ans.append(p.ch);
            }

        }

        // No need to reverse the string because we are accessing the stack
        // from bottom to top using get(i), not removing elements using pop().

        return ans.toString();

    }



//Interesting see this:
//         StringBuilder ans = new StringBuilder();

//         for (int i = 0; i < st.size(); i++) {

//             Pair p = st.get(i);

//             for (int j = 0; j < p.count; j++) {
//                 ans.append(p.ch);
//             }
//         }

//         return ans.toString();
//     }


// in this are we travesing a stack?

// Yes. You are traversing the stack, but not using stack operations (pop()/peek()). You're traversing it like a normal list because Stack extends Vector.

// When you write:

// for (int i = 0; i < st.size(); i++) {
//     Pair p = st.get(i);
//     ...
// }

// you're accessing elements by index.

// For example, if the stack contains:

// Bottom
// (a,2)
// (b,1)
// (c,3)
// Top

// Then:

// st.get(0)   // (a,2)
// st.get(1)   // (b,1)
// st.get(2)   // (c,3)

// So the loop visits:

// (a,2) → (b,1) → (c,3)

// which is exactly the order you want to reconstruct the string.

// If you used pop() instead
// while (!st.isEmpty()) {
//     Pair p = st.pop();
// }

// it would visit:

// (c,3) → (b,1) → (a,2)

// because a stack is LIFO (Last In, First Out). You would then need to reverse the result.

// Why does get(i) work?

// Because Stack is defined as:

// class Stack<E> extends Vector<E>

// and Vector provides methods like:

// get(index)
// size()

// So although Stack is conceptually a stack, Java also lets you access its elements like an array.

// Interview note

// In interviews, if someone asks, "Are you traversing the stack?", the answer is:

// Yes. I'm iterating over the underlying Vector using indexing, not using stack operations like pop().

// This works because Java's Stack class extends Vector. However, with Deque (the preferred modern stack implementation), you don't have get(i), so you would typically use an iterator or another approach to build the result.

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

        String s = "deeedbbcccbdaa";
        int k = 3;
        String result6 = removeDuplicates(s, k);
        System.out.println(result6); // Output: "aa"
    }
}

