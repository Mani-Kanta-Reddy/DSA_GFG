package misc;

import java.util.Scanner;

public class MakeTheStringGreat
{
    //Leetcode
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(new MakeTheStringGreat().makeGood(s));
    }
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        if(s.isBlank() || s.isEmpty() || s.length() == 1) {
            return s;
        } else {
            for(int i = 0; i < sb.length() - 1; i++) {
                if(Math.abs(sb.charAt(i) - sb.charAt(i + 1)) == 32) {
                    sb.delete(i, i + 2);
                    i = -1;
                }
            }
        }
        return sb.toString();
    }
}
