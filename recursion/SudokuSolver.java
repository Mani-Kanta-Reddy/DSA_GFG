package recursion;

import java.util.Arrays;
import java.util.Scanner;

/*
Input:
38
0 0 2
0 4 1
0 7 7
0 8 8
1 2 8
1 6 4
1 8 9
2 0 4
2 1 3
2 3 9
2 4 2
2 7 6
2 8 1
3 0 1
3 3 6
3 6 9
3 7 8
3 8 4
4 0 9
4 4 3
4 6 2
4 8 7
5 2 2
5 5 9
5 6 6
5 7 1
6 1 7
6 4 8
6 8 6
7 0 8
7 3 3
7 6 7
7 8 5
8 0 6
8 1 4
8 2 9
8 4 5
8 8 2
 */
public class SudokuSolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[9][9];
        int inputs = sc.nextInt();
        for(int i = 0; i < inputs; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            board[row][col] = sc.nextInt();
        }
        solveSudoku(board, 0, 0);
    }
    public static void solveSudoku(int[][] board, int row, int col) {
        if(row == board.length) {
            printBoard(board);
            return;
        }
        /* 
        Also works: 
            int nrow = row;
            int ncol = col + 1;
            if(col == board.length) {
                nrow = row + 1;
                ncol = 0;
                col = 0;
            }
         */
        int nrow = 0; 
        int ncol = 0;
        if(col == board.length - 1) {
            nrow = row + 1;
            ncol = 0;
        } else {
            nrow = row;
            ncol = col + 1;
        }
        if(board[row][col] != 0) {
            //pre-filled just make a next recursive call
            solveSudoku(board, nrow, ncol);
        } else {
            //time to explore :)
            for(int i = 1; i <= 9; i++) {
                if(isValid(board, row, col, i)) {
                    board[row][col] = i;
                    solveSudoku(board, nrow, ncol);
                    board[row][col] = 0; //backtracking
                }
            }
        }
    }
    public static void printBoard(int[][] board) {
        for(int[] arr : board) {
            System.out.println(Arrays.toString(arr));
        }
    }
    public static boolean isValid(int[][] board, int row, int col, int val) {
        //let's check row-wise
        for(int j = 0; j < board.length; j++) {
            if(board[row][j] == val) {
                return false;
            }
        }
        //then check col-wise
        for(int i = 0; i < board.length; i++) {
            if(board[i][col] == val) {
                return false;
            }
        }
        //then check grid
        int smi = row / 3 * 3;
        int smj = col / 3 * 3;
        //check the 3 * 3 sub-matrix
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[smi + i][smj + j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
