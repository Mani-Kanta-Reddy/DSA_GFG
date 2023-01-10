package dp;

import java.util.Scanner;

public class TargetSumSubsets
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        printTargetSubsets(arr, target, 0, "", n - 1);
    }

    public static void printTargetSubsets(int[] arr, int target, int acc, String asf, int n)
    {
        //base-case:
        if (acc == target)
        {
            System.out.println("[" + asf + "]");
            return;
        }

        if (n < 0)
        {
            return;
        }

        //recursive-case:
        //include
        printTargetSubsets(arr, target, acc + arr[n], asf + arr[n] + " ", n - 1);
        //not-include
        printTargetSubsets(arr, target, acc, asf, n - 1);
    }
}
