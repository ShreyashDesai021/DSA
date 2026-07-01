import java.util.*;

public class Hashmap{

    public static int firstUniqChar(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0;i < s.length();i++){
            Character ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int i = 0;i < s.length();i++){
            if(map.getOrDefault(s.charAt(i),0) == 1){
                return i;
            }
        }

        return -1;
    }

// Below method use O(n) space complexity and O(n) time complexity, but it works for all characters.
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i = 0;i < magazine.length();i++){
            char ch = magazine.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int i = 0;i < ransomNote.length();i++){
            char ch = ransomNote.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.getOrDefault(ch,0)-1);
                if(map.get(ch) == 0){
                    map.remove(ch);
                }
            }else{
                return false;
            }
        }

        return true;
    }


// Below method use O(1) space complexity and O(n) time complexity, but it only works for lowercase letters a-z.
    // public static boolean canConstruct(String ransomNote, String magazine) {
    //     int[] freq = new int[26];

    //     for (char ch : magazine.toCharArray()) {
    //         freq[ch - 'a']++;
    //     }

    //     for (char ch : ransomNote.toCharArray()) {
    //         if (--freq[ch - 'a'] < 0) {
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    public static int maxNumberOfBalloons(String text) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i = 0; i < text.length();i++){
            char ch = text.charAt(i);
            
            map.put(ch,map.getOrDefault(ch,0)+1);

        }

        int b = map.getOrDefault('b', 0);
        int a = map.getOrDefault('a', 0);
        int l = map.getOrDefault('l', 0) / 2; // "balloon" needs 2 'l's, so divide the count by 2. Integer division floors the result (5/2 = 2)
        int o = map.getOrDefault('o', 0) / 2;
        int n = map.getOrDefault('n', 0);

        return Math.min(b,Math.min(a,Math.min(l,Math.min(o, n))));

    }

    public static int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int length = 0;
        boolean oddFlag = false;

        for(int freq : map.values()){
            if(freq % 2 == 0){
                length += freq;  // for even times appearing character we can take it completely in for palindrome 
            }else{
                length += freq - 1;
                oddFlag = true;
            }
        }

        if(oddFlag){
            length += 1;
        }

        return length;


    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode")); // Output: 0

        System.out.println(canConstruct("aa", "aab")); // Output: true

        System.out.println(maxNumberOfBalloons("loonbalxballpoonl")); // Output: 2

        System.out.println(longestPalindrome("abccccdd")); // Output: 7
    }
}