package misc;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestCommonPrefix
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder("");
        //first scan to figure out the smallest length word
        int n = strs.length;
        int smallest = strs[0].length();
        for(int i = 1; i < n; i++) {
            smallest = Math.min(smallest, strs[i].length());
        }

        //now point and shoot
        for(int i = 0; i < smallest; i++) {
            Set<Character> set = new HashSet<>();
            for(int j = 0; j < n; j++) {
                //extract all ith chars from strs[j]
                set.add(strs[j].charAt(i));
            }
            if(set.size() == 1)
                res.append(strs[0].charAt(i));
            else
                break;
        }
        return res.toString();
    }
}
