// Sliding Window
import java.util.*;

public class SW{
    public static int longestSubStrWORepeat(String s){

        int[] hash = new int[256]; //imp: we are using this hash array to store the last occurence of that element , not just the count
        Arrays.fill(hash,-1);

        int l = 0, r = 0, maxLen = 0;

        while(r < s.length()){

            if(hash[s.charAt(r)] != -1){
                if(hash[s.charAt(r)] >= l){
                    l = hash[s.charAt(r)] + 1;
                }
            }
            int len = r - l + 1;
            maxLen = Math.max(len,maxLen);
            hash[s.charAt(r)] = r; // since we are storing the last occurence hence we have equated it will 'r' and not 1 on R.H.S
            r++;
        }

    return maxLen;

    } // T = O(n) , S = O(256)

    public static int maxZerosIIIbetter(int[] arr,int k){
        int l = 0, zeros =0, maxLen = 0;

        for(int r = 0;r < arr.length; r++){
            if(arr[r] == 0){
                zeros++;
            }

            while(zeros > k){
                if(arr[l] == 0){
                    zeros--;
                }
                l++;
            }
            int len = r - l + 1;
            maxLen = Math.max(maxLen,len);
        }
        return maxLen;
    }

    public static int maxZerosIIIoptimal(int[] arr, int k){
        int l= 0, zeros = 0, maxLen = 0;

        for(int r = 0; r < arr.length;r++){
            if(arr[r] == 0){
                zeros++;
            }

            if(zeros > k){
                if(arr[l] == 0){
                    zeros--;
                }
                l++;
            }
            int len = r - l + 1;
            maxLen = Math.max(maxLen,len);
        }

        return maxLen;
    }


    public static void main(String[] args) {
        String str = "cadbzabcd";

        //System.out.println(longestSubStrWORepeat(str));

        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};

        int k = 2;

        System.out.println(maxZerosIIIbetter(arr, k));

        System.out.println(maxZerosIIIoptimal(arr, k));

        
    }

}    
