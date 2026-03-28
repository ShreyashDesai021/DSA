import java.util.*;

public class Recur{

    static final int INT_MIN_VAL = -2147483648;
    static final int INT_MAX_VAL = 2147483647;

    public static int helper(String s,int i, long num, int sign){
        if(i >= s.length() || !Character.isDigit(s.charAt(i))){
            return (int)(sign * num);
        }

        num = num * 10 + (s.charAt(i) - '0');

        if(sign * num <= INT_MIN_VAL) return INT_MIN_VAL;
        if(sign * num >= INT_MAX_VAL) return INT_MAX_VAL;

        return helper(s,i+1,num,sign);
    } 

    public static int atoi(String s){ // ASCII TO INT
        int i = 0;

        //skiping whitespaces
        while(i < s.length() && s.charAt(i) == ' ') i++;

        int sign = 1;
        if(i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-' )){
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        return helper(s,i,0,sign);
        
    }

    public static double myPowBrute(double x, int n) {
        // Base case: any number to the power of 0 is 1
        if (n == 0 || x == 1.0) return 1; 
        
        long temp = n; // to avoid integer overflow
        
        // Handle negative exponents
        if (n < 0) {
            x = 1 / x;
            temp = -1L * n;
        }

        double ans = 1;

        for (long i = 0; i < temp; i++) {
            // Multiply ans by x for n times
            ans *= x; 
        }
        return ans;
    }

    private static double power(double x, long n){

        if(n == 0) return 1.0;

        double half = power(x, n/2);

        if(n % 2 == 0){
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static double myPowOptimal(double x,int n){
        if(n < 0){
            return 1.0 / power(x,-n);
        }

        return power(x,n);
    }

    static final int MOD = 1_000_000_007;
    
    // Recursive function to count good numbers
    // public static int countGoodNumbers(int index, int n) { // DO IT LATER
    //     // Base case
    //     if (index == n) {  
    //         return 1;
    //     }
        
    //     int result = 0;
    //     // Even index
    //     if (index % 2 == 0) {  
    //         int[] evenDigits = {0, 2, 4, 6, 8};
    //         for (int digit : evenDigits) {
    //             result = (result + countGoodNumbers(index + 1, n)) % MOD;
    //         }
    //     } 
    //     // Odd index
    //     else {  
    //         int[] primeDigits = {2, 3, 5, 7};
    //         for (int digit : primeDigits) {
    //             result = (result + countGoodNumbers(index + 1, n)) % MOD;
    //         }
    //     }
    //     return result;
    // }

    //I-B-H
    public static void print1toN(int N){

        if(N <= 0){
            return ;
        }

        print1toN(N-1);

        System.out.println(N);

    }

        // Function to sort array
    public static void sortRecursive(int[] arr, int n) {
        // Base case
        if (n <= 1)
            return;

        // Sort first n-1 elements
        sortRecursive(arr, n - 1);

        // Insert last element in sorted array
        insertRecursive(arr, n - 1);
    }

    // Recursive function to insert element at correct position
    private static void insertRecursive(int[] arr, int i) {
        // Base case or correct position found
        if (i == 0 || arr[i] >= arr[i - 1])
            return;

        // Swap
        int temp = arr[i];
        arr[i] = arr[i - 1];
        arr[i - 1] = temp;

        // Recur for previous index
        insertRecursive(arr, i - 1);
    }

    public static void sortRecur(ArrayList<Integer> list){

        // Base case
        if (list.size() <= 1)
            return;

        // Remove last element
        int temp = list.remove(list.size() - 1);

        // Sort remaining list
        sortRecur(list);

        // Insert element at correct position
        insertRecur(list, temp);

    }

    private static void insertRecur(ArrayList<Integer> list,int temp){
        if(list.size() == 0 || list.get(list.size() - 1) <= temp){ // check if size of list ==0 or if last element insert is smaller than temp element if yes insert temp at last
            list.add(temp);
            return;
        }

        // now if last element is not smaller than the temp we will remove it temporarily and check if second last is smaller than temp and go on recursively

        int val = list.remove(list.size() - 1);

        insertRecur(list,temp); // try inserting temp at last position

        list.add(val);

    }

    public static void sortStackRecur(Stack<Integer> st){
        if(st.size() <= 1){
            return;
        }

        int temp = st.pop();

        sortStackRecur(st);

        insertStackRecur(st,temp);
    }

    private static void insertStackRecur(Stack<Integer> st,int temp){
        
        if(st.isEmpty() || st.peek() <= temp){
            st.push(temp);
            return;
        }

        int val = st.pop();

        insertStackRecur(st,temp);

        st.push(val);

    }

    public static void deleteMiddleOfStackRecur(Stack<Integer> st, int k) {
        // Base case: middle reached
        if (k == 1) { // If k is 1, we are at the middle element
            st.pop();
            return;
        }

        // Remove top element
        int temp = st.pop(); // Store it temporarily

        // Recursive call
        deleteMiddleOfStackRecur(st, k - 1); // Move towards the middle

        // Push back element
        st.push(temp); // Restore the stack
    } 

    public static void reverseStackRecur(Stack<Integer> st){ // Must use O(1) space

        if (st.isEmpty()){
            return;
        }

        int temp = st.pop();

        reverseStackRecur(st);

        insertAtBottomRecur(st, temp);
    }   

    private static void insertAtBottomRecur(Stack<Integer> st,int temp){
        if (st.isEmpty()) {
            st.push(temp);
            return;
        }

        int val = st.pop();

        insertAtBottomRecur(st, temp);

        st.push(val);
    }

    public static int kthSymbolinGrammar(int n, int k){

        if(n == 1 && k == 1){ // given base cond in statement
            return 0;
        }

        int mid = (int) Math.pow(2,n-1)/2;  // length/2 => 2^(n-1)/2 , [since : length = 2^(n-1)]

        if(k <= mid){
            return kthSymbolinGrammar(n-1, k);
        }else{
            return 1 - kthSymbolinGrammar(n-1, k - mid); // ( 1 - _) becoz we want its complement 
        }

    }

    //tower of hanoi
    static int count = 0;

    public static void toh(int n, char src, char dest, char aux) {

        if (n == 1) {
            count++;
            System.out.println("Move disk 1 from " + src + " to " + dest);
            return;
        }

        toh(n - 1, src, aux, dest);

        count++;
        System.out.println("Move disk " + n + " from " + src + " to " + dest);

        toh(n - 1, aux, dest, src);
    }

    


    //ip-op method:
    static int subsequence_count = 0;

    public static void subsequence(String ip, String op){

        if(ip.length() == 0){
            subsequence_count++;
            System.out.println(op);
            return;
        }

        String op1 = op;   //exclude case 
        String op2 = op + ip.charAt(0); // include case

        String newIp = ip.substring(1);

  
        subsequence(newIp,op1); // to left bracnch
        subsequence(newIp,op2); // to right branch

    }

    static int unique_subsequence_count = 0;

    // we are using hashset , we can also use set directly to remove duplicates
    static Set<String> unique_subsequence_set = new HashSet<>();

    public static void unique_subsequence(String ip, String op) {

        // Base case
        if (ip.length() == 0) {
            if (!unique_subsequence_set.contains(op)) {
                System.out.println(op);
                unique_subsequence_set.add(op);
                unique_subsequence_count++;
            }
            return;
        }

        // Exclude
        unique_subsequence(ip.substring(1), op);

        // Include
        unique_subsequence(ip.substring(1), op + ip.charAt(0));
    }

    public static void permutations_w_spaces(String ip,String op){

        if(ip.length() == 0){
            System.out.println(op);
            return;
        }

        char first_letter_of_op = ip.charAt(0);

        String op1 = op + " " + first_letter_of_op; // include next char with space
        String op2 = op + Character.toString(first_letter_of_op);

        String newIp = ip.substring(1);

        permutations_w_spaces(newIp, op1);
        permutations_w_spaces(newIp, op2);

    }

    public static void permutations_w_caseChange(String ip,String op){
        if(ip.length() == 0){
            System.out.println(op);
            return;
        }

        String op1 = op + Character.toString(ip.charAt(0)).toLowerCase();  // without capitalize
        String op2 = op + Character.toString(ip.charAt(0)).toUpperCase() ;  // with capitalize

        String newIp = ip.substring(1);

        permutations_w_caseChange(newIp, op1);
        permutations_w_caseChange(newIp, op2);

    }

    public static void permutations_w_caseChange_withNumbers(String ip, String op) {

        if (ip.length() == 0) {
            System.out.println(op);
            return;
        }

        char ch = ip.charAt(0);

        // If character is a letter
        if (Character.isLetter(ch)) {

            // Lowercase branch
            permutations_w_caseChange_withNumbers(ip.substring(1), op + Character.toLowerCase(ch));

            // Uppercase branch
            permutations_w_caseChange_withNumbers(ip.substring(1), op + Character.toUpperCase(ch));

        } else {
            // If digit or special char → only one choice
            permutations_w_caseChange_withNumbers(ip.substring(1), op + ch);
        }
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        solvePar(n, n, "", res);
        return res;
    }

    private static void solvePar(int open,int close,String op,ArrayList<String> res){
        //Base case
        if(open == 0 && close == 0){
            res.add(op);
            return;
        }

        if(open > 0){ // because we always have chose of "(" , until open > 0
            solvePar(open-1,close,op + "(",res);
        }

        if(open < close){ // we can only choose ")" if we have more ")" left than "(" because we can't have more ")" than "(" in a valid parentheses string
            solvePar(open,close-1,op + ")",res);
        }
    }

    public static List<String> nBitBinary1GreaterThan0Prefix(int n) {
        ArrayList<String> res = new ArrayList<>();
        solve10(0, 0, n,"", res);
        return res;
    }

    private static void solve10(int ones,int zeros,int n,String op,ArrayList<String> res){
        //Base case
        if(n == 0){
            res.add(op);
            return;
        }

        solve10(ones+1,zeros,n-1,op + "1" , res); // always correct hence no if required     

        if(ones > zeros){
            solve10(ones,zeros+1,n-1,op + "0",res);
        }


    }


    public static void main(String[] args){
        String s = "   -12345";
        //System.out.println(atoi(s));

        //System.out.println(myPowOptimal(2,5));

        //print1toN(7);

        int[] arr = new int[]{5, 2, 9, 1, 5, 6};
        //sortRecursive(arr, 6);
        //System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 9, 1, 3));

        //sortRecur(list);

        //System.out.println(list);
    
        Stack<Integer> st = new Stack<>();
        while(!list.isEmpty()) {
            st.push(list.remove(0));
        }
        //st.addAll(list); // we can also do this but it will add all the elements in the same order as list 

        //sortStackRecur(st);
        //System.out.println(st);

        //int k = st.size() / 2 + 1; // Calculate the position of the middle element (1-based index)
        //deleteMiddleOfStackRecur(st, k);
        //System.out.println(st);

        //reverseStackRecur(st);
        //System.out.println(st);

        //System.out.println(kthSymbolinGrammar(4,3));

        // int n = 3;
        // toh(n, 'A', 'C', 'B');
        // System.out.println("Total moves: " + count); // 2^n - 1

        // subsequence("abc","");
        // System.out.println(subsequence_count);

        //unique_subsequence("aab","");
        //System.out.println(unique_subsequence_count);

        // String str = "ABC";

        // // First character is always included
        // String op = "" + str.charAt(0);
        // String ip = str.substring(1);

        // permutations_w_spaces(ip, op);

        // permutations_w_caseChange("aB", "");

        //permutations_w_caseChange_withNumbers("a1b2", "");

        int n = 3;

        List<String> result = nBitBinary1GreaterThan0Prefix(n);

        for (String i : result) {
            System.out.println(i);
        }

    }
}