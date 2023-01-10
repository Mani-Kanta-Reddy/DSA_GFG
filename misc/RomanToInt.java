package misc;

import java.util.Map;
import java.util.Scanner;

public class RomanToInt
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(romanToInt(s));
    }
    public static int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> map = Map.of(
            'I', 1, 'V', 5, 'X', 10, 'L', 50,
            'C', 100, 'D', 500, 'M', 1000);
        int n = s.length();
        for(int i = 0; i < n; i += 2) {
            if(i == n - 1) {
                //we can get only one char
                char first = s.charAt(i);
                int firstValue = map.get(first);
                res += firstValue;
            } else {
                char first = s.charAt(i);
                char second = s.charAt(i + 1);
                int firstValue = map.get(first);
                int secondValue = map.get(second);
                //if first is larger/equal
                if(firstValue >= secondValue) {
                    //consider only one
                    res += firstValue;
                    i--;
                } else {
                    res += secondValue - firstValue;
                }
            }
        }
        return res;
    }
}
