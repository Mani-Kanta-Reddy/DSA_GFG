package sort;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, n);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int k = partition(arr, low, high);
            quickSort(arr, low, k);
            quickSort(arr, k + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low, j = high;
        while(i < j) {
            do {
                i++;
            } while(i <= arr.length - 1 && arr[i] <= pivot);
            do {
                j--;
            } while(j >= 0 && arr[j] > pivot);
            if(i < j) {
                //swap arr[i] with arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //finally swap arr[j] with arr[low] (pivot)
        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;
        return j;
    }
}
