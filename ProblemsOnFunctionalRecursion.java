public class ProblemsOnFunctionalRecursion {
    
    public static int[] reverseArrayRecursion(int[] arr,int s,int e){ // swap using two variables
        if(s>=e){
          return arr;
        }
          
        int temp;

        temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
        return reverseArrayRecursion(arr, s+1, e-1);    
    }

    public static int[] reverseArrayRecursion1pointer(int[] arr,int i){ // swap using two variables
        if(i >= arr.length/2 ){
          return arr;
        }
          
        int temp;

        temp = arr[i];
        arr[i] = arr[(arr.length - 1) - i];
        arr[((arr.length - 1) - i)] = temp;
        return reverseArrayRecursion1pointer(arr, i+1);    
    }

    public static boolean isPalindrome(String s,int i){  // TC = O(n) , SC = O(n/2)// due to recursive stack space
                                                                            // n/2 because we are checking only half of the string
    
        if (i >= s.length() / 2) {
            return true;
        }  
        
        if(s.charAt(i) != s.charAt((s.length()-1)-i )) {
            return false;
        }

        

        return isPalindrome(s,i+1);
    }


    public static void main(String[] args) {
        
        // int[] arr = { 2,4,3,5,0}; 

        // for(int i = 0; i < arr.length;i++){
        //     System.out.print(arr[i] + " ");
        // }


        //int[] revArr = reverseArrayRecursion1pointer(arr,0); 
         
        // System.out.println("");
        // for (int idx = 0; idx < arr.length; idx++) {
        //     System.out.print(revArr[idx] + " ");
        // } 
        // System.out.println("");

        String s ="MADAM";
        System.out.println(isPalindrome(s,0));
    }

}