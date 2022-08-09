package misc;

import java.util.HashMap;
import java.util.Map;

import utils.FastReader;

public class RemoveDuplicateDigits {
    public static void main(String[] args) {
        /*
        Input: 2398 (any integer)
        Output: 2398 (integer) (since all digits are unique)

        Input: 1331
        Output: -1 (since there are no unique digits)
        */
        FastReader sc = new FastReader();
        final int n = sc.nextInt();
        final char[] arr = Integer.toString(n).toCharArray();
        System.out.println(removeDuplicates(arr));  //O(n ^ 2)
        System.out.println(removeDuplicatesHashMap(arr));    //O(n)
    }
    static int removeDuplicates(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            boolean isFound = false;
            for(int j = 0; j < arr.length; j++) {
                if(j == i)
                    continue;
                if(arr[i] == arr[j]) {
                    isFound = true;
                    break;
                }
            }
            if(!isFound) 
                sb.append(arr[i]);
        }
        return sb.length() == 0 ? -1 : Integer.parseInt(sb.toString());
    }
    static int removeDuplicatesHashMap(char[] arr) {
        //count the freq's of each char
        Map<Character, Integer> freq = new HashMap<>();
        for(char ch: arr) {
            if(!freq.containsKey(ch))
                freq.put(ch, 1);
            else {
                freq.put(ch, freq.get(ch) + 1);
            }
        }
        //prepare the result
        StringBuilder sb = new StringBuilder();
        
        for(Map.Entry<Character, Integer> entry: freq.entrySet()) {
            if(entry.getValue() == 1)
                sb.append(entry.getKey());
        }
        return sb.length() == 0 ? -1 : Integer.parseInt(sb.toString());
    }
}
