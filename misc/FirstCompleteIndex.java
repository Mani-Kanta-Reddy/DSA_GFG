package misc;

import java.util.HashMap;
import java.util.Map;

public class FirstCompleteIndex
{
    public static void main(String[] args)
    {
        int[] arr = {2,8,7,4,1,3,5,6,9};
        int[][] mat = {
            { 3,2,5},
            {1, 4, 5},
            {8, 7, 9}
        };
        System.out.println(firstCompleteIndex(arr, mat));
    }

    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> lookup = new HashMap<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                lookup.put(mat[i][j], new int[] {i, j});
            }
        }
        int[] a = new int[mat.length];
        int[] b = new int[mat[0].length];
        for(int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            //scan mat
            int[] position = lookup.get(curr);
            int row = position[0];
            int col = position[1];
            a[row]++; b[col]++;
            if(a[row] == mat[0].length || b[col] == mat.length) return i;
        }
        return -1;
    }
}
