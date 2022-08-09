package misc;

import utils.FastReader;

public class MaxLenghtOfSubstring {
    public static void main(String[] args) {
        /*
         Input: "samuraimahajan"
                "maharat"
         Output: 4 (since s2 is the one to be searched in s1 and it's clear that only first 4 chars are common and thats max) 

         Input: "ninjawarrior"
                "xyz"
        Output: 0 (since the chars from s2 are not at all present in s1)
         */
        FastReader sc = new FastReader();
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        
        System.out.println(findMaxLengthOfSubstring(s1, s2));   //O(n ^ 2)
    }
    static int findMaxLengthOfSubstring(String s1, String s2) {
        //make sure always s1 > s2 if not repoint s1 to s2 & s2 to s1
        if(s1.length() < s2.length()) {
            s1 = s2;
            s2 = s1;
        }
        int res = 0;
        for(int i = 0; i <= s1.length() - s2.length(); i++) {
            int count = 0;
            int k = i;
            for(int j = 0; j < s2.length(); j++) {
                if(s1.charAt(k) == s2.charAt(j)) {
                    count++;
                    k++;
                } else {
                    res = Math.max(res, count);
                    break;
                }
            }
        }
        return res;
    }
}
