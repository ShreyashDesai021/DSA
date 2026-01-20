import java.util.*;

public class ArraysEasy {

    public static int secLargest(int[] arr){

        // if(arr.length < 2){
        //     return -1;
        // }

        // int max = Integer.MIN_VALUE;

        // for(int i : arr){
        //    if(i > max){
        //         max = i;
        //    } 
        // }

        // int secMax = Integer.MIN_VALUE;

        // for(int i : arr){
        //     if(i != max && i > secMax){
        //         secMax = i;
        //     }
        // }

        // if(secMax == Integer.MIN_VALUE){
        //     return -1;
        // }

        // return secMax;

        //Enhanced Approach:
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        if (arr.length < 2) return -1; 

        int large = Integer.MIN_VALUE, second_large = Integer.MIN_VALUE;

        // Loop through the array to find the second largest element
        for (int i = 0; i < arr.length; i++) {
            // Update the largest and second largest values
            if (arr[i] > large) {
                second_large = large;
                large = arr[i];
            } 
            else if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }
        }
        return second_large; // Return the second largest element

    }

    public static boolean checkSorted(int[] arr){
        if(arr.length < 2) return true;

        for(int i = 1 ; i < arr.length;i++){
            if(arr[i-1] > arr[i]){
                return false;
            }
        }
        return true;
    }

    public static int removeDuplicate(int[] arr){ // Using HashSet 
        HashSet<Integer> hs = new HashSet<>();

        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(!hs.contains(arr[i])){ 
                hs.add(arr[i]);

                arr[index] = arr[i];

                index++;

            }
            
        }

        return index;
    }

    public static int removeDuplicateEnhanced(int[] arr){

        int j = 1;
        for(int i = 1;i<arr.length;i++){
            if(arr[i] != arr[i-1]){
                arr[j] = arr[i];
                j++;
            }
            
        }
        return j;

    }

    public static void leftRotateBy1(int[] arr){
        if (arr.length <= 1) return;

        int x = arr[0]; // store the first element in a variable

        for(int i = 1;i< arr.length;i++){ // shift elements to left by one position
            arr[i-1] = arr[i]; 
        }

        arr[arr.length-1] = x; // place the first element at the end of the array

    }

    public static void leftRotateByd(int[] arr,int d){ // brute
        if(arr.length <= 1) return;

        if(d >= arr.length){ // if d is more than length of array
            d = d % arr.length;
        }

        ArrayList<Integer> list = new ArrayList<>(); 

        for(int i = 0;i<d;i++){ // store first d elements in arraylist
            list.add(arr[i]);
        }

        for(int i= d;i< arr.length;i++){ // shift elements to left by d positions
            arr[i-d] = arr[i];
        }

        int j = 0;
        for(int i = arr.length-d;i<arr.length;i++){ // place the stored d elements at the end of the array
            arr[i] = list.get(j); // prefered way as getting from arraylist is O(1)
            j++;
            //arr[i] = list.remove(0); // remove from start , it works but not efficient because removing from start takes O(n)
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void leftRotateBydOptimal(int[] arr,int d){
        if(arr.length <= 1) return;

        if(d >= arr.length){ // if d is more than length of array
            d = d % arr.length;
        }


        reverse(arr,0,d-1);

        reverse(arr,d,arr.length-1);

        reverse(arr,0,arr.length-1);
        
    }

    public static void moveZerostoEnd(int[] arr){
        
        int j = 0;
        for(int i = 0;i < arr.length;i++){ // swap will only be called when non-zero element is found 
                                        // so it swaps non-zero and zero elements only // ahead of swapped element j++ will again point to next zero element 
                                        // which will be available just after the last swapped non-zero element // so no need to worry if j is poitning to non-zero element
            if(arr[i] != 0){
                swap(arr,i,j);
                j++;
            }
        }
    }

    public static int[] unionOfArrays(int[] arr1, int[] arr2){

        LinkedHashSet<Integer> lh = new LinkedHashSet<>(); // to maintain the order of insertion

        for(int i = 0;i < arr1.length;i++){
            lh.add(arr1[i]);
        }

        for(int i = 0;i < arr2.length;i++){
            lh.add(arr2[i]);
        }


        int[] result = new int[lh.size()];
        int i = 0;

        for (int x : lh) { // iterating through LinkedHashSet 
            result[i++] = x;
        }

        return result; 


        // if(arr1.length>arr2.length){ // checking which array is larger to create result array of that size
                                        //can there be more elements than larger array? yes if both arrays have completely distinct elements
                                        // hence use the size of LinkedHashSet to create result array as done in above code 
        //     int i = 0;
        //     for (int x : lh) {
        //         arr1[i] = x;
        //         i++;
        //     }
        //     return arr1;
        // }
        // int i = 0;

        // for (int x : lh) {
        //     arr2[i] = x;
        //     i++;
        // }
        // return arr2;

    }

    public static ArrayList<Integer> unionOfArraysOptimal(int[] arr1, int[] arr2){
        int i=0;
        int j=0;

        ArrayList<Integer> result = new ArrayList<>();

        while(i < arr1.length && j < arr2.length){       // comparing elements of both arrays
            if(arr1[i] < arr2[j]){ // arr1 element is smaller
                if(result.isEmpty() || result.get(result.size() - 1) != arr1[i]){ // to avoid duplicates
                    result.add(arr1[i]); 
                }
                i++; // move to next element in arr1
            }
            else if(arr1[i] > arr2[j]){ // arr2 element is smaller
                if(result.isEmpty() || result.get(result.size() - 1) != arr2[j]){ // to avoid duplicates
                    result.add(arr2[j]);// add arr2 element to result
                }
                j++; // move to next element in arr2
            }
            else { // arr1[i] == arr2[j] // both elements are equal
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {  // to avoid duplicates
                    result.add(arr1[i]);
                }
                i++; // move to next element in both arrays
                j++; // move to next element in both arrays
            }

        }

        
        while (i < arr1.length) { // remaining elements of arr1 (NO COMPARISON)
            if (result.get(result.size() - 1) != arr1[i]) { // to avoid duplicates
                result.add(arr1[i]);
            }
            i++; // move to next element in arr1
        }

        // remaining elements of arr2 (NO COMPARISON)
        while (j < arr2.length) { // remaining elements of arr2
            if (result.get(result.size() - 1) != arr2[j]) { // to avoid duplicates
                result.add(arr2[j]);
            }
            j++; // move to next element in arr2
        }

        return result;
        
    }

    public static ArrayList<Integer> intersectionOptimal(int[] arr1, int[] arr2) {

        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {
                i++;
            }
            else if (arr1[i] > arr2[j]) {
                j++;
            }
            else { // equal
                res.add(arr1[i]);
                i++;
                j++;
            }
        }
        return res;
    }

  public static int missingNumber(int[] nums) {

        int n = nums.length;

        for (int i = 0; i <= n; i++) {   // check 0 to n hence i <= n
            boolean found = false;

            for (int j = 0; j < n; j++) { // iterate through the array to check if i is present hence j < n
                if (nums[j] == i) {
                    found = true;
                    break;
                }
            }

            if (!found) return i;
        }
        return -1;
    }

    public static int missingNumFormula(int[] arr){
        int n = arr.length;

        int accSum = 0;
        for(int i = 0;i < arr.length;i++){
            accSum += arr[i];
        }

        int expSum = n*(n+1)/2;

        return expSum - accSum;

    }

    public static int missingNumberHashing(int[] arr) { // using hashing array
        int n = arr.length;

        // Step 1: Create hash array of size n+1
        int[] hash = new int[n + 1];

        // Step 2: Mark present numbers
        for (int i = 0; i < n; i++) {
            hash[arr[i]] = 1;
        }

        // Step 3: Find missing number
        for (int i = 0; i <= n; i++) { 
            if (hash[i] == 0) {
                return i;
            }
        }

        return -1; // safety
    }


    public static int missingNumberHashSet(int[] arr) { // using hashset
        int n = arr.length;

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        for (int i = 0; i <= n; i++) {  
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }

    public static int missingNumXOR(int[] arr){
        int XOR1 = 0;
        int XOR2 = 0;

        for(int i = 0;i < arr.length;i++){
            XOR1 ^= arr[i];
        }

        for(int i = 0;i <= arr.length;i++){   // here i <= arr.length because we are using it to iterate through numbers for 0 to arr.length
                                           //we are not using arr[i] and accessing the values of it won't cause ArrayIndexOutOfBoundsException
            XOR2 ^= i;
        }

        return XOR1 ^ XOR2;
    }

    public static int missingNumXOROneLoop(int[] arr){
        int n = arr.length;
        int XOR = 0;

        for(int i = 0;i < n;i++){
            XOR ^= arr[i]; // XOR of all elements in the array
            XOR ^= i; // XOR of all indices from 0 to n-1 to get all numbers from 0 to n-1
        }

        XOR ^= n; // to include the last number n

        return XOR;
    }

    public static int maxCons1s(int[] arr){
        int count= 0;
        int maxCount = 0;
        for(int i = 0;i< arr.length;i++){
            if(arr[i] == 1){
                count++;
            }
            else{
                count = 0;
            }
            if(count > maxCount){
                maxCount = count;
            }
        }

        return maxCount;

    }

    public static int findNumthatAppearsOnceandOthersTwice(int[] arr){
        int XOR = 0;
        for(int i = 0;i < arr.length;i++){
            XOR ^= arr[i];
        }

        return XOR;
    }

    public static int longestSubArrayWithGivenSumK(int[] arr,int k){
        
        int maxLen = 0;
        for(int i = 0;i < arr.length;i++){
            int sum = 0; // sum for every new starting index
            int len = 0; //must be inside for loop to reset length for every new starting index
            for(int j = i;j < arr.length;j++){
                sum += arr[j];
                if(sum == k){
                    len = j-i+1;
                    //break; // break should be used only if all elements are positive else it will not work for negative elements
                }
            }
            if(len > maxLen){
                maxLen = len; 
            }
        }
        return maxLen;
    }

    // public static int longestSubArrayWithGivenSumKSlidingWindow(int[] arr,int k){
    //     int maxLen = 0;
    //     int sum = 0;
    //     for(int i = 0;i < arr.length;i++){
    //         int len = 0;
    //         for(int j = i;j < arr.length;j++){
    //             sum += arr[j];
    //             if(sum > k){
                    
    //             }
    //         }
    //     }

    // }


    public static int[] twoSum(int[] arr,int target){
        
        for(int i = 0;i < arr.length;i++){
                for(int j = i + 1; j < arr.length;j++){
                    if(arr[i] + arr[j] == target){
                        return new int[]{i,j};
                    }
                }

        }

        return new int[]{-1,-1};

    }

    public static int[] twoSumHashMap(int[] arr,int target){
        
        
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // If complement found, return indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store current element and index
            map.put(arr[i], i);
        }

        // No pair found
        return new int[] { -1, -1 };
    }

    public static int[] twoSumTwoPointer(int[] arr, int target) {
        int n = arr.length;
        int[][] numsWithIndex = new int[n][2]; // to store numbers along with their original indices
                                              // 2D array where first column is value and second column is original index
        
        // Store element with original index
        for (int i = 0; i < n; i++) {
            numsWithIndex[i][0] = arr[i]; // value
            numsWithIndex[i][1] = i; // original index
        }
        
        // Sort by the value to apply two-pointer
        Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0, right = n - 1;
        while (left < right) {
            int sum = numsWithIndex[left][0] + numsWithIndex[right][0];
            if (sum == target) {
                // Return original indices of the two numbers found
                return new int[] {numsWithIndex[left][1], numsWithIndex[right][1]};
            } else if (sum < target) {
                // Increase sum by moving left pointer forward
                left++;
            } else {
                // Decrease sum by moving right pointer backward
                right--;
            }
        }
        
        // No pair found
        return new int[] {-1, -1};
    }

    public static void sort012(int[] arr){ // brute force approach // bubble sort

        for(int i = 1;i < arr.length;i++){
            for(int j = i;j < arr.length;j++){
                if(arr[i-1] > arr[j]){
                    swap(arr,i-1,j);
                }
            }
        }
    }

    public static void sort012_3counter(int[] arr){ // counting approach
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == 0){
                zero++;
            }else if(arr[i] == 1){
                one++;
            }
            else{
                two++;
            }
        }

        // for(int i = 0;i < zero;i++){  // wrong way to do it as it overwrites values of arr while counting
        //     arr[i] = 0;
        // }

        // for(int i = zero;i < one;i++){
        //     arr[i] = 1;
        // }

        // for(int i = one;i < two;i++){
        //     arr[i] = 2;
        // }

        int index = 0;
        for(int i = 0; i < zero; i++) arr[index++] = 0;
        for(int i = 0; i < one;  i++) arr[index++] = 1;
        for(int i = 0; i < two;  i++) arr[index++] = 2;

    }

    public static void dnf_012sort(int[] arr){ //dnf = dutch national flag
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            }else if(arr[mid] == 1){
                mid++;
            }else if(arr[mid] == 2){
                swap(arr, mid, high);
                high--;
            }
        }
    }
    
    public static int majorityElement_brute_count(int[] arr){ //element > arr.length/2
        for(int i = 0;i < arr.length;i++){
            int count = 0;
            for(int j = 0;j < arr.length;j++){
                if(arr[i] == arr[j]) count++;
            }
            if(count > arr.length/2) return arr[i];
        }
        return -1;
    }

    public static int majorityElement_better_hash(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > arr.length/2 ){
                return entry.getKey();
            }
        }

        return -1;
    }

    public static int majorityElement_opt_moore_voting(int[] arr) {
        int cnt = 0;
        int ele = 0;

        for (int i = 0; i < arr.length; i++) {
            if (cnt == 0) {
                ele = arr[i];   
                cnt = 1;
            } else if (arr[i] == ele) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return ele;
    }

    public static int maxSubArrSum(int[] arr){
        int maxSum = 0;

        for(int i = 0;i < arr.length;i++){
            
            for(int j = i;j< arr.length;j++){
                int sum = 0;
                for(int k = i;k < j;k++){
                    sum += arr[k];
                    maxSum = Math.max(maxSum,sum);
                }
            }
        }

        return maxSum;
    }
 

    public static void main(String[] args) {
        
        int[] arr = new int[]{-2,-3,4,-1,-2,1,5,-3};
        //int t = 18; 
        //int[] arr1 = new int[]{0,1,1,1,0,0,1,1,0,0,1};

        for (int i = 0; i < arr.length; i++) { 
            System.out.print(arr[i] + " ");
        }

        
        // System.out.println(secLargest(arr));
        // System.err.println(checkSorted(arr));
        //System.out.println(removeDuplicateEnhanced(arr));

        // leftRotateBy1(arr);
        //leftRotateByd(arr,6);

        // leftRotateBydOptimal(arr,3);
        // moveZerostoEnd(arr);

        // int[] arr1 = new int[]{1,2,3,4,4,5};

        // int[] arr2 = new int[]{2,3,5,6,7};

        // int n;                // all these lines are not needed as we can directly create result array using LinkedHashSet size

        // if(arr1.length > arr2.length){
        //     n = arr1.length;
        // }else {
        //     n = arr2.length;
        // }

        // int[] arr3 = new int[n];

        // arr3 = unionOfArrays(arr1,arr2);

        //int[] arr3 = unionOfArrays(arr1, arr2);

        //ArrayList<Integer> li = unionOfArraysOptimal(arr1,arr2);

        // ArrayList<Integer> li = intersectionOptimal(arr1,arr2);

        // for (int i = 0; i < li.size(); i++) {
        //     System.out.print(li.get(i) + " ");
        // }

        // for (int i = 0; i < arr.length; i++) { 
        //     System.out.print(arr[i] + " ");
        // }

        System.out.println("");
       // System.out.println(missingNumber(arr));
        //System.out.println(missingNumFormula(arr));

       // System.out.println(missingNumXOROneLoop(arr));
        //System.out.println(maxCons1s(arr));
        //System.out.println(findNumthatAppearsOnceandOthersTwice(arr));

        //System.out.println(longestSubArrayWithGivenSumK(arr,15));

        // int[] t_arr = twoSum(arr,t);

        //int[] t_arr = twoSumHashMap(arr,t);

        //int[] t_arr = twoSumTwoPointer(arr,t);

        //sort012(arr);

        //sort012_3counter(arr);

        //dnf_012sort(arr);

        //int major = majorityElement_brute_count(arr);

        //int major = majorityElement_better_hash(arr);

        //int major = majorityElement_opt_moore_voting(arr);

        int max = maxSubArrSum(arr);

        System.out.println(max);

        // for (int i = 0; i <arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }


        System.err.println("");

        
    }
}

// tried majority sums 