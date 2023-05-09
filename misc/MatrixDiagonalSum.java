package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MatrixDiagonalSum
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] mat = new int[n][n];
        for(int i = 0; i < n; i++) {
            mat[i] = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        }
        matrixDiagonalSum(mat);
        br.close();
    }

    private static int matrixDiagonalSum(int[][] mat)
    {
        //since square matrix if odd rows then overlap otherwise no overlap
        boolean isOverlap = (mat.length & 1) != 0;
        int sum = 0;
        //compute normally
        for(int i = 0, j = mat.length; i < mat.length && j > 0; i++, j--) {
            sum += mat[i][i] + mat[mat.length - j][j - 1];
        }
        //if overlap subtract mid value one time
        return isOverlap ? sum - mat[mat.length / 2][mat.length / 2] : sum;
    }
}
