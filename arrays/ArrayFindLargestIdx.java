package arrays;
import java.util.*;

import utils.FastReader;

public class ArrayFindLargestIdx {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
						  .map(Integer::parseInt)
						  .mapToInt(Integer::valueOf)
						  .toArray();
		// System.out.println(Arrays.toString(arr));
		System.out.println(naive(arr)); //O(n ^ 2)
		System.out.println(findIdxOfLargest(arr)); //Theta(n)
		
	}
	static int naive(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			boolean flag = true; //assume arr[i] is largest
			for(int j = 0; j < arr.length; j++) { //check if someone is larger than arr[i]
				if(arr[j] > arr[i]) {
					flag = false;
					break;
				}
			}
			if(flag == true) {
				return i;
			}
		}
		return -1;	//this line is never reached but should return something to make compiler happy
	}
	static int findIdxOfLargest(int[] arr) {
		//assume arr[0] is largest and start:
		int idxOfLargest = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > arr[idxOfLargest]) idxOfLargest = i;
		}
		return idxOfLargest;
	}
}