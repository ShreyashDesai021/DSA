
import java.util.*;

// Concept of Hashing : Definition, Types, Applications, and Advantages

// Definition:
// Hashing is a technique used to convert data of arbitrary size into a fixed-size value,
// known as a hash code or hash value. This process is performed by a hash function,
// which takes an input (or 'key') and produces a unique output that represents the original data.

// Types of Hashing:
// 1. Cryptographic Hashing: Used for security purposes, ensuring data integrity and authenticity.
//    Examples include SHA-256, MD5.
// 2. Non-Cryptographic Hashing: Used for general data retrieval and storage, such as hash tables.
//    Examples include MurmurHash, CityHash.    

// Applications of Hashing:
// 1. Data Retrieval: Hash tables use hashing to quickly locate data without searching through every item.
// 2. Password Storage: Hashing is used to securely store passwords by converting them into hash values.
// 3. Digital Signatures: Hashing ensures the integrity of digital documents and communications.
// 4. Caching: Hashing helps in efficiently storing and retrieving cached data.
// 5. Load Balancing: Hashing algorithms distribute requests evenly across servers.

// Advantages of Hashing:
// 1. Speed: Hashing allows for fast data retrieval, often in constant time O(1).
// 2. Efficiency: Reduces the need for extensive searching, improving overall performance.
// 3. Data Integrity: Ensures that data has not been altered or tampered with.
// 4. Scalability: Hashing techniques can handle large datasets effectively.

public class Hashing{


    // Function to count frequency of each element in the array using HashMap
    public static void Frequency(int[] arr, int n) {
        // Create a HashMap to store frequency of each element
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array and count frequencies
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // why getOrDefault? to avoid null pointer exception
        }

        // Traverse through the HashMap and print frequencies
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { // entrySet() returns a set of key-value pairs
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }






    //static int[] hash = new int[1_000_000]; //only safe till ~10^6 elements



    public static void main(String[] args) {
        
        Scanner sc =  new Scanner(System.in);

        /*
        int n = 12;

        int[] arr = new int[n];

        arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        // System.out.println("Enter the Elements of the Array:");
        // for(int i = 0;i < arr.length;i++){
        //     arr[i] = sc.nextInt();
        // }

        // Precompute :  

        int[] hash = new int[13]; // Assuming elements are in the range 0-12 as we have taken size of hash as 13
                                  //size of hash array is greater than size of input array to reduce collisions 
        // int[] hash = new int[1_000_000]; //only safe till ~10^6 elements
        for(int i = 0;i < arr.length;i++){ // Traversing through each element of input array
            hash[arr[i]] += 1; // Storing frequency of each element by incrementing the value at index equal to the element value
        }


        
        System.out.println("How Many Times will You Retrive Frequency?");
        int q = sc.nextInt();
        while (q > 0) { 
            // Fetch :int number = sc.nextInt();
            System.out.println("Frequency of " + number + ":" + hash[number]);
            q--;
        }
        */

       /*
       //Character hashing for small case letters string:

       String s = "hello";
       
       //PRECOMPUTE :
       int[] hash = new int[25]; // As there are 26 small case letters therefore size of hash array is 25

        for (int i = 0; i < s.length(); i++) { // Traversing through each character of the string
            hash[s.charAt(i) - 'a']++;         // Incrementing frequency of character at index equal to (character - 'a')
        }                                      // 'a' is subtracted to map 'a' to index 0, 'b' to index 1, ..., 'z' to index 25
                                                // here automatic type casting is done from char to int in ASCII value in the hash[ --- ] expression
        // Queries
        int q = sc.nextInt();
        while (q-- > 0) {
            char c = sc.next().charAt(0);      // Input character to fetch frequency for

            // Fetch
            System.out.println(hash[c - 'a']); // Output frequency of character at index equal to (character - 'a')
        }
         */


        //Character hashing for both small and capital letters:

        String s = "HelloWorld";

        //PRECOMPUTE:
        int[] hash = new int[256]; //for all ASCII characters hence always prefer arrays as it is limited to 256 characters only

        for(int i = 0; i < s.length(); i++){
            hash[s.charAt(i)]++;
        }

        int q = sc.nextInt();

        while(q-- > 0){
            char c = sc.next().charAt(0);  // Input character to fetch frequency for 
            System.out.println(hash[c]);
        } 





        int[] arr = {10, 5, 10, 15, 10, 5};
        Frequency(arr, arr.length);

    }


    
}