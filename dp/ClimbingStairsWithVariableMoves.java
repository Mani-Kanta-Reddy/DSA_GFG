package dp;

import java.util.Scanner;

public class ClimbingStairsWithVariableMoves {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] maxPossibleSteps = new int[n];
        for(int i = 0; i < n; i++) {
            maxPossibleSteps[i] = sc.nextInt();
        }
//        System.out.println(findTotalPossibilities(0, maxPossibleSteps, n));
//        System.out.println(findTotalPossibilitiesMemoized(0, maxPossibleSteps, n, new int[n + 1]));
        System.out.println(findTotalPossibilitiesTopDown(n, maxPossibleSteps, new int[n + 1]));
    }
    public static int findTotalPossibilities(int n, int[] maxPossibleSteps, int noOfStairs) {
        //positive base-case
        if(n == noOfStairs)
            return 1;
        //negative base-case
        if(n >= noOfStairs)
            return 0;
        //recursive case
        int currPossibilities = 0;
        for (int stepsPossible = 1; stepsPossible <= maxPossibleSteps[n]; stepsPossible++) {
            //handle carefully :( array index may out bound
            currPossibilities += findTotalPossibilities(n + stepsPossible, maxPossibleSteps, noOfStairs);
        }
        return currPossibilities;
    }
    public static int findTotalPossibilitiesMemoized(int n, int[] maxPossibleSteps, int noOfStairs, int[] qbank) {
        //positive base-case:
        if(n == noOfStairs) {
            qbank[n] = 1;
            return qbank[n];
        }
        //negative base-case:
        if(n >= noOfStairs)
            return 0;
        //check if already solved
        if(qbank[n] != 0)
            return qbank[n];

        //recursive case
        int currPossibilities = 0;
        for (int stepsPossible = 1; stepsPossible <= maxPossibleSteps[n]; stepsPossible++) {
            //handle carefully :( array index may out bound
            currPossibilities += findTotalPossibilities(n + stepsPossible, maxPossibleSteps, noOfStairs);
        }
        qbank[n] = currPossibilities;
        return qbank[n];
    }
    public static int findTotalPossibilitiesTopDown(int n, int[] maxPossibilities, int[] dp) {
        //base-case/initialisation
        dp[n] = 1;
        //recursive case
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 1; j <= maxPossibilities[i]; j++) {
                //handle carefully :(
                if(i + j <= n) {
                    dp[i] += dp[i + j];
                }
            }
        }
        return dp[0];
    }
}
