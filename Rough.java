
import java.util.*;

class Rough{
    public static int secLarge(int[] arr){

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        int sec_max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > sec_max && arr[i] != max){
                sec_max = arr[i];
            }
        }

        return sec_max;

    }

    public static int[] twoSumHashMap(int[] arr,int target){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < arr.length;i++){
            int complement = target - arr[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }

            map.put(arr[i],i);
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {

        int[] arr = {5,5,5,5,5,5};

        int sec_max = secLarge(arr);

        System.out.println(sec_max);
    }
}