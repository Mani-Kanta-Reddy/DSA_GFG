package dp;

import java.util.Scanner;

public class ClimbingStairs
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long before = System.currentTimeMillis();
//        int res = totalPossibilities(n);
        long timeTaken = System.currentTimeMillis() - before;
        int[] qbank = new int[n + 1];
        long before1 = System.currentTimeMillis();
//        int res1 = totalPossibilitiesMemoized(n, qbank);
        long timeTaken1 = System.currentTimeMillis() - before1;
//        System.out.println(res);
        System.out.println("Time taken by blind recursion " + timeTaken);
        System.out.println("Time taken by smart recursion " + timeTaken1);
        tabulation(n);
    }
    public static int totalPossibilities(int n) {
        //positive base-case:
        if(n == 0)
            return 1;
        //negative-basecase:
        if(n < 0)
            return 0;
        //recursive-basecase:
        int t1 = totalPossibilities(n - 1);
        int t2 = totalPossibilities(n - 2);
        int t3 = totalPossibilities(n - 3);
        return t1 + t2 + t3;
    }
    public static int totalPossibilitiesMemoized(int n, int[] qbank) {
        //positive basecase:
        if(n == 0) {
            qbank[n] = 1;
            return qbank[n];
        }
        //negative basecase:
        if(n < 0) {
            return 0;
        }
        if(qbank[n] != 0) {
            return qbank[n];
        }
        //recursive basecase:
        int t1 = totalPossibilitiesMemoized(n - 1, qbank);
        int t2 = totalPossibilitiesMemoized(n - 2, qbank);
        int t3 = totalPossibilitiesMemoized(n - 3, qbank);
        qbank[n] = t1 + t2 + t3;
        return qbank[n];
    }
    public static int tabulation(int n) {
        //base-case / initialization

        //negative case handle intelligently

        //recursive-case
    }
}
