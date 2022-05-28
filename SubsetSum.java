import java.util.*;
import java.io.*;

public class SubsetSum {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
		.map(Integer::parseInt)
		.mapToInt(Integer::valueOf)
		.toArray();
		// System.out.println(Arrays.toString(arr));
		int n = arr.length;
		int sum = sc.nextInt();

		System.out.println(subsetsum(arr, n, sum));
	}
	static int subsetsum(int[] arr, int n, int sum) {
		//base-case:
		if(n == 0) return sum == 0 ? 1 : 0;
		//recursive-case:
		return subsetsum(arr, n - 1, sum) + subsetsum(arr, n - 1, sum - arr[n - 1]);
	}
}