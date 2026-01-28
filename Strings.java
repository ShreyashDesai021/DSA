public class Strings {
    public static String removeOuterParentheses(String s){
        StringBuilder res = new StringBuilder();
        int balance = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { // if we are going from 0 to 1 that means its an opening parenthese '(' , so we will skip it
                if (balance > 0) {        // not outermost '('
                    res.append('(');
                }
                balance++;
            } else {  // if we are going from 1 to 0 that means its an ending parenthese ')', so we will skip it
                balance--;
                if (balance > 0) {        // not outermost ')'
                    res.append(')');
                }
            }
        }
        return res.toString(); // dont forget // res is an object of type StringBuilder, not String, hence we convert the object to string and then return
    
    }


    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();

        //s = new StringBuilder(s).reverse().toString();
        s = revString(s); // so now complete string along with all characters is reversed

        for(int i = 0;i < s.length();i++){
            StringBuilder word = new StringBuilder();

            while(i < s.length() && s.charAt(i) != ' '){ // lets select words skipping spaces //i < s.length() should be made before the other check
                word.append(s.charAt(i));
                i++;
            }

            word = word.reverse();
            if(word.length() > 0){
                ans.append(" ".concat(word.toString())); //" " is string so it uses concate , but word is StringBuilder obj so it uses append
            }
        
        }

        return ans.substring(1);
    }

    private static String revString(String s){
        char[] arr = s.toCharArray(); // imp coz Strings are immutable hence cant directly swap
        int i = 0, j = arr.length - 1;

        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return new String(arr);
    }

    public static String largestOddNumber(String num) {
        // Start from the end of the string and move backwards
        for (int i = num.length() - 1; i >= 0; i--) {
            // Check if the character at index i is an odd digit
            // (char - '0') converts the character to its integer value
            if ((num.charAt(i) - '0') % 2 != 0) {
                // If the last digit of a substring is odd, 
                // the entire substring is an odd number.
                return num.substring(0, i + 1);
            }
        }
        
        // If no odd digit is found, return an empty string
        return "";
    }

    public static void main(String[] args) {
        //String s = "(()())(())";

        //String s = "  Hello  how are u? ";

        String s = "459801";

        String res = largestOddNumber(s);
        System.out.println(res);
    }
}