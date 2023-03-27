package misc;

import java.util.Arrays;
import java.util.Scanner;

public class LongestPathInMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        char source = sc.next().charAt(0);
        char[][] maze = new char[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                maze[i][j] = sc.next().charAt(0);
            }
        }
        boolean[][] visited = new boolean[row][col];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(maze[i][j] == source) {
                    int res = computeMaxPath(maze, i, j, visited, 0, maze[i][j]);
                    max = Math.max(max, res);
                }
                
            }
        }
        System.out.println(max);
    }

    public static int computeMaxPath(char[][] maze, int i, int j, boolean[][] visited, int count, char source) {
        //base-case:
        if(i < 0 || j < 0 || i >= maze.length || j >= maze[0].length || visited[i][j] || maze[i][j] != source) {
            return count;
        }
        
        //recursive-case:
        visited[i][j] = true;
        char nxtSource = (char) (maze[i][j] + 1);
        count++;    //IMPORTANA!!!
        //recursive-cases:  anti-clockwise [t, uld, l, bld, d, brd, r, urd]
        int[] results = new int[8];
        results[0] = computeMaxPath(maze, i - 1, j, visited, count, nxtSource);  
        results[1] = computeMaxPath(maze, i - 1, j - 1, visited, count, nxtSource); 
        results[2] = computeMaxPath(maze, i, j - 1, visited, count, nxtSource);    
        results[3] = computeMaxPath(maze, i + 1, j - 1, visited, count, nxtSource);
        results[4] = computeMaxPath(maze, i + 1, j, visited, count, nxtSource);    
        results[5] = computeMaxPath(maze, i + 1, j + 1, visited, count, nxtSource);
        results[6] = computeMaxPath(maze, i, j + 1, visited, count, nxtSource);    
        results[7] = computeMaxPath(maze, i - 1, j + 1, visited, count, nxtSource);
        //backtracking
        visited[i][j] = false;
        return Arrays.stream(results).max().getAsInt();
        
    }
}
