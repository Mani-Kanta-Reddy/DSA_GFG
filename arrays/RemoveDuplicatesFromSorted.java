package arrays;
import java.util.*;

import utils.FastReader;

public class RemoveDuplicatesFromSorted {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
						  .map(Integer::parseInt)
						  .mapToInt(Integer::valueOf)
						  .toArray();

		int res = naiveRemoveDuplicates(arr); // O(n) time & O(n) space
		System.out.println(res);
		System.out.println(Arrays.toString(arr));
		int sol = efficientRemoveDuplicates(arr); // O(n) time & O(1) space
		System.out.println(Arrays.toString(arr));
	}
	static int naiveRemoveDuplicates(int[] arr) {
		int[] temp = new int[arr.length];
		temp[0] = arr[0]; //If all the elems are equal also the first should present
		int sizeToConsider = 1;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] != temp[sizeToConsider - 1]) {
				temp[sizeToConsider] = arr[i];
				sizeToConsider++;
			}
		}
		//copy back to original
		for(int i = 0; i < sizeToConsider; i++) {
			arr[i] = temp[i];
		}
		return sizeToConsider;
	}
	static int efficientRemoveDuplicates(int[] arr) {
		int sizeToConsider = 1;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] != arr[sizeToConsider - 1]) {
				arr[sizeToConsider] = arr[i];
				sizeToConsider++;
			}
		}
		return sizeToConsider;
	}
}