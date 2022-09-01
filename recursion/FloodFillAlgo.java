package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class FloodFillAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maze = new int[n][m];   //[[, , ], [, , ], [, ,]]
        boolean[][] visited = new boolean[n][m];
        int blockings = sc.nextInt();
        for(int counter = 0; counter < blockings; counter++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            maze[i][j] = 1;
        }

        for(int[] arr: maze) {
            System.out.println(Arrays.toString(arr));
        }


        findAllPaths(maze, 0, 0, "", visited);

    }
    public static void findAllPaths(int[][] maze, int r, int c, String psf, boolean[][] visited) {
        //base-case
        //negative-base-case
        if(r < 0 || c < 0 || r >= maze.length || c >= maze[0].length || maze[r][c] == 1 || visited[r][c] == true) {
            return;
        }
        //positive-case
        if(r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(psf);
            return;
        }
        //recursive-case    tldr
        visited[r][c] = true;
        findAllPaths(maze, r - 1, c, psf + "t", visited); //top-move
        findAllPaths(maze, r, c - 1, psf + "l", visited); //left-move
        findAllPaths(maze, r + 1, c, psf + "d", visited); //down-move
        findAllPaths(maze, r, c + 1, psf + "r", visited); //right-move
        visited[r][c] = false;
    }
}
