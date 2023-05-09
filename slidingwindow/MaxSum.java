package slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSum
{
    public static void main(String[] args) throws IOException
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] arr = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer :: parseInt).toArray();
            int k = Integer.parseInt(br.readLine());
            System.out.println(findMaxSum(arr, k));
        }
    }

    private static int findMaxSum(int[] arr, int k)
    {
        int start = 0, end = 0, size = arr.length, sum = 0, max = Integer.MIN_VALUE;
        while(end < size) {
            sum += arr[end];
            if(end - start + 1 == k) {
                max = Math.max(max, sum);
                sum -= arr[start];
                start++;
            }
            end++;
        }
        return max;
    }
}
