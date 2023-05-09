package slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FirstNegative
{
    public static void main(String[] args) throws IOException
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] arr = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int k = Integer.parseInt(br.readLine());
            firstNegatives(arr, k);
        }
    }

    private static void firstNegatives(int[] arr, int k)
    {
        int start = 0, end = 0, size = arr.length;
        Queue<Integer> queue = new ArrayDeque<>();

        while(end < size) {
            if(arr[end] < 0) queue.offer(arr[end]);

            if(end - start + 1 == k) {
                if(queue.isEmpty()) System.out.println(0);
                else {
                    System.out.println(queue.peek());
                    if(arr[start] < 0) queue.poll();
                    start++;
                }
            }
            end++;
        }
    }
}
