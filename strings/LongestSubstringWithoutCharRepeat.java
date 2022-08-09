package strings;

import utils.FastReader;

public class LongestSubstringWithoutCharRepeat {
    public static void main(String[] args) {
        /*
         * Input: s = "abcabcbb"
           Output: 3
           Explanation: The answer is "abc", with the length of 3.
           Example 2:
           
           Input: s = "bbbbb"
           Output: 1
           Explanation: The answer is "b", with the length of 1.
           Example 3:
           
           Input: s = "pwwkew"
           Output: 3
           Explanation: The answer is "wke", with the length of 3.
           Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
         */
        FastReader sc = new FastReader();
        String str = sc.next();
        System.out.println(findLenghtOfLongestSubstringWithoutCharRepeat(str));
    }
    static int findLenghtOfLongestSubstringWithoutCharRepeat(String str) {
        int max = 0;
        String res = "";
        for(int i = 0; i < str.length(); i++) {
            for(int j = str.length(); j >= i + 1; j--) {
                String currSubstring = str.substring(i, j);
                boolean hasRepeatedChars = hasRepeatedChars(currSubstring);
                if(hasRepeatedChars)
                    continue;
                // max = Math.max(max, str.substring(i, j).length());
                if(currSubstring.length() > max) {
                    max = currSubstring.length();
                    res = currSubstring;
                }
            }
        }
        System.out.println(res);
        return max;  //this will not be executed et all but to make compiler happy :)
    }
    static boolean hasRepeatedChars(String str) {
        for(int i = 0; i < str.length(); i++) {
            for(int j = i + 1; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
