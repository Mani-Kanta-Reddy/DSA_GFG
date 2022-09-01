package misc;

import java.util.Arrays;
import java.util.Scanner;

public class TheNextBigThing
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] result = new int[N];

        for(int i = 0; i < N - 1; i++) {
            boolean isFound = false;
            for(int j = i + 1; j < N; j++) {
                if(arr[j] > arr[i]) {
                    result[i] = arr[j];
                    isFound = true;
                    break;
                }
            }
            if(!isFound) {
                result[i] = -1;
            }
        }
        result[N - 1] = -1;


        for(int val : result) {
            System.out.printf("%d ", val);
        }
    }
}
