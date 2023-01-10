package misc;

import java.util.*;

public class CountUniqueChars
{
    //LeetCode -- 828
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
//        System.out.println(new CountUniqueChars().uniqueLetterString(s));
        System.out.println(new CountUniqueChars().totalUniqueCharsInSubstrings(s));
    }
    public int uniqueLetterString(String s) {
        if(s.length() == 1) {
            return 1;
        } else {
            //generate substrings from s
            int totalUniqueChars = 0;
            for(int i = 0; i < s.length(); i++) {
                for(int j = i + 1; j <= s.length(); j++) {
                    String substr = s.substring(i, j);
                    int noOfUniqueChars = 0;
                    Map<Character, Integer> freq = new HashMap<>();
                    for(int k = 0; k < substr.length(); k++) {
                        if(!freq.containsKey(substr.charAt(k))) {
                            freq.put(substr.charAt(k), 1);
                            noOfUniqueChars++;
                        }
                    }
                    totalUniqueChars += noOfUniqueChars;
                }
            }
            return totalUniqueChars;
        }
    }
    public int totalUniqueCharsInSubstrings(String s)
    {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if(!map.containsKey(currChar)) {
                List<Integer> list = new ArrayList<>();
                list.add(-1);
                list.add(i);
                map.put(currChar, list);
            } else {
                List<Integer> list = map.get(currChar);
                list.add(i);
                map.put(currChar, list);
            }
        }
        int finalRes = 0;
        for(List<Integer> list : map.values()) {
            int count = 0;
            for(int i = 1; i < list.size(); i++) {
                int left, right;
                if(i != list.size() - 1) {
                    right = list.get(i + 1) - list.get(i);
                } else {
                    right = s.length() - list.get(i);
                }
                left = list.get(i) - list.get(i - 1);
                count += left * right;
            }
            finalRes += count;
        }
        return finalRes;
    }
}
