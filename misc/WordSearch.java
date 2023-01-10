package misc;

import java.util.Scanner;

public class WordSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte m = sc.nextByte();
        byte n = sc.nextByte();
        char[][] board = new char[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }
        String word = sc.next();
        boolean[][] visited = new boolean[m][n];
        boolean finalRes = false;
        outer: for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean res = exist(board, i, j, word, 0, visited);
                if(res) {
                    finalRes = true;
                    break outer;
                }
            }
        }
        System.out.println(finalRes);
    }

    public static boolean exist(char[][] board, int i, int j, String word, int idx, boolean[][] visited)
    {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j])
        {
            return false;
        }
        char currChar = board[i][j];
        if (!visited[i][j] && currChar == word.charAt(idx))
        {
            //base-case:
            if (idx == word.length() - 1)
            {
                return true;
            }

            //recursive-case:
            visited[i][j] = true;
            //get all the neighbours one by one (tldr)
            boolean res1 = exist(board, i - 1, j, word, idx + 1, visited);     //top
            boolean res2 = exist(board, i, j - 1, word, idx + 1, visited);     //left
            boolean res3 = exist(board, i + 1, j, word, idx + 1, visited);     //down
            boolean res4 = exist(board, i, j + 1, word, idx + 1, visited);     //right

            visited[i][j] = false;
            return (res1 || res2 || res3 || res4);
        }
        return false;
    }
}
