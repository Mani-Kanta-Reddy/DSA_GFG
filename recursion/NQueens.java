package recursion;

import java.util.Scanner;

public class NQueens
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] chess = new int[n][n];
        nQueens(chess, 0, "");
    }
    public static void nQueens(int[][] chess, int row, String psf) {
        //base-case:
        if(row == chess.length) {
            System.out.println(psf);
            return;
        }
        //recursive-case
        for(int c = 0; c < chess.length; c++) {
            //place safely
            if(isSafeToPlaceTheQueen(chess, row, c)) {
                chess[row][c] = 1;
                nQueens(chess, row + 1, psf + row + ", " + c + " | ");
                chess[row][c] = 0;
            }
        }
    }
    public static boolean isSafeToPlaceTheQueen(int[][] chess, int row, int col) {
        //upper-section
        for(int i = row - 1; i >= 0; i--) {
            if(chess[i][col] == 1) {
                return false;
            }
        }
        //upper-right-diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if(chess[i][j] == 1) {
                return false;
            }
        }
        //upper-left-diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(chess[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
