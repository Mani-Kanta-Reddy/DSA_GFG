package strings;

import java.util.LinkedHashMap;
import java.util.Map;

import utils.FastReader;

public class ExtendedStringV2 {
    public static void main(String[] args) {
        /*
         * Input: "java2code3"  (2 <= S.length <= 250 and will contain only lower case letters and digits from 2 to 9
         *                       S starts with a letter)
         *        10            (1 <= k <= 10 ^ 9)
         * Ouput: `o`
         * Explanation: The Extended String is "javajavacodecodecode" and the 10th char from the start is `o`
         */
        /*java2code3mani2 -> javajavacodecodecodemanimani
         * java -> 8
         * code -> 20
         * mani -> 28
         * 21 < 28 -> "mani" = 21 % 4 = 1 -> m
         */
        FastReader sc = new FastReader();
        String str = sc.next();
        final int k = sc.nextInt();
        System.out.println(findCharInExtendedString(str, k));
    }
    static char findCharInExtendedString(String str, final int k) {
        //Build the map which contains the "String" -> "Integer" (string -> how many its repeated)
        Map<StringBuilder, Integer> strAndItsEnd = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if(Character.isAlphabetic(currChar))
                sb.append(currChar);
            if(Character.isDigit(str.charAt(i))) {
                strAndItsEnd.put(sb, Character.getNumericValue(currChar) * sb.length());
                sb = new StringBuilder();
            }
        }
        
        //Find the Char
        int actualPos = 0;
        for(Map.Entry<StringBuilder, Integer> entry: strAndItsEnd.entrySet()) {
            StringBuilder currKey = entry.getKey();
            int currValue = entry.getValue();
            actualPos += currValue;
            if(k < actualPos) {
                return currKey.charAt((k - 1) % currKey.length());
            }
        }
        return '\0';    //This is never going to be executed but to make the compiler happy :)
    }
}
