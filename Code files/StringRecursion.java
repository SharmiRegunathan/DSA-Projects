import java.util.ArrayList;

public class StringRecursion {
    public static void main(String[] args) {
        System.out.println(subsequence("abc", ""));
    }

    static ArrayList<String> subsequence(String str, String ans){

        if(str.isEmpty()){
            ArrayList<String> st = new ArrayList<>();
            st.add(ans);
            return st;
        }

        char ch = str.charAt(0);

        ArrayList<String> left = subsequence(str.substring(1), ans + ch);
        ArrayList<String> right = subsequence(str.substring(1), ans);

        left.addAll(right);
        return left;

    }

    static String removeA(String str){
        return removeAhelper(str, 0, "");
    }

    static String removeAhelper(String str, int count, String ans){

        if(count == str.length()){
            return ans;
        }

        StringBuilder sb = new StringBuilder(ans);

        if(str.charAt(count) != 'a' && str.charAt(count) != 'A'){
            sb.append(str.charAt(count));
        }

        return removeAhelper(str, count + 1, sb.toString());
    }

    static String skip(String str){

        if(str.isEmpty()){
            return "";
        }

        char ch = str.charAt(0);

        if(ch != 'a' && ch != 'A'){
            return ch + skip(str.substring(1));
        }else{
            return skip(str.substring(1));
        }

    }

    static String skip2(String str, int count){

        String ans = "";

        if(count == str.length()){
            return ans;
        }

        char ch = str.charAt(count);

        if(ch != 'a' && ch != 'A'){
            ans += ch;
        }

        String ansfrombelow =  skip2(str,count+1);

        ans += ansfrombelow;

        return ans;
    }

    static String skipString(String str, String skipstr,String ans){

        if(str.isEmpty()){
            return ans;
        }

        if(!str.startsWith(skipstr)){
            ans += str.charAt(0);
            return skipString(str.substring(1), skipstr, ans);
        }

        return skipString(str.substring(skipstr.length()),skipstr, ans);
    }

    static String skipStringLocal(String str, String skipstr){

        String ans = "";
        String ansfrombelow = "";

        if(str.isEmpty()){
            return ans;
        }

        if(!str.startsWith(skipstr)){
            ans += str.charAt(0);
            ansfrombelow = skipStringLocal(str.substring(1), skipstr);
        }else{
            ansfrombelow = skipStringLocal(str.substring(skipstr.length()), skipstr);
        }

        ans += ansfrombelow;

        return ans;
    }
}
