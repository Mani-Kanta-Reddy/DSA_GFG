package misc;

import java.util.Arrays;
import java.util.Scanner;

public class FindS2IsRightRotatedOfS1 {
    public static void main(String[] args) {
        /*
        Input: sample
               plesam
        Output: 1 
        */
        Scanner sc = new Scanner(System.in);
        char[] s1 = sc.next().toCharArray();
        char[] s2 = sc.next().toCharArray();
        int result = -1;
        if(s1.length != s2.length)
            System.out.println(result);
        else {
            for(int i = 0; i < s1.length; i++) {
                char lastChar = s1[s1.length - 1];
                for(int j = s1.length - 1; j > 0; j--) {
                    s1[j] = s1[j - 1];
                }
                s1[0] = lastChar;
                if(Arrays.equals(s1, s2)) {
                    result = 1;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
