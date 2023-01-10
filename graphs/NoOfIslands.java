package graphs;

import java.util.Scanner;

public class NoOfIslands
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 0) {
                    noOfIslands(grid, i, j, visited);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void noOfIslands(int[][] grid, int row, int col, boolean[][] visited) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == 1) {
            return;
        }

        visited[row][col] = true;

        noOfIslands(grid, row - 1, col, visited);   //North
        noOfIslands(grid, row + 1, col, visited);   //South
        noOfIslands(grid, row, col + 1, visited);   //East
        noOfIslands(grid, row, col - 1, visited);   //West
    }
}
