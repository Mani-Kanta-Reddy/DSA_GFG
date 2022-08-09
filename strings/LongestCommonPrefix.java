package strings;

import utils.FastReader;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        /*
        Input: Array of Strings ["Reindeer", "reinforce", "reign"]
        Output: "rei" (since `rei` is the Longest Common prefix)

        Note: If there is no common prefix return -1 also ignore case-senstivity
        for e.g., 
        Input: ["ram", "sam", "mam"]
        Output: -1 (since there is no common prefix et all)
        */
        FastReader sc = new FastReader();
        final String[] arr = sc.nextLine().split("\\s");
        System.out.println(FindLongestCommonPrefix(arr));
    }
    static String FindLongestCommonPrefix(String[] arr) {
        StringBuilder res = new StringBuilder();
        //In the worst case the longest common prefix is the size of the smallest String
        //so we need to iterate those many times
        int min = Integer.MAX_VALUE; 
        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].toLowerCase();
            min = Math.min(min, arr[i].length());
        }
        
        outer: for(int i = 0; i < min; i++) {
            StringBuilder temp = new StringBuilder();
            for(String str: arr) {
                temp.append(str.charAt(i));
            }
            //if all the chars are same then fine add that char to res else break
            boolean isAllSame = true;
            
            for(int j = 1; j < temp.length(); j++) {
                if(temp.charAt(j) != temp.charAt(0)) {
                    isAllSame = false;
                    break outer;
                }
            }
            if(isAllSame) res.append(temp.charAt(0));
        }
        return res.length() == 0 ? "-1" : res.toString();
    }
}
