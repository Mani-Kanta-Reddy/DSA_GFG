import java.util.*;
import java.io.*;

public class ReverseArray {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
						  .map(Integer::parseInt)
						  .mapToInt(Integer::valueOf)
						  .toArray();
		reverseArray(arr);
		System.out.println(Arrays.toString(arr));
	}
	static int[] reverseArray(int[] arr) {
		// two pointer approach

		// 1 2 3 4 5
		// step 1: swap arr[i],arr[j] => 5 2 3 4 1
		// step 2: swap arr[i + 1], arr[j - 1] => 5 4 3 2 1
		// step 3: swap arr[i + 2], arr[j - 2] => if there are odd no.of elements i, j will be same stop:

		int i, j;
		i = 0;
		j = arr.length - 1;
		while(i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
		return arr;
	}
	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}	