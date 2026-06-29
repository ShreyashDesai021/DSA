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

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode")); // Output: 0
    }
}