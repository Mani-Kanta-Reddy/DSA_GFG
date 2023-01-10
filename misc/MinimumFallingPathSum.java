package misc;

import java.util.Scanner;

public class MinimumFallingPathSum
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][][] dp = new int[n][n][300];
        int finalRes = Integer.MAX_VALUE;
        for(int col = 0; col < n; col++)
        {
            int res = getMinFallingSum(matrix, 0, col, 0, dp);
            finalRes = Math.min(finalRes, res);
        }
        System.out.println(finalRes);
    }
    public static int getMinFallingSum(int[][] matrix, int row, int col, int acc, int[][][] dp) {
        //base-case:
        if(row >= matrix.length) {
            return acc;
        }

        //negative base-case:
        if(col < 0 || col >= matrix.length) {
            return Integer.MAX_VALUE;
        }

        //answer exists case:
        if(dp[row][col][acc] != 0) {
            return dp[row][col][acc];
        }

        //recursive case:
        int res1 = getMinFallingSum(matrix, row + 1, col - 1, acc + matrix[row][col], dp);      //bottom left-diag
        int res2 = getMinFallingSum(matrix, row + 1, col, acc + matrix[row][col], dp);              //immediately below
        int res3 = getMinFallingSum(matrix, row + 1, col + 1, acc + matrix[row][col], dp);      //bottom right-diag
        return dp[row][col][acc] = Math.min(res1, Math.min(res2, res3));
    }
}
