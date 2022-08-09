package recursion;

import java.util.ArrayList;
import java.util.List;

public class GetSubsequences {
    static List<String> getSubsequences(String str) {
        //base-case:
        if(str.length() == 0) {
            List<String> res = new ArrayList<> ();
            res.add("");    
            return res;
        }

        //recursive-case:
        char ch = str.charAt(0);
        String ss = str.substring(1);
        List<String> temp = getSubsequences(ss);
        List<String> finalRes = new ArrayList<>();
        for(String s : temp) {
            finalRes.add(ch + s);
        }
        for(String s: temp) {
            finalRes.add("" + s);
        }
        return finalRes;
    }
    public static void main(String[] args) {
        System.out.println(getSubsequences("abc"));
    }
}
