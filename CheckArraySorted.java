import java.util.*;
import java.io.*;

public class CheckArraySorted {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
						  .map(Integer::parseInt)
						  .mapToInt(Integer::valueOf)
						  .toArray();
		System.out.println(naiveCheckArraySorted(arr));	//O(n ^ 2)
		System.out.println(efficientCheckArraySorted(arr));	//O(n)
	}
	static boolean naiveCheckArraySorted(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[i]) return false;
			}
		}
		return true;
	}
	static boolean efficientCheckArraySorted(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < arr[i - 1])
				return false;
		}
		return true;
	}
}