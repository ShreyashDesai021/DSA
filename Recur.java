
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


    

    public static void main(String[] args){
        String s = "   -12345";
        System.out.println(atoi(s));

        System.out.println(myPowOptimal(2,5));

        print1toN(7);
    }
}