package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetKeypadCombinations {
    static String[] codes = {",;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tv", "vwx", "yz"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(getKPC(input));
    }
    static List<String> getKPC(String str) {
        //base-case:
        if(str.length() == 0) {
            List<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }

        //recursive-case:
        char ch = str.charAt(0);
        String restOfTheString = str.substring(1);

        List<String> recursiveResult = getKPC(restOfTheString);
        List<String> finalRes = new ArrayList<>();
        String codeForChar = codes[ch - '0'];
        for(int i = 0; i < codeForChar.length(); i++) {
            char currChar = codeForChar.charAt(i);
            for(String res : recursiveResult) {
                finalRes.add(currChar + res);
            }
        }
        return finalRes;
    }
}
