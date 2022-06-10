package misc; 

import java.util.Scanner;

public class FindNoOfCharsRemainsSame {
    public static void main(String[] args) {
        /*
        Input: alphxxdida
        Output: 4
        Explanation: rev(input) -> adidxxhpla
                        input   -> alphxxdida
                        `a` @0, `x` @ 4,5, `a` @9 total = 4
        */
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int count = countCharsThatRemainsSame(s); //O(n) | O(n)
        System.out.println(count);
        System.out.println(countCharsThatRemainsSameEfficient(s));
    }

    static int countCharsThatRemainsSameEfficient(String str) {
        int count = 0;
        for(int i = 0, j = str.length() - 1; i < str.length(); i++, j--) {
            if(str.charAt(i) == str.charAt(j))
                count++;
        }
        return count;
    }

    static int countCharsThatRemainsSame(String s) {
        //Reverse given String `s` 
        //or use StringBuilder to use reverse() {s.reverse()}
        StringBuilder rev = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            rev.append(s.charAt(i));
        }
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == rev.charAt(i))
                count++;
        }
        return count;
    }
}
