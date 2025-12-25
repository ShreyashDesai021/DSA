// Recursion: 

import java.util.Scanner; 

public class RecusionBasic{   
    
    public static void printName(int n,int i){

        if(i > n){  // base case
            return;
        }

        System.out.println("Shreyash");
        printName(n,++i);  // i++ will not work 
    }

    public static void print1toN(int n,int i){  // Time Complexity: O(n) 
                                                // Auxiliary Space: O(n) // for function call stack
        if(i > n){  // base case
            return;
        }

        System.out.println(i); // print before the function call
        print1toN(n,++i);  // i++ will not work 
    }
    
    public static void printNto1(int n){
       if(n<=0){
        return;
       }
       System.out.println(n); // print before the function call
       printNto1(n-1);
    }

    // Backtracking:

    public static void print1toNBacktrack(int n,int i){ // i.e i = 3 and n = 3 at start
        if(i <= 0 ){
            return;
        }

        print1toNBacktrack(n, i-1); //here we are using (i-1) so that function calls are made
                    //without changing the value of i for current function call
                    //if we use --i or i = i-1 here, then value of i will be changed for current function call
        System.out.println(i); // print after the function call is complete
    }

    public static void printNto1Backtrack(int n,int i){ 
       if(i > n){
        return;
       }

       printNto1Backtrack(n, i+1);
       System.out.println(i);


    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        //System.out.print("Enter the value of n: ");
        //int n = sc.nextInt();
        //printName(n,1);

        //print1toN(n,1);

        //printNto1(n);

        //print1toNBacktrack(3,3);

        printNto1Backtrack(3,1);
    }


}



