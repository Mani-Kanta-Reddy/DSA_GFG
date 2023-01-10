package math;

import java.util.Scanner;

public class FindX
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        findX(a, b, c);
    }
    public static void findX(int a, int b, int c) {
        int res = -1;
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            if(((a | i) & (b | i)) == c) {
                res = i;
                break;
            }
        }
        System.out.println(res);
    }
}
