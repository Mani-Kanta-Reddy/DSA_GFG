package misc;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class LongestPalindrome
{
    //leetcode-2131
    public static void main(String[] args)
    {
        String[] words = {"bb", "bb"};
        //Output: 14
        out.println(longestPalindrome(words));
    }
    public static int longestPalindrome(String[] words) {
        int howManyPairs = 0;
        Map<String, Integer> exists = new HashMap<>();
        boolean foundSelfPalindrome = false;
        for(String word : words) {
            //check if reverse of word is present inside exists map
            //if present increment howManyPairs and remove
            String reversed = reverse(word);
            if(exists.containsKey(reversed) && exists.get(reversed) > 0) {
                howManyPairs++;
                exists.put(reversed, exists.get(reversed) - 1);

            } else {
                if(!exists.containsKey(word)) {
                    exists.put(word, 1);
                } else {
                    exists.put(word, exists.get(word) + 1);
                }
            }
        }
        //finally traverse the remaining entries in the map check for the first selfPalindrome and break
        for(String key : exists.keySet()) {
            if(key.equals(reverse(key)) && exists.get(key) > 0) {
                foundSelfPalindrome = true;
                break;
            }
        }
        //if selfPalindrome found add +2 to howManyPairs * 4 else ans is howManyPairs * 4
        return foundSelfPalindrome ? howManyPairs * 4 + 2 : howManyPairs * 4;
    }
    public static String reverse(String str) {
        if(str.length() == 0)
            return str;
        //getCharArray() -> reverse it -> convert back to String and return
        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length / 2; i++) {
            //swap arr[i] with arr[length - i - 1]
            char temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return new String(arr);
    }
}
