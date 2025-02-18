import java.util.Stack;

public class Strings_Easy {
    public static void main(String[] args) {
        String a = "ulacfd";
        String b = "jizalu";
        System.out.println(checkPalindromeFormation(a,b));
        //System.out.println(ispalindrome("abc"));
    }

    public static boolean checkPalindromeFormation(String a, String b) {
        int n = a.length();

        for(int i = 0; i < a.length()+1; i++){
            String a_prefix = a.substring(0,i);
            String a_suffix = a.substring(i,n);

            String b_prefix = b.substring(0,i);
            String b_suffix = b.substring(i,n);


            if(ispalindrome(a_prefix + b_suffix) ||ispalindrome(b_prefix + a_suffix)) return true;
        }
        return false;
    }

    public static boolean ispalindrome(String str){
        if(str.equals(rev(str))) return true;
        else return false;
    }

    public static String rev(String str){
        char[] arr = str.toCharArray();

        int s = 0;
        int e = str.length()-1;

        while(s<=e){
            char temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;

            s++;
            e--;
        }

        return new String(arr);
    }

    //reverse each word in a sentence
    public static String reverseWords(String s) {
        String[] ans = s.split(" ");

        for(int i = 0; i < ans.length; i++){
            ans[i] = reverseWord(ans[i]);
        }
        return String.join(" ",ans);
    }

    //reverse a single word
    public static String reverseWord(String s) {

        char[] str = s.toCharArray();

        int start = 0;
        int end = s.length()-1;

        while(start<=end){
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;

            start++;
            end--;
        }

        return new String(str);
    }


    public static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int match = 0;

        for(int i = 0; i < s.length(); i++){
            if(i+2 < s.length() && s.charAt(i+2) == '#'){
                match = Integer.parseInt(s.substring(i,i+2));
                i+=2;
            }else if(s.charAt(i) == '#') continue;
            else{
                match = s.charAt(i) - '0';
            }

            sb.append((char)(match + 96));
        }

        return sb.toString();
    }

    public static boolean halvesAreAlike(String s) {
        String first = s.substring(0,s.length()/2).toLowerCase(); // count vowels in first half
        String second = s.substring(s.length()/2).toLowerCase(); // count vowels in second half

        if(checkVowels(first) == checkVowels(second)){
            return true;
        }

        return false;
    }

    // to count the number of vowels in a string
    // vowels.indexOf(ch) - returns index of ch in vowels if present, else -1
    public static int checkVowels(String str){
        String vowels = "aeiou";
        int count = 0;

        for(char ch : str.toCharArray()){
            if(vowels.indexOf(ch) != -1){
                count++;
            }
        }

        return count;
    }

    //Check if a string is a palindrome or not
    public static boolean isPalindrome(String s) {
        String copy = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        char[] arr = copy.toCharArray();

        int start = 0;
        int end = arr.length -1;

        while(start <= end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        String rev = new String(arr);
        return rev.equals(copy);
    }

    // Valid parenthesis
    static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(') st.push(')');
            else if(ch == '{') st.push('}');
            else if(ch == '[') st.push(']');

            else if(st.pop() != ch || st.isEmpty()){
                return false;
            }
        }
        return true;
    }

    //Hashing of string ignoring the case of the alphabets
    static int hashingSearchString(char target, String str) {
        //Creating Hash array
        //Since maximum number of alphabets is 6
        int[] hash = new int[26];
        int map = target - 'a';

        //Computation is based on lowercase ascii values
        str = str.toLowerCase();
        //Looping through the array and updating the hash array
        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i) - 'a'] += 1;
        }
        return hash[map];
    }

    // taking into account the alphabet case
    static int hashingSearchAnyString(char target, String str) {
        //Creating Hash array
        //Since maximum number of alphabets is 6
        int[] hash = new int[256];
        int map = target;

        //Looping through the array and updating the hash array
        //When any character is encountered, the value is stored in its ascii value
        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i)] += 1;
        }
        return hash[map];
    }


    // Rotation of string
    static boolean rotateString(String s, String goal) {
        int n = s.length();
        String copy = s;

        for(int i = 1; i <= n-1; i++){
            s = rotation(s);
            if(s.equals(goal)){
                return true;
            }
        }
        return false;
    }

    static String rotation(String s) {
        //String copy = s;

        StringBuilder string = new StringBuilder(s);
        char first = string.charAt(0);

        for(int i = 1; i < string.length(); i++){
            string.setCharAt(i-1, string.charAt(i));
        }
        string.setCharAt(string.length()-1, first);

        return string.toString();
    }

}
