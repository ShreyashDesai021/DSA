public class ParameterisedandFunctionalRecursion{

    // Parameterised Recursion: A function where we pass extra parameter to keep track of result so far
    public static void parameterisedSum(int i,int sum){
        if(i < 1){ 
            System.out.println(sum); // print the sum when base case is reached
            return;
        }
        
        parameterisedSum(i-1, sum+i); // functional recursion

    }

    // Functional Recursion: A function where we return the result of recursive calls
    public static int functionalSum(int n){
        if(n == 0){
            return 0;
        }

        return n + functionalSum(n-1); 
    }

    public static int factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        
        int n = 3;
        //parameterisedSum(n,0); // initial sum is 0 is passed as parameter

        //System.out.println(functionalSum(n));

        System.out.println(factorial(n));

    }
}