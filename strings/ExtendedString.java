package strings;

import utils.FastReader;

public class ExtendedString {
    public static void main(String[] args) {
        /*
         * Input: "ha22"
         *        5
         * Output: h (since expand ha 2 * 2 = 4 time to get "hahahaha" and print the 5 th char from starting)
         * 
         * Input: "a2345678999999999999999"
         *         1
         * Ouput: extended string is `a` repeated `8301530446056247680` times and output is `a` since the first char form starting is `a`
         */
        FastReader sc = new FastReader();
        String str = sc.next();
        final int k = sc.nextInt();
        System.out.println(findCharInExtendedVersionString(str, k));
    }
    static char findCharInExtendedVersionString(String str, final int k) {
        //Extract the alphabetic portion from the str
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(!Character.isAlphabetic(str.charAt(i)))  //Guard-Clause
                break;
            
            sb.append(str.charAt(i));
            
        }
        return sb.charAt((k - 1) % sb.length());
    }
}
